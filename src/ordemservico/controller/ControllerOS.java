
package ordemservico.controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ordemservico.controller.helper.ControlaControlesViewHelper;
import ordemservico.controller.helper.TabelaListaOsHelper;
import ordemservico.dao.OsDao;
import ordemservico.model.ClienteModel;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;
import ordemservico.service.OsService;
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
    
    
    
    @Override
    public void executa(Object objeto) {
        this.viewOs = (ViewOs) objeto;
        osService = new OsService();
        osModel = new OrdemServicoModel();
        askServiceModel = new PecaServicoModel();
        ControlsHelper = new ControlaControlesViewHelper(viewOs);
        carregaTabela(osService.findAll());
        ControlsHelper.habilitaBotoes(1);
        ControlsHelper.controleJtext(false);
        ControlsHelper.controleDigitacao();
        ControlsHelper.adicianarMascaras();
        //toda inicialização da jframe aqui
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
}
