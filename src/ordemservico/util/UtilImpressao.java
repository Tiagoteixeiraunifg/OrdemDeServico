package ordemservico.util;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import ordemservico.dao.ConnectDb;

/**
 *
 * @author Tiago Teixeira
 */
public class UtilImpressao {
    
    private ConnectDb connectDb;

    public UtilImpressao(ConnectDb conect) {
      this.connectDb = conect;
    }
    
    
    public void ClsImpressao(String nomeRel, String parametro, String valorParametro, String tituloRelatorio) throws  JRException {
        //gerando o jasper design
        JasperDesign desenho = JRXmlLoader.load(nomeRel);

        //compila o relatório
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);
         
        //executa o relatório
        Map parametros = new HashMap();
        parametros.put(parametro, valorParametro);
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, connectDb.getConexaoDAO());
        //JasperExportManager.exportReportToPdfFile(impressao, "src/relatorios/Teste.pdf");
        
        
        //exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);
        relOpemFrame(tituloRelatorio, impressao);
        
        //fecha conexão com o banco de dados
        connectDb.FecharConexao();
        
    }
    
    private static void relOpemFrame( String titulo, JasperPrint print ) {
         /*
         * Cria um JRViewer para exibir o relatório.
        */
        JRViewer viewer = new JRViewer( print );
        
        // cria o JFrame
        JFrame frameRelatorio = new JFrame( titulo );
 
        // adiciona o JRViewer no JFrame
        frameRelatorio.add( viewer, BorderLayout.CENTER );
 
        // configura o tamanho padrão do JFrame
        frameRelatorio.setSize( 500, 500 );
 
        // maximiza o JFrame para ocupar a tela toda.
        frameRelatorio.setExtendedState( JFrame.MAXIMIZED_BOTH );
 
        // configura a operação padrão quando o JFrame for fechado.
        frameRelatorio.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
 
        // exibe o JFrame
        frameRelatorio.setVisible( true );
    }
}
