
import com.lowagie.text.Document;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.PlainDocument;
import ordemservico.controller.helper.ControlaControlesViewHelper;
import ordemservico.util.UtilDocumentNumeric;
import ordemservico.util.UtilMascaras;
import ordemservico.view.ViewOs;
import org.dom4j.tree.DefaultDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.anyBoolean;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Tiago Teixeira
 */
public class ViewHelperTest {
    
    private ControlaControlesViewHelper viewHelper;
    
    @Mock
    private ViewOs mockView;
    
    @Mock
    private JTextField mockText;
    
    @Mock
    private JTable mockJtable;
    
   
    @Mock
    private UtilDocumentNumeric doc;
    
    public ViewHelperTest() {
    }
    
    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);
        
        when(mockView.getjTextFieldCliCep()).thenReturn(mockText);
        when(mockView.getjTextFieldCliRG()).thenReturn(mockText);
        when(mockView.getjTextFieldQtd()).thenReturn(mockText);
        when(mockView.getjTextFieldTotalItem()).thenReturn(mockText);
        when(mockView.getjTextFieldValorUnItem()).thenReturn(mockText);

    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testMethodControllerOfControlKeys(){
        viewHelper = new ControlaControlesViewHelper(mockView);
        viewHelper.controleDigitacao();
        verify(mockView, times(1)).getjTextFieldCliCep();
        verify(mockView, times(1)).getjTextFieldCliRG();
        verify(mockView, times(1)).getjTextFieldQtd();
        verify(mockView, times(1)).getjTextFieldTotalItem();
        verify(mockView, times(1)).getjTextFieldValorUnItem();
    }
    
   
}
