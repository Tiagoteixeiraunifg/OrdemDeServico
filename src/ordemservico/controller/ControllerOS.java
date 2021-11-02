
package ordemservico.controller;

import ordemservico.view.ViewOs;

/**
 *
 * @author Tiago Teixeira
 */
public class ControllerOS implements IController{

    private ViewOs viewOs;
    
    @Override
    public void executa(Object objeto) {
        this.viewOs = (ViewOs) objeto;
        
        //toda inicialização da jframe aqui
    }
    
}
