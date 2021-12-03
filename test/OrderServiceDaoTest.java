

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ordemservico.dao.ConnectDb;
import ordemservico.dao.OsDao;
import ordemservico.model.ClienteModel;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyDouble;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;



/**
 *
 * @author Tiago Teixeira
 */
public class OrderServiceDaoTest {
    private OsDao osDao;
    
    
    private PecaServicoModel produto1;
    private PecaServicoModel produto2;
    private PecaServicoModel produto3;
    private PecaServicoModel produto4;
    private PecaServicoModel produto5;
    private PecaServicoModel produto6;
    
    @Mock
    private ClienteModel cliModel;
    
    @Mock
    private ArrayList<PecaServicoModel> mockListProducts;
    
    @Mock
    private OrdemServicoModel mockOsModel;
    
    @Mock
    private ConnectDb mockConectDb;

    @Mock
    private Connection mockCon;

    @Mock
    private PreparedStatement mockPstmt;
    
    @Mock
    private ResultSet mockRs;
    
    
    public OrderServiceDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException{
        MockitoAnnotations.initMocks(this);

        doNothing().when(mockPstmt).setInt(anyInt(), anyInt());
        doNothing().when(mockPstmt).setString(anyInt(), anyString());
        doNothing().when(mockPstmt).setDouble(anyInt(), anyDouble());
        when(mockConectDb.getConexaoDAO()).thenReturn(mockCon);
        when(mockConectDb.getConexaoDAO().prepareStatement(anyString())).thenReturn(mockPstmt);
        when(mockCon.prepareStatement(anyString())).thenReturn(mockPstmt);
        when(mockPstmt.execute()).thenReturn(Boolean.TRUE);
        when(mockPstmt.executeQuery()).thenReturn(mockRs);
        when(mockRs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        //when(mockRs.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockRs.getInt(anyInt())).thenReturn(8);
        doNothing().when(mockPstmt).close();

        
        cliModel = new ClienteModel("Tiago", "03086170530","RG","RUA ABC DEFG TESTE SEU TESTE", "CENTRO", "S/N", "GUANAMBI", "BAHIA", "46430000", "77999455587");
        produto1 = new PecaServicoModel(1, "PECA", "Produto 1", 10, 150.00, 1500.00);
        produto2 = new PecaServicoModel(2, "PECA", "Produto 2", 10, 150.00, 1500.00);
        produto3 = new PecaServicoModel(3, "PECA", "Produto 3", 10, 150.00, 1500.00);
        produto4 = new PecaServicoModel(4, "PECA", "Produto 4", 40, 150.00, 6000.00);
        produto5 = new PecaServicoModel(5, "PECA", "Produto 5", 10, 150.00, 1500.00);
        produto6 = new PecaServicoModel(6, "PECA", "Produto 6", 20, 150.00, 3000.00);
        mockListProducts = new ArrayList<>();
        mockListProducts.add(produto1);
        mockListProducts.add(produto2);
        mockListProducts.add(produto3);
        mockListProducts.add(produto4);
        mockListProducts.add(produto5);
        mockListProducts.add(produto6);
        mockOsModel = new OrdemServicoModel(cliModel, mockListProducts, "VECTRA",
                "GT", "CHEVROLET", "PRATA", "HEF1833", "TIAGO", "", "", "2021/01/01", "2021/01/01", "ABERTO");
        
        osDao = new OsDao();

    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSaveOsClientNew() throws SQLException{
      
        
        boolean ret;
        ret = osDao.saveOsAskServiceClient(mockOsModel, true, mockConectDb);
 
        //verificando o caminho//
        verify(mockConectDb, times(11)).getConexaoDAO();
        verify(mockCon, times(10)).prepareStatement(anyString());
        verify(mockPstmt, times(8)).execute();
        verify(mockRs, times(4)).next();
        verify(mockPstmt, times(5)).close();
        //verifico se salvou//
        assertTrue(ret);

    }
    
    @Test
    public void testSaveOsClientOld() throws SQLException {
        
        boolean ret;
        ret = osDao.saveOsAskServiceClient(mockOsModel, false, mockConectDb);
         
        //verificando o caminho//
        verify(mockConectDb, times(3)).getConexaoDAO();
        verify(mockCon, times(2)).prepareStatement(anyString());
        verify(mockPstmt, times(1)).execute();
        verify(mockRs, times(0)).next();
        verify(mockPstmt, times(2)).close();
        //verifico se salvou//
        assertTrue(ret);
        
    }
}
