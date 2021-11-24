
package ordemservico.controller;


import java.util.ArrayList;
import ordemservico.controller.helper.ControlaControlesViewHelper;
import ordemservico.controller.helper.TabelaListaOsHelper;
import ordemservico.dao.OsDao;
import ordemservico.model.ClienteModel;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;
import ordemservico.service.OsService;
import ordemservico.view.ViewOs;

/**
 *
 * @author Tiago Teixeira
 */
public class ControllerOS implements IController{

    private ViewOs viewOs;
    private OsService osService;
    private OrdemServicoModel osModel;
    private ControlaControlesViewHelper ControlsHelper;
    private OsDao dao;
    
    
    
    @Override
    public void executa(Object objeto) {
        this.viewOs = (ViewOs) objeto;
        this.dao = new OsDao();
        osService = new OsService(dao, new ClienteModel(), new PecaServicoModel(), new OrdemServicoModel());
        osModel = new OrdemServicoModel();
        ControlsHelper = new ControlaControlesViewHelper(viewOs);
        carregaTabela(osService.findAll());
        ControlsHelper.habilitaBotoes(1);
        ControlsHelper.controleJtext(false);
        //toda inicialização da jframe aqui
    }
    

    
    private void carregaTabela(ArrayList<OrdemServicoModel> list){
        TabelaListaOsHelper modelTable= new TabelaListaOsHelper(list);
        viewOs.getjTableHistorico().setModel(modelTable);
    }
    
    private void pesquisarTabela(String parametro){
        TabelaListaOsHelper modelTable= new TabelaListaOsHelper(osService.findByParameter(parametro));
        viewOs.getjTableHistorico().setModel(modelTable);
    }
    
    public void jTextFiltroTabela(){
        pesquisarTabela(viewOs.getjTextFieldBusca().getText());
    }
}
