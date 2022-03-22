
package ordemservico.controller;


import com.formdev.flatlaf.util.SystemInfo;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ordemservico.controller.helper.ControlaControlesViewHelper;
import ordemservico.controller.helper.TabelaListaOsHelper;
import ordemservico.controller.helper.TabelaListaServicoPecaHelper;
import ordemservico.controller.helper.ValidationViewOsHelper;
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
    private ClienteModel cliModel;
    private ControlaControlesViewHelper ControlsHelper;
    TabelaListaServicoPecaHelper modelTableItem;
    private PecaServicoModel askServiceModel;
    private ArrayList<PecaServicoModel> listAskServiceModel;
    private NumberFormat FormatterMoeda;
    private Locale locale;
    private boolean precionadoNovo = false;
    private boolean precionadoEditar = false;
    private boolean precionadoEditarItem = false;
    private boolean precionadoExcluirItem = false;
    private boolean osSalvo = false;
    private boolean osItemSalvo = false;
    private boolean usoAddItem = false;
    private boolean clientNew = true;
    private ValidationViewOsHelper validationTexts;
    private int indexItemList = 0;
    
    @Override
    public void executa(Object objeto) {
          //toda inicialização da jframe aqui
        this.viewOs = (ViewOs) objeto;
        osService = new OsService();
        osModel = new OrdemServicoModel();
        askServiceModel = new PecaServicoModel();
        cliModel = new ClienteModel();
        listAskServiceModel = new ArrayList<>();
        modelTableItem = new TabelaListaServicoPecaHelper(listAskServiceModel);
        carregaTabelaItem();
        ControlsHelper = new ControlaControlesViewHelper(viewOs);
        validationTexts = new ValidationViewOsHelper(viewOs);
        locale = new Locale("pt", "BR");
        FormatterMoeda = NumberFormat.getCurrencyInstance(locale);        
        ControlsHelper.habilitaBotoes(1);
        ControlsHelper.controleJtext(false);
        ControlsHelper.controleDigitacao();
        ControlsHelper.adicianarMascaras();
        carregaTabela();

    }
    

    
    private void carregaTabela() {
        try {
            TabelaListaOsHelper modelTable = new TabelaListaOsHelper(osService.findAll());
            viewOs.getjTableHistorico().setModel(modelTable);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void carregaTabelaItem(){
        viewOs.getjTableServPecas().setModel(modelTableItem);
    }
    
    private void addItemTableItem(ArrayList<PecaServicoModel> obj){
       modelTableItem = new TabelaListaServicoPecaHelper(obj);
       carregaTabelaItem();
    }
    
    private void pesquisarTabela(String parametro) {
        try {
            TabelaListaOsHelper modelTable = new TabelaListaOsHelper(osService.findByParameter(parametro));
            viewOs.getjTableHistorico().setModel(modelTable);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
    
    public void jTextCpf(){
        String cpf = "";
        if(new Util().isValid(viewOs.getjTextFieldCliCpf().getText())){
            cpf = new Util().replaceDado(viewOs.getjTextFieldCliCpf().getText());
            try {
                cliModel = osService.getClientByCpf(cpf);
                if (cliModel.getIdCliente() != 0) {
                    if (cliModel.getCpf().equals(cpf)) {
                        clientNew = false;
                        loadFrameCli();
                    }
                }else{
                    clientNew = true;
                    viewOs.getjTextFieldCliRG().requestFocus();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(viewOs, "Erro: "+ ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(viewOs, "Erro CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            viewOs.getjTextFieldCliCpf().requestFocus();
            viewOs.getjTextFieldCliCpf().setValue("");
            viewOs.getjTextFieldCliCpf().setCaretPosition(1);
            
        }
   
    }
    
    public void jTextCpfFoco() {
        if(new Util().isValid(viewOs.getjTextFieldCliCpf().getText())){
            jTextCpf();
        }
        
    }
    
    public void jButtonNovo() {
        if (!precionadoNovo && !precionadoEditar) {
            osModel = new OrdemServicoModel();
            viewOs.getjTabbedPaneSeparacao().setSelectedIndex(1);
            viewOs.getjTextFieldCliCpf().requestFocus();
            osSalvo = false;
            precionadoNovo = true;
            ControlsHelper.controleJtext(true);
            ControlsHelper.habilitaBotoes(2);
            ControlsHelper.setIconBtnNv(1);
            ControlsHelper.limpaTela();
        } else if (precionadoNovo || precionadoEditar || osSalvo) {
            osModel = new OrdemServicoModel();
            askServiceModel = new PecaServicoModel();
            cliModel = new ClienteModel();
            listAskServiceModel.clear();
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
    
    public void jButtonGravar() {
        if (precionadoNovo && !precionadoEditar) {
            if (validationTexts.validationJTexts()) {
                if (loadObjOsClient()) {
                    if (saveOsModelDb()) {
                        carregaTabela();
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
            }
        } else if (precionadoEditar && !precionadoNovo) {
            if (validationTexts.validationJTexts()) {
                if (loadObjOsClient()) {
                    if (updateOsModelDb()) {
                        carregaTabela();
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
            }
        }
    }
    
    public void jButtonAdd() {
        if (precionadoEditarItem && !precionadoExcluirItem) {
            if (validationTexts.validationJTextsAskService()) {
                loadObjItem(true);
                updateAskService(askServiceModel);
                listAskServiceModel.set(indexItemList, askServiceModel);
                addItemTableItem(listAskServiceModel);
                ControlsHelper.limpaBlocoItem();
                viewOs.getjTextFieldDescricaoItem().requestFocus();
                precionadoExcluirItem = false;
                precionadoEditarItem = false;
                viewOs.getjButtonAddItem().setText("ADICIONAR");
            }
        } else if (!precionadoEditarItem && !precionadoExcluirItem) {
            if (precionadoEditar) {
                if (validationTexts.validationJTextsAskService()) {
                    loadObjItem(false);
                    saveAskModelDb(askServiceModel);
                    
                    listAskServiceModel = osService.findOsById(osModel.getIdOrdem()).getPecasSevico();
                    addItemTableItem(listAskServiceModel);
                    ControlsHelper.limpaBlocoItem();
                    viewOs.getjTextFieldDescricaoItem().requestFocus();
                }
            } else {
                if (validationTexts.validationJTextsAskService()) {
                    loadObjItem(false);
                    listAskServiceModel.add(askServiceModel);
                    addItemTableItem(listAskServiceModel);
                    ControlsHelper.limpaBlocoItem();
                    viewOs.getjTextFieldDescricaoItem().requestFocus();
                }
            }

        } else if (precionadoExcluirItem){
            if(deleteItemByIdItem(askServiceModel.getIdServPeca(), osModel.getIdOrdem())){
                listAskServiceModel.remove(indexItemList);
                addItemTableItem(listAskServiceModel);
                ControlsHelper.limpaBlocoItem();
                precionadoExcluirItem = false;
                precionadoEditarItem = false;
                viewOs.getjButtonAddItem().setText("ADICIONAR");
                viewOs.getjTextFieldDescricaoItem().requestFocus();
            }  
        }

        
    }

    public void jTextValorUn() {
        double qtd = new Util().formataMoeda(viewOs.getjTextFieldQtd().getText());
        double vunit = new Util().formataMoeda(viewOs.getjTextFieldValorUnItem().getText().replace("R$", ""));
        double total = vunit * qtd;
        viewOs.getjTextFieldValorUnItem().setText(FormatterMoeda.format(vunit));
        viewOs.getjTextFieldTotalItem().setText(FormatterMoeda.format(total));

    }
    
    public void jTableHistorico(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 1) {

            ControlsHelper.habilitaBotoes(3);

        } else if (evt.getClickCount() == 2) {
            precionadoNovo = false;
            precionadoEditar = true;
            loadFrameByObjct(osService.findOsById( (int) viewOs.getjTableHistorico().getValueAt(viewOs.getjTableHistorico().getSelectedRow(), 0)));
            ControlsHelper.controleJtext(true);
            ControlsHelper.setIconBtnNv(1);
            ControlsHelper.habilitaBotoes(2);
            viewOs.getjTabbedPaneSeparacao().setSelectedIndex(1);
        }
    }
    
    public void jTableItem(java.awt.event.MouseEvent evt){
        if(evt.getClickCount() == 1){
            precionadoExcluirItem = true;
            precionadoEditarItem = true;
            viewOs.getjButtonAddItem().setText("EXCLUIR");
            indexItemList = viewOs.getjTableServPecas().getSelectedRow();
            askServiceModel = listAskServiceModel.get(indexItemList);
            loadFrameItemByObject(askServiceModel);
        }else if(evt.getClickCount() == 2){
            viewOs.getjButtonAddItem().setText("SALVAR");
            precionadoExcluirItem = false;
            precionadoEditarItem = true;
            indexItemList = viewOs.getjTableServPecas().getSelectedRow();
            askServiceModel = listAskServiceModel.get(indexItemList);
            loadFrameItemByObject(askServiceModel);
        }
    }

    private boolean deleteItemByIdItem(int idItem, int idOs){
     boolean ret = false;
        try {
            if(osService.deleitemById(idItem, idOs)){
                ret = true;     
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ret = false;
        }
        return ret;
    }
    
    private void loadObjItem(boolean upd) {
        if(!upd){
             askServiceModel = new PecaServicoModel();
        }
        askServiceModel.setIdOrdem(osModel.getIdOrdem());
        askServiceModel.setTipo(viewOs.getjComboBoxTipoItem().getSelectedItem().toString());
        askServiceModel.setValorTotal(new Util().formataMoeda(viewOs.getjTextFieldTotalItem().getText().replace("R$", "")));
        askServiceModel.setValorUn(new Util().formataMoeda(viewOs.getjTextFieldValorUnItem().getText().replace("R$", "")));
        askServiceModel.setQuantidade(new Util().formataMoeda(viewOs.getjTextFieldQtd().getText()));
        askServiceModel.setDescricao(viewOs.getjTextFieldDescricaoItem().getText().toUpperCase());
    }
    
    private boolean loadObjOsClient() {
        boolean ret = true;
        if(!precionadoEditar){
            osModel = new OrdemServicoModel();
        }
        
        if (clientNew) {
            cliModel = new ClienteModel();
        }

        if (!new Util().isValid(viewOs.getjTextFieldCliCpf().getText())) {

            JOptionPane.showMessageDialog(viewOs, "Erro CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            viewOs.getjTextFieldCliCpf().requestFocus();
            viewOs.getjTextFieldCliCpf().setValue("");
            viewOs.getjTextFieldCliCpf().setCaretPosition(1);
            ret = false;
        } else if (!new Util().validaDataFormatoBR(viewOs.getjTextFieldDataChegada().getText())) {

            JOptionPane.showMessageDialog(viewOs, "Erro data chegada inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            viewOs.getjTextFieldDataChegada().setValue("");
            viewOs.getjTextFieldDataChegada().requestFocus();
            ret = false;
        } else if (!new Util().validaDataFormatoBR(viewOs.getjTextFieldDataEntrega().getText())) {

            JOptionPane.showMessageDialog(viewOs, "Erro data entrega inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            viewOs.getjTextFieldDataEntrega().setValue("");
            viewOs.getjTextFieldDataEntrega().requestFocus();
            ret = false;
        } else if (viewOs.getjTextFieldVeicPlaca().getText().length() > 7) {

            JOptionPane.showMessageDialog(viewOs, "Erro placa inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            viewOs.getjTextFieldVeicPlaca().selectAll();
            viewOs.getjTextFieldVeicPlaca().requestFocus();
            ret = false;
        } else if (viewOs.getjTextFieldVeicPlaca().getText().length() < 7) {

            JOptionPane.showMessageDialog(viewOs, "Erro placa inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            viewOs.getjTextFieldVeicPlaca().selectAll();
            viewOs.getjTextFieldVeicPlaca().requestFocus();
            ret = false;
        } else if (listAskServiceModel.size() <= 0) {

            JOptionPane.showMessageDialog(viewOs, "Erro sem serviço ou peças incluidas!", "Erro", JOptionPane.ERROR_MESSAGE);
            viewOs.getjTextFieldDescricaoItem().requestFocus();
            ret = false;
        } else if (ret) {

            cliModel.setCpf(new Util().replaceDado(viewOs.getjTextFieldCliCpf().getText()));
            cliModel.setRg(viewOs.getjTextFieldCliRG().getText());
            cliModel.setNome(viewOs.getjTextFieldCliNome().getText());
            cliModel.setRua(viewOs.getjTextFieldCliRua().getText());
            cliModel.setCidade(viewOs.getjTextFieldCliCidade().getText());
            cliModel.setEstado(viewOs.getjTextFieldCliEstado().getText());
            cliModel.setCep(viewOs.getjTextFieldCliCep().getText());
            cliModel.setCelular(new Util().replaceDado(viewOs.getjTextFieldCliCelular().getText()));
            cliModel.setNumero(viewOs.getjTextFieldCliNumero().getText().trim());
            cliModel.setBairro(viewOs.getjTextFieldCliBairro().getText());

            osModel.setCliente(cliModel);

            osModel.setNomeVeiculo(viewOs.getjTextFieldVeicNome().getText());
            osModel.setModeloVeiculo(viewOs.getjTextFieldVeicModelo().getText());
            osModel.setMarcaVeiculo(viewOs.getjTextFieldVeicMarca().getText());
            osModel.setCorVeiculo(viewOs.getjTextFieldVeicCor().getText());
            osModel.setMecanico(viewOs.getjTextFieldNmMecanico().getText());
            osModel.setRelatoMecanico(viewOs.getjTextAreaSolucao().getText());
            osModel.setDefeitoReclamado(viewOs.getjTextAreaDefeito().getText());
            osModel.setDataEntrega(new Util().dataFormatoUS(viewOs.getjTextFieldDataEntrega().getText()));
            osModel.setDataChegada(new Util().dataFormatoUS(viewOs.getjTextFieldDataChegada().getText()));
            osModel.setPlacaVeiculo(viewOs.getjTextFieldVeicPlaca().getText());
            osModel.setPecasSevico(listAskServiceModel);

        }
        return ret;
    }
    
    private boolean saveOsModelDb(){
        boolean ret = false;
        try {

            ret = osService.saveOs(osModel, clientNew);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return ret;
    }
    
    private boolean saveAskModelDb(PecaServicoModel obj){
        boolean ret = false;
        try {
            ret = osService.saveItemServPec(obj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return ret;
    }
    
    private boolean updateOsModelDb(){
        boolean ret = false;
        try {

            ret = osService.updateByObject(osModel);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ret = false;
        }
        return ret;
    }
    
    private boolean updateAskService(PecaServicoModel obj){
        boolean ret = false;
        try {
            ret = osService.updateByObjectItem(obj);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(viewOs, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ret = false;
        }
        return ret;
    }
    
    private void loadFrameCli() {

        viewOs.getjTextFieldCliBairro().setText(cliModel.getBairro());
        viewOs.getjTextFieldCliCelular().setText(cliModel.getCelular());
        viewOs.getjTextFieldCliCep().setText(cliModel.getCep());
        viewOs.getjTextFieldCliCidade().setText(cliModel.getCidade());
        viewOs.getjTextFieldCliCpf().setText(cliModel.getCpf());
        viewOs.getjTextFieldCliEstado().setText(cliModel.getEstado());
        viewOs.getjTextFieldCliNome().setText(cliModel.getNome());
        viewOs.getjTextFieldCliNumero().setText(cliModel.getNumero());
        viewOs.getjTextFieldCliRG().setText(cliModel.getRg());
        viewOs.getjTextFieldCliRua().setText(cliModel.getRua());
        viewOs.getjTextFieldVeicNome().requestFocus();
        viewOs.getjTextFieldVeicNome().setCaretPosition(0);

    }
    
    private void loadFrameByObjct(OrdemServicoModel obj){
        
        osModel = obj;
        cliModel = obj.getCliente();
        listAskServiceModel = obj.getPecasSevico();
        modelTableItem = new TabelaListaServicoPecaHelper(listAskServiceModel);
        loadFrameCli();
        
        viewOs.getjTableServPecas().setModel(modelTableItem);
        viewOs.getjTextAreaDefeito().setText(osModel.getDefeitoReclamado());
        viewOs.getjTextAreaSolucao().setText(osModel.getRelatoMecanico());        
        viewOs.getjTextFieldDataChegada().setText(new Util().dataFormatoBR(osModel.getDataChegada()));
        viewOs.getjTextFieldDataEntrega().setText(new Util().dataFormatoBR(osModel.getDataEntrega()));
        viewOs.getjTextFieldNmMecanico().setText(osModel.getMecanico());
        viewOs.getjTextFieldVeicCor().setText(osModel.getCorVeiculo());
        viewOs.getjTextFieldVeicMarca().setText(osModel.getMarcaVeiculo());
        viewOs.getjTextFieldVeicModelo().setText(osModel.getModeloVeiculo());
        viewOs.getjTextFieldVeicNome().setText(osModel.getNomeVeiculo());
        viewOs.getjTextFieldVeicPlaca().setText(osModel.getPlacaVeiculo());
 
        
        
        
    }
    
    private void loadFrameItemByObject(PecaServicoModel obj){
        viewOs.getjTextFieldQtd().setText(String.valueOf(obj.getQuantidade()).replace(".", ","));
        viewOs.getjTextFieldTotalItem().setText(FormatterMoeda.format(obj.getValorTotal()));
        viewOs.getjTextFieldValorUnItem().setText(FormatterMoeda.format(obj.getValorUn()));
        viewOs.getjComboBoxTipoItem().setSelectedItem(obj.getTipo());
        viewOs.getjTextFieldDescricaoItem().setText(obj.getDescricao());
    }
    
    
}
