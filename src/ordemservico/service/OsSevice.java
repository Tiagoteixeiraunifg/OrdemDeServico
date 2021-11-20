
package ordemservico.service;


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
public class OsSevice {
       
    private OsDao dao;
    private ClienteModel cliModel;
    private PecaServicoModel pecModel;
    private OrdemServicoModel osModel;
    
    public OsSevice() {
        dao = new OsDao();
        cliModel = new ClienteModel();
        pecModel = new PecaServicoModel();
        osModel = new OrdemServicoModel();
    }
    
    public OrdemServicoModel findOsById(int Id){
        return dao.findById(Id, ConnectDb.getConexaoDAO());
    }
    
    public ArrayList<OrdemServicoModel> findByParameter(String parametro){
        return dao.findAllParameter(parametro,ConnectDb.getConexaoDAO());
    }
    
    public ArrayList<OrdemServicoModel> findAll(){
        return dao.findAll(ConnectDb.getConexaoDAO());
    }
}
