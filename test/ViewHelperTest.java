
import com.lowagie.text.Document;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.PlainDocument;
import ordemservico.controller.helper.ControlaControlesViewHelper;
import ordemservico.util.DocumentNumeric;
import ordemservico.util.UtilMascaras;
import ordemservico.view.ViewOs;
import org.dom4j.tree.DefaultDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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
    private JFormattedTextField mockFormattedText;
    
    @Mock
    private DocumentNumeric doc;
    
    public ViewHelperTest() {
    }
    
    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);
        //view.getjTextFieldCliCelular().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraCelular(view.getjTextFieldCliCelular())));
        //view.getjTextFieldDataChegada().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraData(view.getjTextFieldDataChegada())));
         //view.getjTextFieldDataEntrega().setFormatterFactory(new DefaultFormatterFactory(new UtilMascaras().mascaraData(view.getjTextFieldDataEntrega())));
        //when(mockView.getjTableHistorico())
        
        when(mockView.getjTextFieldCliCelular()).thenReturn(mockFormattedText);
        when(mockView.getjTextFieldDataChegada()).thenReturn(mockFormattedText);
        when(mockView.getjTextFieldDataEntrega()).thenReturn(mockFormattedText);
        when(mockView.getjTextFieldCliCep()).thenReturn(mockText);
        when(mockView.getjTextFieldCliRG()).thenReturn(mockText);
        when(mockView.getjTextFieldCliCpf()).thenReturn(mockText);
        when(mockView.getjTextFieldQtd()).thenReturn(mockText);
        when(mockView.getjTextFieldTotalItem()).thenReturn(mockText);
        when(mockView.getjTextFieldValorUnItem()).thenReturn(mockText);
        
        doNothing().when(mockView).getjTableServPecas().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextAreaDefeito().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextAreaSolucao().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldBusca().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliBairro().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliCelular().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliCep().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliCidade().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliCpf().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliEstado().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliNome().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliNumero().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliRG().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldCliRua().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldDataChegada().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldDataEntrega().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldDescricaoItem().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldNmMecanico().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldTotalItem().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldValorUnItem().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldVeicCor().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldVeicMarca().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldVeicModelo().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldVeicNome().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjTextFieldVeicPlaca().setEnabled(Boolean.TRUE);
        doNothing().when(mockView).getjComboBoxTipoItem().setEnabled(Boolean.TRUE);

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
        verify(mockView, times(1)).getjTextFieldCliCpf();
        verify(mockView, times(1)).getjTextFieldQtd();
        verify(mockView, times(1)).getjTextFieldTotalItem();
        verify(mockView, times(1)).getjTextFieldValorUnItem();
    }
    
    @Test
    public void testDisableComponentsView(){
        viewHelper = new ControlaControlesViewHelper(mockView);
        viewHelper.controleJtext(true);
        verify(mockView, times(1)).getjComboBoxTipoItem().setEnabled(Boolean.TRUE);
        
    
    }
   
}
