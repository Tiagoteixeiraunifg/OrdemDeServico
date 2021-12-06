
package ordemservico.controller.helper;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.text.DefaultFormatterFactory;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;
import ordemservico.util.UtilDocumentNumeric;
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
    
    public void limpaBlocoItem(){
        view.getjTextFieldQtd().setText("1");
        view.getjTextFieldTotalItem().setText("R$0,00");
        view.getjTextFieldValorUnItem().setText("R$0,00");
        view.getjComboBoxTipoItem().setSelectedIndex(0);
        view.getjTextFieldDescricaoItem().setText("");
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
        view.getjTextFieldBusca().setEnabled(true);
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
        view.getjTextFieldCliCep().setDocument(new UtilDocumentNumeric());
        view.getjTextFieldCliRG().setDocument(new UtilDocumentNumeric());
        view.getjTextFieldQtd().setDocument(new UtilDocumentNumeric());
        view.getjTextFieldTotalItem().setDocument(new UtilDocumentNumeric());
        view.getjTextFieldValorUnItem().setDocument(new UtilDocumentNumeric());
    }
    
    
    public void adicianarMascaras(){
        
        try {
            view.getjTextFieldCliCelular().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraCelular(view.getjTextFieldCliCelular())));
            view.getjTextFieldDataChegada().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraData(view.getjTextFieldDataChegada())));
            view.getjTextFieldDataEntrega().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraData(view.getjTextFieldDataEntrega())));
            view.getjTextFieldCliCpf().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraCpf(view.getjTextFieldCliCpf())));
        } catch (ParseException ex) {
            
        }
    }
    
    /**
     * passando 1 para quando clicar em novo
     * passando 2 para qquando clicar em cancelar
     * @param funcao 
     */
    public void setIconBtnNv(int funcao) {
        
         switch (funcao) {
            case 1:
                view.getjButtonNovo().setText("CANCELAR");
                view.getjButtonNovo().setToolTipText("Clique aqui para cancelar a operacao");
                break;
            case 2:
                view.getjButtonNovo().setText("NOVO");
                view.getjButtonNovo().setToolTipText("Clique aqui para nova OS");
                break;
            default:
                break;
        }
    }
}
