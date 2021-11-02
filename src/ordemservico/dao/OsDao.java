
package ordemservico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import ordemservico.util.Util;

/**
 *
 * @author Tiago Teixeira
 */
public class OsDao {
    
    
    private String retorno;
    private boolean sucesso;
    Util util = new Util();
    SimpleDateFormat formatoUS = new SimpleDateFormat("yyyy-MM-dd");
    
    public boolean isSucesso() {
        return sucesso;
    }
   
    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getRetorno() {
        return retorno;
    }
    
    public  void save(Object obj)  {
        // variavel com a string do comando SQL para inserção de dados
        String sql = "";
        String sqlIdRetorno = "";
        

        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            //ps.setString(1, Object.getNome());
            
            //executando a instrução com os parametro setados
            ps.execute();
            
            ps2 = conn.prepareStatement(sqlIdRetorno);
            rs = ps2.executeQuery();
            while (rs.next()) {
                //pega o Id da linha inserida para adicionar as pecas e servicos no Db Relacional
                //Object.setId(rs.getInt(1));
            }
            
                        
            retorno = "Gravado com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao : " + e.getMessage();
            sucesso = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                    ps2.close();
                }
                if (conn != null) {
                    conn.close();
                    ConnectDb.FecharConexao();
                }
            } catch (SQLException e) {
                retorno = "Erro ao fechar conexões: " + e;
            }
        }
    }

    public void update(Object obj)  {
        // variavel com a string do comando SQL para atualização dos dados na enticade
        String sql = "";
        
        Connection conn = null;
        PreparedStatement ps = null;
               
        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql
            
            //ps.setString(1, clscarros.getNome());
            
            
            //executando a instrução com os parametro setados da classe colaborador
            ps.execute();
             
            retorno = "Atualizado com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao : " + e.getMessage();
            sucesso = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConnectDb.FecharConexao();
                }
            } catch (SQLException e) {
                retorno = "Erro fechar conexão: " + e;
            }
        }
    }

    public void delete(int id_carro) {
        // variavel com a string do comando SQL para atualização dos dados na enticade Colaborador
        String sql = "delete from exemplo where id = ?";
        String sql2 = "delete from exemplo where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps1 = conn.prepareStatement(sql2);
            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps1.setInt(1, id_carro);
            
            //executando a instrução com os parametro setados da classe colaborador
            ps1.execute();
            
            ps = conn.prepareCall(sql);
            ps.setInt(1, id_carro);
            ps.execute();
            
            retorno = "Deletado com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao Deletar: " + e.getMessage();
            sucesso = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConnectDb.FecharConexao();
                }
            } catch (SQLException e) {
                retorno = "Erro : " + e;
            }
        }
    }

    public Object select(String parametro) {

        String sql ="";
        
        Object obj = null; 
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            obj = new Object();
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setString(1, parametro);
            rset = ps.executeQuery();
            
            while(rset.next()){
            //obj.setId(rset.getInt("Id"));
            
            }

            retorno = "Encontrado!";
            sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            System.out.println("Erro aqui: " + e);
            sucesso = false;
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConnectDb.FecharConexao();
                }
            } catch (SQLException e) {
                retorno = "Erro: " + e;
            }
        }

        return obj;
    }

    public List<Object> selectAll()  {

        List<Object> obj = new ArrayList<Object>();
        
        //query de SQL
        String sql ="";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            rset = ps.executeQuery();
            
            while (rset.next()) {
                Object objs = new Object(); 
                obj.add(objs);
            }
            retorno = "Encontrado!";
            sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            sucesso = false;
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                    ConnectDb.FecharConexao();
                }

            } catch (SQLException e) {
                retorno = "Erro: " + e;
            }
        }
        return obj;
    }
}
