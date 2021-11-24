
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
public class OsService {
       
    private OsDao dao;
    private ClienteModel cliModel;
    private PecaServicoModel pecModel;
    private OrdemServicoModel osModel;
    
    public OsService(OsDao dao, ClienteModel cliModel, PecaServicoModel pecModel, OrdemServicoModel osModel ) {
        this.dao = dao;
        this.cliModel = cliModel;
        this.pecModel = pecModel;
        this.osModel = osModel;
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
