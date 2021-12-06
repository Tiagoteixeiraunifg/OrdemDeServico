
package ordemservico.controller.helper;

import java.awt.Component;
import javax.swing.JOptionPane;
import ordemservico.view.ViewOs;

/**
 *
 * @author Tiago Teixeira
 */
public class ValidationViewOsHelper {
    

    private ViewOs view;

    public ValidationViewOsHelper(ViewOs obj) {
        this.view = obj;
    }
    

    /**
     * retorna verdadeiro se atender a regra de negócio
     * caso retorne falso ele dispara um JOptionPane com a mensagem e devolve o foco.
     * @return 
     */
    public boolean validationJTexts() {
        boolean ret = true;

        if (view.getjTextFieldCliNome().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Cliente", view.getjTextFieldCliNome());
        } else if (view.getjTextFieldCliCpf().getText().trim().toString().length() == 9) {
            ret = false;
            messageReturn("Numero de CPF", view.getjTextFieldCliCpf());
        } else if (view.getjTextFieldCliRG().getText().isEmpty()) {
            ret = false;
            messageReturn("Numero de RG", view.getjTextFieldCliRG());
        } else if (view.getjTextFieldCliRua().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome da Rua", view.getjTextFieldCliRua());
        } else if (view.getjTextFieldCliNumero().getText().isEmpty()) {
            ret = false;
            messageReturn("Numero", view.getjTextFieldCliNumero());
        } else if (view.getjTextFieldCliBairro().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Bairro", view.getjTextFieldCliBairro());
        } else if (view.getjTextFieldCliCidade().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Cidade", view.getjTextFieldCliCidade());
        } else if (view.getjTextFieldCliEstado().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Estado", view.getjTextFieldCliEstado());
        } else if (view.getjTextFieldCliCep().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Cep", view.getjTextFieldCliCep());
        } else if (view.getjTextFieldCliCelular().getText().trim().toString().length() == 10) {
            ret = false;
            messageReturn("Nome Celular", view.getjTextFieldCliCelular());
        } else if (view.getjTextFieldVeicNome().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Veiculo", view.getjTextFieldVeicNome());
        } else if (view.getjTextFieldVeicModelo().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Veiculo Modelo", view.getjTextFieldVeicModelo());
        } else if (view.getjTextFieldVeicMarca().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Veiculo Marca", view.getjTextFieldVeicMarca());
        } else if (view.getjTextFieldVeicCor().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Veiculo Cor", view.getjTextFieldVeicCor());
        } else if (view.getjTextFieldVeicPlaca().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Veiculo Placa", view.getjTextFieldVeicPlaca());
        } else if (view.getjTextFieldNmMecanico().getText().isEmpty()) {
            ret = false;
            messageReturn("Nome Mecanico", view.getjTextFieldNmMecanico());
        } else if (view.getjTextFieldDataChegada().getText().trim().toString().length() == 4) {
            ret = false;
            messageReturn("Data Chegada", view.getjTextFieldDataChegada());
        } else if (view.getjTextFieldDataEntrega().getText().trim().toString().length() == 4) {
            ret = false;
            messageReturn("Data Entrega", view.getjTextFieldDataEntrega());
        }
        return ret;
    }

    /**
     * retorna verdadeiro se atender a regra de negócio caso retorne falso ele
     * dispara um JOptionPane com a mensagem e devolve o foco.
     *
     * @return
     */
    public boolean validationJTextsAskService() {
        boolean ret = true;
        if (view.getjTextFieldDescricaoItem().getText().length() < 5 || view.getjTextFieldDescricaoItem().getText().isEmpty()) {

            ret = false;
            messageReturn("Descricao Item", view.getjTextFieldDescricaoItem());

        } else if (view.getjTextFieldQtd().getText().isEmpty()) {

            ret = false;
            messageReturn("Quantidade Item", view.getjTextFieldQtd());

        } else if (view.getjTextFieldValorUnItem().getText().isEmpty()) {

            ret = false;
            messageReturn("Valor Un Item", view.getjTextFieldValorUnItem());

        } else if (view.getjTextFieldTotalItem().getText().isEmpty()) {

            ret = false;
            messageReturn("Valor Total Item", view.getjTextFieldTotalItem());

        }

        return ret;
    }

    private void messageReturn(String componentName, Object jTObject) {
        JOptionPane.showMessageDialog(view, "Esse campo " + componentName + " é obrigatório!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        Component cp = (Component) jTObject;
        cp.requestFocus();
    }

    
        
}
