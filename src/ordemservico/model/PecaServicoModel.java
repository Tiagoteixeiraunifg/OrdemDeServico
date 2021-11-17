
package ordemservico.model;

/**
 *
 * @author Tiago Teixeira
 */
public class PecaServicoModel {
    
    
    private int idServPeca;
    private int idOrdem;
    private String tipo;
    private String descricao;
    private double quantidade;
    private double valorUn;
    private double valorTotal;
    
    
    public int getIdServPeca() {
        return idServPeca;
    }

    public void setIdServPeca(int idServPeca) {
        this.idServPeca = idServPeca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    
    public double getValorUn() {
        return valorUn;
    }

    public void setValorUn(double valorUn) {
        this.valorUn = valorUn;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }
    
    
    
    
    
}
