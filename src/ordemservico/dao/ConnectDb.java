
package ordemservico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.activation.DataSource;

/**
 * 
 * @author Tiago Teixeira
 */
public class ConnectDb {
    private  String status = "Não conectou...";
    private  boolean Connected;
    private  String schema;
    
    
    
    public  java.sql.Connection getConexaoDAO(Connection conn) {
        
               
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
              
            conn = DriverManager.getConnection(url, username, password);
            
            //Testa sua conexão//

            if (conn != null) {
                
                schema = conn.getSchema();
                status = ("STATUS--->Conectado com sucesso!");
                Connected = true;

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");
                Connected = false;

            }

            return conn;

        } catch (ClassNotFoundException e) {
            
            System.out.println("O driver expecificado nao foi encontrado." + e);
            
            return null;
            
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel conectar ao Banco de Dados." + e);
            
            return null;

        }

    }
    
    public  java.sql.Connection getConexaoDAO() {

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
    public  String statusConection()  {        
        return status;
    }
    
    public  String bancoNome()  {              
        return schema;
    }

    //Método que fecha sua conexão//
    public  boolean FecharConexao()   {
        try {
            getConexaoDAO().close();
            Connected = false;
            return true;
           
        } catch (SQLException e) {
            Connected = false;
            return false;
        }
    }

    public  java.sql.Connection ReiniciarConexao()   {
        FecharConexao();
        return getConexaoDAO();
    }

    public  boolean isConnected() {
        return Connected;
    }
}
