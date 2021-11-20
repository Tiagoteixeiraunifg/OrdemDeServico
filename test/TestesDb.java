

import java.util.ArrayList;
import ordemservico.controller.ControllerOS;
import ordemservico.dao.ConnectDb;
import ordemservico.dao.OsDao;
import ordemservico.model.OrdemServicoModel;
import ordemservico.service.OsSevice;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Tiago Teixeira
 */
public class TestesDb {
    
    
    @Mock
    private OsDao dao;
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        
        
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void VerificaRetornoLista() {
         ArrayList<OrdemServicoModel> list = new ArrayList<>();
         list = dao.findAll(ConnectDb.getConexaoDAO());
         assertTrue(list.isEmpty()); 
     }
     
     @Test
     public void VerificaListaComParametros() {
         
         ArrayList<OrdemServicoModel> list = new ArrayList<>();
         list = dao.findAllParameter("carro", ConnectDb.getConexaoDAO());
         assertTrue(list.isEmpty());
         
     }
     
     
}
