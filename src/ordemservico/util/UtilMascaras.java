package ordemservico.util;

/**
 * Classe Responsavel de Formatar as mascaras de uso comun no sistema.
 *
 * @author Tiago Teixeira
 */
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class UtilMascaras {

    public MaskFormatter mascaraTelefone(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("(##)####-####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }

    public MaskFormatter mascaraCelular(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("(##)#####-####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }

    public MaskFormatter mascaraCpf(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("###.###.###-##");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }
    


    public MaskFormatter mascaraCep(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("#####-###");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }

    public MaskFormatter mascaraCnpj(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("##.###.###/####-##");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }


    public MaskFormatter mascaraData(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("##/##/####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }
    
    public MaskFormatter mascaraDataHora(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("##/##/#### ##:##:##");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }
    
    public MaskFormatter mascaraDataAno(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("####");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.install(textfield);
        return mask;
    }
    
    public MaskFormatter mascaraCNH(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("###########");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.install(textfield);
        return mask;
    }
    
    public MaskFormatter removeMasc(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = null;
        mask = new MaskFormatter("");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        mask.setPlaceholderCharacter('_');
        mask.uninstall();
        return mask;
    }
    
    public MaskFormatter numRenavan(JFormattedTextField textfield) throws ParseException {
        MaskFormatter mask = new MaskFormatter("###########");
        mask.setOverwriteMode(true);
        mask.setValidCharacters("0123456789");
        return mask;
    }

}
