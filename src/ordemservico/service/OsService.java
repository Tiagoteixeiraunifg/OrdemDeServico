
package ordemservico.service;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import ordemservico.OrdemServico;
import ordemservico.dao.ConnectDb;
import ordemservico.dao.OsDao;
import ordemservico.model.ClienteModel;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;

/**
 * Toda comunicação com a DAO e validação do objeto aqui
 * @author Tiago Teixeira
 */
public class OsService {
       
    private OsDao dao;
    private ClienteModel cliModel;
    private PecaServicoModel pecModel;
    private OrdemServicoModel osModel;
    private ConnectDb con;
    
    public OsService() {
        con = new ConnectDb();
        this.dao = new OsDao();
    }
    
    
    
    public OsService(OsDao dao, ClienteModel cliModel, PecaServicoModel pecModel, OrdemServicoModel osModel ) {
        con = new ConnectDb();
        this.dao = dao;
        this.cliModel = cliModel;
        this.pecModel = pecModel;
        this.osModel = osModel;
    }
    
    
    public OrdemServicoModel findOsById(int Id){
        return dao.findById(Id, con.getConexaoDAO());
    }
    
    public ArrayList<OrdemServicoModel> findByParameter(String parametro)throws SQLException{
        return dao.findAllParameter(parametro,con);
    }
    
    public boolean updateByObject(OrdemServicoModel obj) throws SQLException{
        return  dao.updateOs(obj, con);
    }
    
    public ArrayList<OrdemServicoModel> findAll() throws SQLException{
        return dao.findAll(con);
    }
    
    public boolean saveItemServPec(PecaServicoModel obj) throws SQLException {
        return dao.saveAskService(obj, con);
    }
    
    public boolean saveOs(OrdemServicoModel obj, boolean clientNew) throws SQLException{
        return dao.saveOsAskServiceClient(obj, clientNew, con);
    }
    
    
    public ClienteModel getClientByCpf(String NumberCPF) throws SQLException {
        cliModel = new ClienteModel();
        cliModel = dao.findClientByCpf(con, NumberCPF);
        return cliModel;
    }
        
    public OsDao getDao() {
        return dao;
    }

    public void setDao(OsDao dao) {
        this.dao = dao;
    }

    public ClienteModel getCliModel() {
        return cliModel;
    }

    public void setCliModel(ClienteModel cliModel) {
        this.cliModel = cliModel;
    }

    public PecaServicoModel getPecModel() {
        return pecModel;
    }

    public void setPecModel(PecaServicoModel pecModel) {
        this.pecModel = pecModel;
    }

    public OrdemServicoModel getOsModel() {
        return osModel;
    }

    public void setOsModel(OrdemServicoModel osModel) {
        this.osModel = osModel;
    }

    public boolean deleitemById(int idItem, int idOs) throws SQLException {

        return dao.deleteItemById(idItem, idOs, con);

    }

    public boolean updateByObjectItem(PecaServicoModel askServiceModel) throws SQLException{
        return dao.updateAskService(askServiceModel, con);
    }
    
    
}
