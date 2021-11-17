
package ordemservico.controller;

import ordemservico.model.OrdemServicoModel;
import ordemservico.service.OsSevice;
import ordemservico.view.ViewOs;

/**
 *
 * @author Tiago Teixeira
 */
public class ControllerOS implements IController{

    private ViewOs viewOs;
    private OsSevice osService;
    private OrdemServicoModel osModel;
    
    @Override
    public void executa(Object objeto) {
        this.viewOs = (ViewOs) objeto;
        osService = new OsSevice();
        osModel = new OrdemServicoModel();
        osModel = osService.findOsById(1);
        System.out.println(osModel);
        //toda inicialização da jframe aqui
    }
    
}
