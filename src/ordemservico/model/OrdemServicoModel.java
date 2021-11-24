
package ordemservico.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tiago Teixeira
 */
public class OrdemServicoModel {
        
        private ClienteModel cliente;
        private ArrayList<PecaServicoModel> pecasSevico;
        private ArrayList<ClienteModel> listClientes;
        private int idOrdem;
        private String nomeVeiculo;
        private String modeloVeiculo;
        private String marcaVeiculo;
        private String corVeiculo;
        private String placaVeiculo;
        private String mecanico;
        private String defeitoReclamado;
        private String relatoMecanico;
        private String dataChegada;
        private String dataEntrega;
        private String status;
        
    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public ArrayList<PecaServicoModel> getPecasSevico() {
        return pecasSevico;
    }

    public void setPecasSevico(ArrayList<PecaServicoModel> pecasSevico) {
        this.pecasSevico = pecasSevico;
    }

    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public String getDefeitoReclamado() {
        return defeitoReclamado;
    }

    public void setDefeitoReclamado(String defeitoReclamado) {
        this.defeitoReclamado = defeitoReclamado;
    }

    public String getRelatoMecanico() {
        return relatoMecanico;
    }

    public void setRelatoMecanico(String relatoMecanico) {
        this.relatoMecanico = relatoMecanico;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrdemServicoModel(ClienteModel cliente, ArrayList<PecaServicoModel> pecasSevico, String nomeVeiculo, String modeloVeiculo, String marcaVeiculo, String corVeiculo, String placaVeiculo, String mecanico, String defeitoReclamado, String relatoMecanico, String dataChegada, String dataEntrega, String status) {
        this.cliente = cliente;
        this.pecasSevico = pecasSevico;
        this.nomeVeiculo = nomeVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.corVeiculo = corVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.mecanico = mecanico;
        this.defeitoReclamado = defeitoReclamado;
        this.relatoMecanico = relatoMecanico;
        this.dataChegada = dataChegada;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }

    public OrdemServicoModel() {
    }

        
        
        
        
}
