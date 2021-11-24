

import java.util.ArrayList;
import ordemservico.controller.ControllerOS;
import ordemservico.dao.ConnectDb;
import ordemservico.dao.OsDao;
import ordemservico.model.ClienteModel;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;
import ordemservico.service.OsService;
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
    private ClienteModel cliModel;
    private ClienteModel cliModel2;
    private ClienteModel cliModel3;
    private ClienteModel cliModel4;
    private ClienteModel cliModel5;

    PecaServicoModel produto1;
    PecaServicoModel produto2;
    PecaServicoModel produto3;
    PecaServicoModel produto4;
    PecaServicoModel produto5;
    PecaServicoModel produto6;
    
    @Mock
    private OsDao osDao;
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        PecaServicoModel pecaModel = new PecaServicoModel();
        OrdemServicoModel osModel = new OrdemServicoModel();
        
        cliModel = new ClienteModel("Tiago", "03086170530","RG","RUA ABC DEFG TESTE SEU TESTE", "CENTRO", "S/N", "GUANAMBI", "BAHIA", "46430000", "77999455587");
        cliModel2 = new ClienteModel("Karine", "03086170530","RG","RUA ABC DEFG TESTE SEU TESTE", "CENTRO", "S/N", "GUANAMBI", "BAHIA", "46430000", "77999455587");
        cliModel3 = new ClienteModel("Joao", "03086170530","RG","RUA ABC DEFG TESTE SEU TESTE", "CENTRO", "S/N", "GUANAMBI", "BAHIA", "46430000", "77999455587");
        cliModel4 = new ClienteModel("Pedrinho", "03086170530","RG","RUA ABC DEFG TESTE SEU TESTE", "CENTRO", "S/N", "GUANAMBI", "BAHIA", "46430000", "77999455587");
        cliModel5 = new ClienteModel("Felipe", "03086170530","RG","RUA ABC DEFG TESTE SEU TESTE", "CENTRO", "S/N", "GUANAMBI", "BAHIA", "46430000", "77999455587");
       
        produto1 = new PecaServicoModel(1,"PECA","Produto 1", 10, 150.00, 1500.00 );
        produto2 = new PecaServicoModel(2,"PECA","Produto 2", 10, 150.00, 1500.00 );
        produto3 = new PecaServicoModel(3,"PECA","Produto 3", 10, 150.00, 1500.00 );
        produto4 = new PecaServicoModel(4,"PECA","Produto 4", 40, 150.00, 6000.00 );
        produto5 = new PecaServicoModel(5,"PECA","Produto 5", 10, 150.00, 1500.00 );
        produto6 = new PecaServicoModel(6,"PECA","Produto 6", 20, 150.00, 3000.00 ); 
        
        ArrayList<PecaServicoModel> listPecas = new ArrayList<>();
        listPecas.add(produto1);
        listPecas.add(produto2);
        listPecas.add(produto3);
        listPecas.add(produto4);
        listPecas.add(produto5);
        listPecas.add(produto6);
        
        
        
        OsService osService = new OsService(osDao, cliModel, pecaModel, osModel);
        
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void VerificaRetornoLista() {
         osDao.save(produto1, ConnectDb.getConexaoDAO());
         assertTrue(osDao.isSucesso());
         System.out.println("Err");
     }
     
//     @Test
//     public void VerificaListaComParametros() {
//         
//         ArrayList<OrdemServicoModel> list = new ArrayList<>();
//         list = osService.findByParameter("carro");
//         assertTrue(!list.isEmpty());
//         
//     }
//     
     
}
