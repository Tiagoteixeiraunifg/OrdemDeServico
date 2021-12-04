
package ordemservico.controller;


import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import ordemservico.controller.helper.ControlaControlesViewHelper;
import ordemservico.controller.helper.TabelaListaOsHelper;
import ordemservico.controller.helper.ValidationObjectOsModel;
import ordemservico.dao.OsDao;
import ordemservico.model.ClienteModel;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;
import ordemservico.service.OsService;
import ordemservico.util.Util;
import ordemservico.view.ViewOs;

/**
 *
 * @author Tiago Teixeira
 */
public class ControllerOS implements IController{

    private ViewOs viewOs;
    private OsService osService;
    private OrdemServicoModel osModel;
    private ControlaControlesViewHelper ControlsHelper;
    private PecaServicoModel askServiceModel;
    private NumberFormat FormatterMoeda;
    private Locale locale;
    private boolean precionadoNovo = false;
    private boolean precionadoEditar = false;
    private boolean precionadoEditarItem = false;
    private boolean precionadoExcluirItem = false;
    private boolean osSalvo = false;
    private boolean osItemSalvo = false;
    private boolean usoAddItem = false;
    private boolean retOK = true;
    private ValidationObjectOsModel validationTexts;
    
    @Override
    public void executa(Object objeto) {
          //toda inicialização da jframe aqui
        this.viewOs = (ViewOs) objeto;
        osService = new OsService();
        osModel = new OrdemServicoModel();
        askServiceModel = new PecaServicoModel();
        ControlsHelper = new ControlaControlesViewHelper(viewOs);
        validationTexts = new ValidationObjectOsModel(viewOs);
        locale = new Locale("pt", "BR");
        FormatterMoeda = NumberFormat.getCurrencyInstance(locale);        
        ControlsHelper.habilitaBotoes(1);
        ControlsHelper.controleJtext(false);
        ControlsHelper.controleDigitacao();
        ControlsHelper.adicianarMascaras();
        try {
            carregaTabela(osService.findAll()); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro: "+ ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    
    private void carregaTabela(ArrayList<OrdemServicoModel> list){
        TabelaListaOsHelper modelTable= new TabelaListaOsHelper(list);
        viewOs.getjTableHistorico().setModel(modelTable);
    }
    
    private void pesquisarTabela(String parametro){
        TabelaListaOsHelper modelTable= new TabelaListaOsHelper(osService.findByParameter(parametro));
        viewOs.getjTableHistorico().setModel(modelTable);
    }
    
    public void jTextFiltroTabela(){
        pesquisarTabela(viewOs.getjTextFieldBusca().getText());
    }
    
    public void salveItemLoose(PecaServicoModel obj){
        try {
            osService.saveItemServPec(obj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro ao Salvar: "+ ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void jButtonNovo() {
        if (!precionadoNovo && !precionadoEditar) {
            viewOs.getjTabbedPaneSeparacao().setSelectedIndex(1);
            osSalvo = false;
            precionadoNovo = true;
            ControlsHelper.controleJtext(true);
            ControlsHelper.habilitaBotoes(2);
            ControlsHelper.setIconBtnNv(1);
            ControlsHelper.limpaTela();
        } else if (precionadoNovo || precionadoEditar || osSalvo) {
            viewOs.getjTabbedPaneSeparacao().setSelectedIndex(0);
            precionadoNovo = false;
            precionadoEditar = false;
            ControlsHelper.controleJtext(false);
            ControlsHelper.habilitaBotoes(1);
            ControlsHelper.setIconBtnNv(2);
            if (!precionadoEditar) {
                ControlsHelper.limpaTela();
            }
        }

    }
    
    public void jButtonGravar(){
        validationTexts.validationJTexts();
    }
    
    public void jButtonAdd(){
        validationTexts.validationJTextsAskService();     
    }
    
    public void jTextValorUn(){
        double qtd = new Util().formataMoeda(viewOs.getjTextFieldQtd().getText());
        double vunit = new Util().formataMoeda(viewOs.getjTextFieldValorUnItem().getText().replace("R$", ""));
        double total = vunit * qtd; 
        viewOs.getjTextFieldValorUnItem().setText(FormatterMoeda.format(vunit));
        viewOs.getjTextFieldTotalItem().setText(FormatterMoeda.format(total));
        
    }
    
    private void loadObjItem(){
        askServiceModel.setTipo(viewOs.getjComboBoxTipoItem().getSelectedItem().toString());
        askServiceModel.setValorTotal(new Util().formataMoeda(viewOs.getjTextFieldTotalItem().getText().replace("R$", "")));
        askServiceModel.setValorUn(new Util().formataMoeda(viewOs.getjTextFieldValorUnItem().getText().replace("R$", "")));
        askServiceModel.setQuantidade(new Util().formataMoeda(viewOs.getjTextFieldQtd().getText()));
        askServiceModel.setDescricao(viewOs.getjTextFieldDescricaoItem().getText().toUpperCase());
        
    }
    
    
}
