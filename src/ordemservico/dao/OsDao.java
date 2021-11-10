
package ordemservico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import ordemservico.model.ClienteModel;
import ordemservico.model.OrdemServicoModel;
import ordemservico.model.PecaServicoModel;
import ordemservico.util.Util;

/**
 *
 * @author Tiago Teixeira
 */
public class OsDao {
    
    private int idRetornadoCli = 0;
    private int idRetornadoOs = 0;
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
    
    /**
     * Passa o objeto completo com a lista de itens e cliente, caso o parametro de cliente novo for false ele vai atualizar o existente
     * caso seja um cliente novo ele vai fazer o cadastro a partir dos dados inseridos.
     * @param obj
     * @param clienteNovo 
     */
    public  void save(OrdemServicoModel obj, boolean clienteNovo)  {
        // variavel com a string do comando SQL para inserção de dados
        String sql = ""; // salvar Ordem de Serviço
        String sql_1 = "";  //pega o id da OS para lancar os produtos relacionados
        String sql_2 = ""; // salvar Itens da Ordem de Serviço

        Connection conn = null;
        PreparedStatement ps = null; // salvar Ordem de Serviço
        PreparedStatement ps2 = null; // pegar id retornado
        PreparedStatement ps3 = null; // salvar Itens da Ordem de Serviço
        ResultSet rs;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            
            if (clienteNovo) {
                save(obj.getCliente());
                obj.getCliente().setIdCliente(idRetornadoCli);
            } else {
                //atualizando o cliente com novas informações
                update(obj.getCliente());
                //adicionando os valores de acordo a ordem dos parametros do string sql
                ps.setString(1, obj.getNomeVeiculo());
                ps.setString(2, obj.getModeloVeiculo());
                ps.setString(3, obj.getMarcaVeiculo());
                ps.setString(4, obj.getCorVeiculo());
                ps.setString(5, obj.getPlacaVeiculo());
                ps.setString(6, obj.getMecanico());
                ps.setString(7, obj.getDefeitoReclamado());
                ps.setString(8, obj.getRelatoMecanico());
                ps.setString(9, obj.getDataChegada());
                ps.setString(10, obj.getDataEntrega());
                ps.setInt(11, obj.getCliente().getIdCliente());
                ps.setString(12, obj.getStatus());
                //executando a instrução com os parametro setados
                ps.execute();
                sucesso = true;
                retorno = "Salvou OS";
                if (sucesso) {
                    ps2 = conn.prepareStatement(sql_1);
                    rs = ps2.executeQuery();
                    while (rs.next()) {
                        //pega o Id da linha inserida para adicionar as pecas e servicos no Db Relacional
                        this.idRetornadoOs = rs.getInt(1);
                    }
                    sucesso = (idRetornadoOs != 0) ? true : false;
                }
                if(sucesso){

                    for (PecaServicoModel item : obj.getPecasSevico()) {
                        ps3 = conn.prepareStatement(sql_2);
                        ps3.setInt(1, idRetornadoOs);
                        ps3.setString(2, item.getTipo());
                        ps3.setString(3, item.getDescricao());
                        ps3.setDouble(4, item.getValorUn());
                        ps3.setDouble(5, item.getValorTotal());
                        ps3.execute();
                        sucesso = true;
                    }      
                }
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
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (ps3 != null) {
                    ps3.close();
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
    
    /**
     * salva o cliente a partir do metodo principal de save(OrdemServicoModel obj) caso não tiver o cadastro;
     * @param obj 
     */
    public  void save(ClienteModel obj)  {
        // variavel com a string do comando SQL para inserção de dados
        String sql = ""; // salvar cliente
        String sqlIdRetorno = "";
        
        Connection conn = null;
        PreparedStatement ps = null; // salvar Ordem de Serviço
        PreparedStatement ps2 = null;
        ResultSet rs;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getCpf());
            ps.setString(3, obj.getRg());
            ps.setString(4, obj.getRua());
            ps.setString(5, obj.getBairro());
            ps.setString(6, obj.getNumero());
            ps.setString(7, obj.getCidade());
            ps.setString(8, obj.getEstado());
            ps.setString(9, obj.getCep());
            ps.setString(10, obj.getCelular());
            //executando a instrução com os parametro setados
            ps.execute();
            
            
            ps2 = conn.prepareStatement(sqlIdRetorno);
            rs = ps2.executeQuery();
            while (rs.next()) {
                //pega o Id da linha inserida para adicionar as pecas e servicos no Db Relacional
                idRetornadoCli =rs.getInt(1);
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
                }
                if (ps2 != null) {
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
    
    /**
     * Insere de forma individual o item no banco, usado para adicinar novos itens a OS já salvas e em modo de edição.
     * @param obj 
     */
    public void save(PecaServicoModel obj) {
        // variavel com a string do comando SQL para inserção de dados
        String sql = ""; // salvar cliente

        Connection conn = null;
        PreparedStatement ps = null; // salvar Ordem de Serviço

        try {
            conn = ConnectDb.getConexaoDAO();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdOrdem());
            ps.setString(2, obj.getTipo());
            ps.setString(3, obj.getDescricao());
            ps.setDouble(4, obj.getValorUn());
            ps.setDouble(5, obj.getValorTotal());
            ps.execute();
            
            retorno = "Gravado com sucesso!";
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
                retorno = "Erro ao fechar conexões: " + e;
            }
        }
    }
    
    /**
     * Ao usar a função ele atualiza em cascata todas as informações relacionadas a essa ordem de serviço
     * @param obj 
     */
    public void update(OrdemServicoModel obj) {
        // variavel com a string do comando SQL para atualização dos dados na enticade
        String sql = ""; // atualiza Ordem de Serviço
        String sql_1 = "";  //atualiza Itens da ordem de serviço

        Connection conn = null;
        PreparedStatement ps = null; // atualiza Ordem de Serviço
        PreparedStatement ps2 = null; //atualiza Itens da ordem de serviço

        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            ps.setString(1, obj.getNomeVeiculo());
            ps.setString(2, obj.getModeloVeiculo());
            ps.setString(3, obj.getMarcaVeiculo());
            ps.setString(4, obj.getCorVeiculo());
            ps.setString(5, obj.getPlacaVeiculo());
            ps.setString(6, obj.getMecanico());
            ps.setString(7, obj.getDefeitoReclamado());
            ps.setString(8, obj.getRelatoMecanico());
            ps.setString(9, obj.getDataChegada());
            ps.setString(10, obj.getDataEntrega());
            ps.setInt(11, obj.getCliente().getIdCliente());
            ps.setString(12, obj.getStatus());
            ps.setInt(13, obj.getIdOrdem());
            //executando a instrução com os parametro setados
            ps.execute();
            sucesso = true;
            retorno = "atualizou OS";

            for (PecaServicoModel item : obj.getPecasSevico()) {
                ps2 = conn.prepareStatement(sql_1);
                ps2.setInt(1, obj.getIdOrdem());
                ps2.setString(2, item.getTipo());
                ps2.setString(3, item.getDescricao());
                ps2.setDouble(4, item.getValorUn());
                ps2.setDouble(5, item.getValorTotal());
                ps2.setInt(6, item.getIdServPeca());
                ps2.execute();
                sucesso = true;
            }
             
            retorno = retorno + "Atualizado lista de itens!";
            sucesso = update(obj.getCliente()); // aqui atualiza o cliente.
        } catch (SQLException e) {
            retorno = "Erro ao : " + e.getMessage();
            sucesso = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (ps2 != null) {
                    ps2.close();
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
    
    /**
     * atualiza o cliente a partir do metodo principal update(OrdemServicoModel obj) e retorna se foi ok ou não.
     * @param obj
     * @return 
     */
    public boolean update(ClienteModel obj)  {
        boolean ret = false;
        // variavel com a string do comando SQL para atualização dos dados na enticade
        String sql = "";
        
        Connection conn = null;
        PreparedStatement ps = null;
               
        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getCpf());
            ps.setString(3, obj.getRg());
            ps.setString(4, obj.getRua());
            ps.setString(5, obj.getBairro());
            ps.setString(6, obj.getNumero());
            ps.setString(7, obj.getCidade());
            ps.setString(8, obj.getEstado());
            ps.setString(9, obj.getCep());
            ps.setString(10, obj.getCelular());
            ps.setInt(11, obj.getIdCliente());
            //executando a instrução com os parametro setados
            ps.execute();
             
            retorno = "Atualizado com sucesso!";
            sucesso = true;
            ret = true;
        } catch (SQLException e) {
            retorno = "Erro ao : " + e.getMessage();
            sucesso = false;
            ret = false;
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
        return ret;
    }
    
    public void update(PecaServicoModel obj)  {
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

    public Object findByParameter(String parametro) {

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

    public ArrayList<OrdemServicoModel> findAll()  {

        ArrayList<OrdemServicoModel> obj = new ArrayList<OrdemServicoModel>();
        
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
                OrdemServicoModel objs = new OrdemServicoModel(); 
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
    
    public ArrayList<OrdemServicoModel> findAllParameter(String parametro)  {

        ArrayList<OrdemServicoModel> obj = new ArrayList<OrdemServicoModel>();
        
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
                OrdemServicoModel objs = new OrdemServicoModel(); 
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
