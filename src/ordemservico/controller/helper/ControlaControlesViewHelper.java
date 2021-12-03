
package ordemservico.controller.helper;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.text.DefaultFormatterFactory;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;
import ordemservico.util.DocumentNumeric;
import ordemservico.util.UtilMascaras;
import ordemservico.view.ViewOs;

/**
 *
 * @author Tiago Teixeira
 */
public class ControlaControlesViewHelper {
    private ViewOs view;
   
    public ControlaControlesViewHelper(Object view) {
        this.view = (ViewOs) view;

    }
    /**
     * tipo 1 iniciando, tipo 2 novo, 3 buscando
     * @param tipoEntrada 
     */
    public void habilitaBotoes(int tipoEntrada){
        switch (tipoEntrada) {
            case 1: //iniciando a view (sistema)
                view.getjButtonExcluir().setEnabled(false);
                view.getjButtonImprimir().setEnabled(false);
                view.getjButtonNovo().setEnabled(true);
                view.getjButtonGravar().setEnabled(false);
                view.getjButtonAddItem().setEnabled(false);
                break;
            case 2: // clicando no botão de novo
                view.getjButtonExcluir().setEnabled(false);
                view.getjButtonImprimir().setEnabled(false);
                view.getjButtonNovo().setEnabled(true);
                view.getjButtonGravar().setEnabled(true);
                view.getjButtonAddItem().setEnabled(true);
                break;
            case 3: // vizualizando um registro
                view.getjButtonExcluir().setEnabled(true);
                view.getjButtonImprimir().setEnabled(true);
                view.getjButtonNovo().setEnabled(true);
                view.getjButtonGravar().setEnabled(false);
                view.getjButtonAddItem().setEnabled(false);
                break;
            default:
        }
    
    }
    
    /**
     * set default values in components the view
     */
    public void limpaTela() {
        view.getjTableHistorico().setModel(new TabelaListaOsHelper(new ArrayList<OrdemServicoModel>()));
        view.getjTableServPecas().setModel(new TabelaListaServicoPecaHelper(new ArrayList<PecaServicoModel>()));
        view.getjTextAreaDefeito().setText("");
        view.getjTextAreaSolucao().setText("");
        view.getjTextFieldBusca().setText("");
        view.getjTextFieldCliBairro().setText("");
        view.getjTextFieldCliCelular().setText("");
        view.getjTextFieldCliCep().setText("");
        view.getjTextFieldCliCidade().setText("");
        view.getjTextFieldCliCpf().setText("");
        view.getjTextFieldCliEstado().setText("");
        view.getjTextFieldCliNome().setText("");
        view.getjTextFieldCliNumero().setText("");
        view.getjTextFieldCliRG().setText("");
        view.getjTextFieldCliRua().setText("");
        view.getjTextFieldDataChegada().setText("");
        view.getjTextFieldDataEntrega().setText("");
        view.getjTextFieldDescricaoItem().setText("");
        view.getjTextFieldNmMecanico().setText("");
        view.getjTextFieldQtd().setText("");
        view.getjTextFieldTotalItem().setText("");
        view.getjTextFieldValorUnItem().setText("");
        view.getjTextFieldVeicCor().setText("");
        view.getjTextFieldVeicMarca().setText("");
        view.getjTextFieldVeicModelo().setText("");
        view.getjTextFieldVeicNome().setText("");
        view.getjTextFieldVeicPlaca().setText("");
        view.getjComboBoxTipoItem().setSelectedIndex(0);
    }
    /**
     * true or false enable or disable controls
     * @param value 
     */
    public void controleJtext(boolean value) {

        view.getjTableHistorico().setEnabled(true);
        view.getjTableServPecas().setEnabled(value);
        view.getjTextAreaDefeito().setEnabled(value);
        view.getjTextAreaSolucao().setEnabled(value);
        view.getjTextFieldBusca().setEnabled(value);
        view.getjTextFieldCliBairro().setEnabled(value);
        view.getjTextFieldCliCelular().setEnabled(value);
        view.getjTextFieldCliCep().setEnabled(value);
        view.getjTextFieldCliCidade().setEnabled(value);
        view.getjTextFieldCliCpf().setEnabled(value);
        view.getjTextFieldCliEstado().setEnabled(value);
        view.getjTextFieldCliNome().setEnabled(value);
        view.getjTextFieldCliNumero().setEnabled(value);
        view.getjTextFieldCliRG().setEnabled(value);
        view.getjTextFieldCliRua().setEnabled(value);
        view.getjTextFieldDataChegada().setEnabled(value);
        view.getjTextFieldDataEntrega().setEnabled(value);
        view.getjTextFieldDescricaoItem().setEnabled(value);
        view.getjTextFieldNmMecanico().setEnabled(value);
        view.getjTextFieldQtd().setEnabled(value);
        view.getjTextFieldTotalItem().setEnabled(value);
        view.getjTextFieldValorUnItem().setEnabled(value);
        view.getjTextFieldVeicCor().setEnabled(value);
        view.getjTextFieldVeicMarca().setEnabled(value);
        view.getjTextFieldVeicModelo().setEnabled(value);
        view.getjTextFieldVeicNome().setEnabled(value);
        view.getjTextFieldVeicPlaca().setEnabled(value);
        view.getjComboBoxTipoItem().setEnabled(value);
    }
    
    
    public void controleDigitacao(){
        view.getjTextFieldCliCep().setDocument(new DocumentNumeric());
        view.getjTextFieldCliRG().setDocument(new DocumentNumeric());
        view.getjTextFieldCliCpf().setDocument(new DocumentNumeric());
        view.getjTextFieldQtd().setDocument(new DocumentNumeric());
        view.getjTextFieldTotalItem().setDocument(new DocumentNumeric());
        view.getjTextFieldValorUnItem().setDocument(new DocumentNumeric());
    }
    
    
    public void adicianarMascaras(){
        
        try {
            view.getjTextFieldCliCelular().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraCelular(view.getjTextFieldCliCelular())));
            view.getjTextFieldDataChegada().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraData(view.getjTextFieldDataChegada())));
            view.getjTextFieldDataEntrega().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraData(view.getjTextFieldDataEntrega())));
        } catch (ParseException ex) {
            
        }
    }
    
}
