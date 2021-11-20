
package ordemservico.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import ordemservico.controller.helper.TabelaListaOsHelper;
import ordemservico.model.OrdemServicoModel;
import ordemservico.service.OsSevice;
import ordemservico.util.DocumentNumeric;
import ordemservico.util.UtilMascaras;
import ordemservico.view.ViewOs;

/**
 *
 * @author Tiago Teixeira
 */
public class ControllerOS implements IController{

    private ViewOs viewOs;
    private OsSevice osService;
    private OrdemServicoModel osModel;
    
    @Override
    public void executa(Object objeto) {
        this.viewOs = (ViewOs) objeto;
        osService = new OsSevice();
        osModel = new OrdemServicoModel();
        carregaTabela(osService.findAll());
        controleDigitacao();
        adicianarMascaras();
        //toda inicialização da jframe aqui
    }
    
    private void controleDigitacao(){
        viewOs.getjTextFieldCliCep().setDocument(new DocumentNumeric());
        viewOs.getjTextFieldCliRG().setDocument(new DocumentNumeric());
        viewOs.getjTextFieldCliCpf().setDocument(new DocumentNumeric());
        viewOs.getjTextFieldQtd().setDocument(new DocumentNumeric());
        viewOs.getjTextFieldTotalItem().setDocument(new DocumentNumeric());
        viewOs.getjTextFieldValorUnItem().setDocument(new DocumentNumeric());
    }
    
    private void adicianarMascaras(){
        
        try {
            viewOs.getjTextFieldCliCelular().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraCelular(viewOs.getjTextFieldCliCelular())));
            viewOs.getjTextFieldDataChegada().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraData(viewOs.getjTextFieldDataChegada())));
            viewOs.getjTextFieldDataEntrega().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraData(viewOs.getjTextFieldDataEntrega())));
        } catch (ParseException ex) {
            
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
}
