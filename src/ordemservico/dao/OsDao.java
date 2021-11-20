
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
    public  void save(OrdemServicoModel obj, boolean clienteNovo, Connection conn)  {
        // variavel com a string do comando SQL para inserção de dados
        String sql = ""; // salvar Ordem de Serviço
        String sql_1 = "";  //pega o id da OS para lancar os produtos relacionados
        String sql_2 = ""; // salvar Itens da Ordem de Serviço


        PreparedStatement ps = null; // salvar Ordem de Serviço
        PreparedStatement ps2 = null; // pegar id retornado
        PreparedStatement ps3 = null; // salvar Itens da Ordem de Serviço
        ResultSet rs;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            
            if (clienteNovo) {
                save(obj.getCliente(), conn);
                obj.getCliente().setIdCliente(idRetornadoCli);
                if(sucesso){
                    for (PecaServicoModel item : obj.getPecasSevico()) {
                        ps3 = conn.prepareStatement(sql_2);
                        ps3.setInt(1, idRetornadoOs);
                        ps3.setString(2, item.getTipo());
                        ps3.setString(3, item.getDescricao());
                        ps3.setDouble(4, item.getQuantidade());
                        ps3.setDouble(5, item.getValorUn());
                        ps3.setDouble(6, item.getValorTotal());
                        ps3.execute();
                        sucesso = true;
                    }      
                }
            } else {
                //atualizando o cliente com novas informações
                update(obj.getCliente(), conn);
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
    public  void save(ClienteModel obj, Connection conn)  {
        // variavel com a string do comando SQL para inserção de dados
        String sql = ""; // salvar cliente
        String sqlIdRetorno = "";
        
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
    public void save(PecaServicoModel obj, Connection conn) {
        // variavel com a string do comando SQL para inserção de dados
        String sql = ""; // salvar cliente

        PreparedStatement ps = null; // salvar Ordem de Serviço

        try {
            conn = ConnectDb.getConexaoDAO();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdOrdem());
            ps.setString(2, obj.getTipo());
            ps.setString(3, obj.getDescricao());
            ps.setDouble(4, obj.getQuantidade());
            ps.setDouble(5, obj.getValorUn());
            ps.setDouble(6, obj.getValorTotal());
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
    public void update(OrdemServicoModel obj, Connection conn) {
        // variavel com a string do comando SQL para atualização dos dados na enticade
        String sql = ""; // atualiza Ordem de Serviço
        String sql_1 = "";  //atualiza Itens da ordem de serviço

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
                ps2.setDouble(4, item.getQuantidade());
                ps2.setDouble(5, item.getValorUn());
                ps2.setDouble(6, item.getValorTotal());
                ps2.setInt(7, item.getIdServPeca());
                ps2.execute();
                sucesso = true;
            }
             
            retorno = retorno + "Atualizado lista de itens!";
            sucesso = update(obj.getCliente(),conn); // aqui atualiza o cliente.
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
    public boolean update(ClienteModel obj, Connection conn)  {
        boolean ret = false;
        // variavel com a string do comando SQL para atualização dos dados na enticade
        String sql = "";
        
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
    
    
    /**
     * atualiza o item na lista de peca e servico da ordem de servico
     * @param obj 
     */
    public void update(PecaServicoModel obj, Connection conn)  {
        // variavel com a string do comando SQL para atualização dos dados na enticade
        String sql = "";
        

        PreparedStatement ps = null;
               
        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);

            //adicionando os valores de acordo a ordem dos parametros do string sql

            ps.setInt(1, obj.getIdOrdem());
            ps.setString(2, obj.getTipo());
            ps.setString(3, obj.getDescricao());
            ps.setDouble(4, obj.getQuantidade());
            ps.setDouble(5, obj.getValorUn());
            ps.setDouble(6, obj.getValorTotal());
            ps.setInt(7, obj.getIdServPeca());
            ps.execute();
            
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
    
    
    /**
     * deleta os itens e a ordem de servico com o parametro IdOrdem inserido
     * @param parametro 
     */
    public void deleteById(int parametro, Connection conn) {
        // variavel com a string do comando SQL para atualização dos dados na enticade Colaborador
        String sql = "delete from itens_ordemserrvico where id_ordem = ?";
        String sql2 = "delete from ordemservico where id = ?";
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps1 = conn.prepareStatement(sql);
            //adicionando os valores de acordo a ordem dos parametros do string sql
            ps1.setInt(1, parametro);
            //executando a instrução com os parametro setados da classe colaborador
            ps1.execute();
            retorno = "Deletado itens com sucesso e";
            
            ps = conn.prepareStatement(sql2);
            ps.setInt(1, parametro);
            ps.execute();
            
            
            retorno = retorno + " OS deletada com sucesso!";
            sucesso = true;
        } catch (SQLException e) {
            retorno = "Erro ao Deletar: " + e.getMessage();
            sucesso = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (ps1 != null) {
                    ps1.close();
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

    /**
     * traz o objeto pelo id cadastrado no banco (objeto completo com lista de itens (serviços e peças) )
     * @param idOs
     * @return 
     */
    public OrdemServicoModel findById(int idOs, Connection conn) {
        OrdemServicoModel obj = new OrdemServicoModel();
        String sql ="select os.id as idOrdem, os.nomeVeiculo, os.modeloVeiculo, os.marcaVeiculo, os.corVeiculo, os.placaVeiculo, os.mecanico,"
                + " os.defeitoreclamado, os.relatomecanico, os.datachegada, os.dataentrega, os.status, cl.id as idCliente, cl.nome, cl.cpf,"
                + " cl.rg, cl.rua, cl.bairro, cl.numero, cl.cidade, cl.estado, cl.cep, cl.celular, ios.id as idItemOs, ios.tipo, ios.descricao,"
                + " ios.quantidade, ios.valor_un, ios.valor_total"
                + " from ordemservico os"
                + " inner join cliente cl on cl.id = os.id_cliente"
                + " inner join itens_ordemservico ios on ios.id_ordem = os.id"
                + " where os.id = ?";      
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {           
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idOs);
            rs = ps.executeQuery();
            
            //declarando modelos para carregar objetos
            ClienteModel objCli = new ClienteModel();
            ArrayList<PecaServicoModel> listaPecaServico = new ArrayList<>();

            while(rs.next()){
            
            obj.setIdOrdem(rs.getInt(1));
            obj.setNomeVeiculo(rs.getString(2));
            obj.setModeloVeiculo(rs.getString(3));
            obj.setMarcaVeiculo(rs.getString(4));
            obj.setCorVeiculo(rs.getString(5));
            obj.setPlacaVeiculo(rs.getString(6));
            obj.setMecanico(rs.getString(7));
            obj.setDefeitoReclamado(rs.getString(8));
            obj.setRelatoMecanico(rs.getString(9));
            obj.setDataChegada(rs.getString(10));
            obj.setDataEntrega(rs.getString(11));
            obj.setStatus(rs.getString(12));
            objCli.setIdCliente(rs.getInt(13));
            objCli.setNome(rs.getString(14));
            objCli.setCpf(rs.getString(15));
            objCli.setRg(rs.getString(16));
            objCli.setRua(rs.getString(17));
            objCli.setBairro(rs.getString(18));
            objCli.setNumero(rs.getString(19));
            objCli.setCidade(rs.getString(20));
            objCli.setEstado(rs.getString(21));
            objCli.setCep(rs.getString(22));
            objCli.setCelular(rs.getString(23));
            obj.setCliente(objCli); // adicionando o cliente ao ObjetoPrincipal

            PecaServicoModel objPs = new PecaServicoModel(); //criando um objeto pra adicional a lista de peças
            objPs.setIdServPeca(rs.getInt(24));
            objPs.setIdOrdem(obj.getIdOrdem());
            objPs.setTipo(rs.getString(25));
            objPs.setDescricao(rs.getString(26));
            objPs.setQuantidade(rs.getDouble(27));
            objPs.setValorUn(rs.getDouble(28));
            objPs.setValorTotal(rs.getDouble(29));
            listaPecaServico.add(objPs); // adicionando item a lista
             
            obj.setPecasSevico(listaPecaServico); //adicionado a lista no objeto principal

            }
            retorno = "Encontrado!";
            sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            System.out.println("Erro aqui: " + e);
            sucesso = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
    
    /**
     * traz toda a lista de Os cadastradas no banco de dados, para usar no carregamento da tabela do sistema.
     * @return 
     */
    
    public ArrayList<OrdemServicoModel> findAll(Connection conn)  {

        ArrayList<OrdemServicoModel> list = new ArrayList<OrdemServicoModel>();
        
        //query de SQL
        String sql ="SELECT os.id, os.id_cliente, cl.nome, cl.cpf, cl.rg, cl.rua, "
                + " cl.bairro, cl.numero, cl.cidade, cl.estado, cl.cep, cl.celular, "
                + " os.nomeVeiculo, os.modeloVeiculo, os.marcaVeiculo, os.corVeiculo, "
                + " os.placaVeiculo, os.mecanico, os.defeitoreclamado, os.relatomecanico, "
                + " os.datachegada, os.dataentrega, os.status "
                + " FROM ordemservico os"
                + " inner join cliente cl on cl.id = os.id_cliente "
                + " order by cl.nome, os.placaVeiculo";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                ClienteModel cliM = new ClienteModel();
                OrdemServicoModel os = new OrdemServicoModel();
                os.setIdOrdem(rs.getInt(1));
                cliM.setIdCliente(rs.getInt(2));
                cliM.setNome(rs.getString(3));
                cliM.setCpf(rs.getString(4));
                cliM.setRg(rs.getString(5));
                cliM.setRua(rs.getString(6));
                cliM.setBairro(rs.getString(7));
                cliM.setNumero(rs.getString(8));
                cliM.setCidade(rs.getString(9));
                cliM.setEstado(rs.getString(10));
                cliM.setCep(rs.getString(11));
                cliM.setCelular(rs.getString(12));
                os.setCliente(cliM);
                os.setNomeVeiculo(rs.getString(13));
                os.setModeloVeiculo(rs.getString(14));
                os.setMarcaVeiculo(rs.getString(15));
                os.setCorVeiculo(rs.getString(16));
                os.setPlacaVeiculo(rs.getString(17));
                os.setMecanico(rs.getString(18));
                os.setDefeitoReclamado(rs.getString(19));
                os.setRelatoMecanico(rs.getString(20));
                os.setDataChegada(rs.getString(21));
                os.setDataEntrega(rs.getString(22));
                os.setStatus(rs.getString(23));
                list.add(os);
            }
            retorno = "Encontrado!";
            sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            sucesso = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
        return list;
    }
    
    /**
     * traz toda a lista de Os cadastradas no banco de dados, passando paramentro String
     * filtros podem ser Nome Cliente, Celular Cliente, Nome Veiculo, Modelo Veiculo, PlacaVeiculo,
     * Mecanico, ordenado pelo nome do cliente e placa do veiculo.
     * @param parametro
     * @return 
     */
    public ArrayList<OrdemServicoModel> findAllParameter(String parametro, Connection conn)  {

        ArrayList<OrdemServicoModel> list = new ArrayList<OrdemServicoModel>();
        
        //query de SQL
        String sql ="SELECT os.id, os.id_cliente, cl.nome, cl.cpf, cl.rg, cl.rua, "
                + " cl.bairro, cl.numero, cl.cidade, cl.estado, cl.cep, cl.celular, "
                + " os.nomeVeiculo, os.modeloVeiculo, os.marcaVeiculo, os.corVeiculo, "
                + " os.placaVeiculo, os.mecanico, os.defeitoreclamado, os.relatomecanico, "
                + " os.datachegada, os.dataentrega, os.status "
                + " FROM ordemservico os"
                + " inner join cliente cl on cl.id = os.id_cliente "
                + " where cl.nome like '"+parametro+"%' or cl.celular like '"+parametro+"%' or os.nomeVeiculo like '"+parametro+"%'"
                + " or os.modeloVeiculo like '"+parametro+"%' or os.placaVeiculo like '"+parametro+"%' or os.mecanico like '"+parametro+"%'"
                + " order by cl.nome, os.placaVeiculo";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectDb.getConexaoDAO();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                ClienteModel cliM = new ClienteModel();
                OrdemServicoModel os = new OrdemServicoModel();
                os.setIdOrdem(rs.getInt(1));
                cliM.setIdCliente(rs.getInt(2));
                cliM.setNome(rs.getString(3));
                cliM.setCpf(rs.getString(4));
                cliM.setRg(rs.getString(5));
                cliM.setRua(rs.getString(6));
                cliM.setBairro(rs.getString(7));
                cliM.setNumero(rs.getString(8));
                cliM.setCidade(rs.getString(9));
                cliM.setEstado(rs.getString(10));
                cliM.setCep(rs.getString(11));
                cliM.setCelular(rs.getString(12));
                os.setCliente(cliM);
                os.setNomeVeiculo(rs.getString(13));
                os.setModeloVeiculo(rs.getString(14));
                os.setMarcaVeiculo(rs.getString(15));
                os.setCorVeiculo(rs.getString(16));
                os.setPlacaVeiculo(rs.getString(17));
                os.setMecanico(rs.getString(18));
                os.setDefeitoReclamado(rs.getString(19));
                os.setRelatoMecanico(rs.getString(20));
                os.setDataChegada(rs.getString(21));
                os.setDataEntrega(rs.getString(22));
                os.setStatus(rs.getString(23));
                list.add(os);
            }
            retorno = "Encontrado!";
            sucesso = true;

        } catch (SQLException e) {
            retorno = "Erro: " + e;
            sucesso = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
        return list;
    }
}
