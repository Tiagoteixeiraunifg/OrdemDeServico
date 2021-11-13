
package ordemservico;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ordemservico.view.ViewOs;

/**
 *
 * @author Tiago Teixeira
 */
public class OrdemServico {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       
         try {
            UIManager.setLookAndFeel(new FlatLightLaf());

            FlatLightFlatIJTheme.install();
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Falha ao inicializar LaF");
        }
        
        ViewOs view = new ViewOs();
        view.setVisible(true);
    }
    
}
