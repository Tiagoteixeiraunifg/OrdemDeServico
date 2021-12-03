
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ordemservico.dao.ConnectDb;
import ordemservico.dao.OsDao;
import ordemservico.model.ClienteModel;
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
public class ModelClientAskDaoTest {
    
  
    private OsDao osDao;
    
    private ClienteModel cliModel;
    
    private PecaServicoModel produto1;
    
    @Mock
    private ConnectDb mockConectDb;
    
    @Mock
    private Connection mockCon ;
    
    @Mock
    private PreparedStatement mockPstmt;
    
    @Mock
    private ResultSet mockRs;
    
    public ModelClientAskDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @Before
    public void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        osDao = new OsDao();
        produto1 = new PecaServicoModel(1, "any", "any", 10, 150.00, 1500.00);
        cliModel = new ClienteModel("Tiago", "03086170530","RG","RUA ABC DEFG TESTE SEU TESTE", "CENTRO", "S/N", "GUANAMBI", "BAHIA", "46430000", "77999455587");
        doNothing().when(mockPstmt).setInt(anyInt(), anyInt());
        doNothing().when(mockPstmt).setString(anyInt(), anyString());
        doNothing().when(mockPstmt).setDouble(anyInt(), anyDouble());
        when(mockConectDb.getConexaoDAO()).thenReturn(mockCon);
        when(mockConectDb.getConexaoDAO().prepareStatement(anyString())).thenReturn(mockPstmt);
        when(mockCon.prepareStatement(anyString())).thenReturn(mockPstmt);
        when(mockPstmt.executeQuery()).thenReturn(mockRs);
        when(mockRs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockPstmt.execute()).thenReturn(Boolean.TRUE);
        doNothing().when(mockPstmt).close();
   
    }
    
    @After
    public void tearDown() {
    }
    

    @Test
    public void testSaveAskToNotExeception() throws SQLException{
        boolean ret;
        ret = osDao.saveAskService(produto1, mockConectDb);
        //verificando o caminho//
        verify(mockConectDb, times(2)).getConexaoDAO();
        verify(mockCon, times(1)).prepareStatement(anyString());
        verify(mockPstmt, times(1)).setInt(anyInt(), anyInt());
        verify(mockPstmt, times(2)).setString(anyInt(), anyString());
        verify(mockPstmt, times(3)).setDouble(anyInt(), anyDouble());
        verify(mockPstmt, times(1)).execute();
        verify(mockPstmt, times(1)).close();
        //verifico se salvou//
        assertTrue(ret);  
    }
    
    @Test(expected = SQLException.class)
    public void testSaveAskToException() throws SQLException{
        //vai estourar a SQLException quando o prepareStatement for invokado.
        when(mockCon.prepareStatement(anyString())).thenThrow(new SQLException());  
        try {
            boolean ret;
            ret = osDao.saveAskService(produto1, mockConectDb);
        } catch (SQLException e) {
            verify(mockCon, times(1)).prepareStatement(anyString());
            throw e;
        }

    }
    
    @Test
    public void testSaveClientNotExeception() throws SQLException{
        
        boolean ret;
        ret = osDao.saveClient(cliModel, mockConectDb);
        //verificando o caminho//
        verify(mockConectDb, times(3)).getConexaoDAO();
        verify(mockCon, times(2)).prepareStatement(anyString());
        verify(mockPstmt, times(10)).setString(anyInt(), anyString());
        verify(mockPstmt, times(1)).execute();
        verify(mockPstmt, times(2)).close();
        verify(mockConectDb, times(1)).FecharConexao();
        //verifico se salvou//
        assertTrue(ret);  
    }
    
    @Test(expected = SQLException.class)
    public void testClientToException() throws SQLException{
        //vai estourar a SQLException quando o prepareStatement for invokado.
        when(mockCon.prepareStatement(anyString())).thenThrow(new SQLException());  
        try {
            boolean ret;
            ret = osDao.saveClient(cliModel, mockConectDb);
        } catch (SQLException e) {
            verify(mockCon, times(1)).prepareStatement(anyString());
            throw e;
        }
    }
    
}
