
package ordemservico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Tiago Teixeira
 */
public class ConnectDb {
    private static String status = "Não conectou...";
    private static boolean Connected;
    private static String schema;
    
    
    public static java.sql.Connection getConexaoDAO() {

        Connection connection = null;  

        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão //
            String serverName = "localhost"; 
            String mydatabase = "db_ordemservico";
            String porta = "3306";
            String url = "jdbc:mysql://" + serverName + ":"+porta+"/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";  
            String password = "root";
              
            connection = DriverManager.getConnection(url, username, password);
            
            //Testa sua conexão//

            if (connection != null) {
                
                schema = connection.getSchema();
                status = ("STATUS--->Conectado com sucesso!");
                Connected = true;

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");
                Connected = false;

            }

            return connection;

        } catch (ClassNotFoundException e) {
            
            System.out.println("O driver expecificado nao foi encontrado." + e);
            
            return null;
            
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel conectar ao Banco de Dados." + e);
            
            return null;

        }

    }

    //Método que retorna o status da sua conexão//
    public static String statusConection()  {        
        return status;
    }
    
    public static String bancoNome()  {              
        return schema;
    }

    //Método que fecha sua conexão//
    public static boolean FecharConexao()   {
        try {
            ConnectDb.getConexaoDAO().close();
            Connected = false;
            return true;
           
        } catch (SQLException e) {
            Connected = false;
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao()   {
        FecharConexao();
        return ConnectDb.getConexaoDAO();
    }

    public static boolean isConnected() {
        return Connected;
    }
}
