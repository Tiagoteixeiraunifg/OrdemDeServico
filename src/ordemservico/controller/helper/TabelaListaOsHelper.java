
package ordemservico.controller.helper;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ordemservico.model.OrdemServicoModel;
import ordemservico.util.Util;

/**
 *
 * @author Tiago Teixeira
 */
public class TabelaListaOsHelper extends AbstractTableModel {

    private final List<OrdemServicoModel> listOs; 
 
    private final String[] colunas = {"Codigo", "Cliente", "Placa", "Carro", "Modelo", "Cor", "Mecanico", "Data Chegada", "Data Entrega"};
    
    
    public TabelaListaOsHelper(List<OrdemServicoModel> listOs) {
        this.listOs = listOs;
    }

   @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return listOs.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        OrdemServicoModel os = listOs.get(linha);
        switch (coluna) {
            case 0:
                return os.getIdOrdem();
            case 1:
                return os.getCliente().getNome();
            case 2:
                return os.getPlacaVeiculo();
            case 3:
                return os.getNomeVeiculo();
            case 4:
                return os.getModeloVeiculo();
            case 5:
                return os.getCorVeiculo();
            case 6:
                return os.getMecanico();
            case 7:
                return new Util().dataFormatoBR(os.getDataChegada());
            case 8:
                return new Util().dataFormatoBR(os.getDataEntrega());
            default:
                return null;
        }

    }
    
    public Class getColClass(int coluna){
        switch (coluna) {

            case 0:
                return int.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
                return String.class;
            case 8:
                return String.class;
            default:
                return null;
        }
    }
    
    public void addRow(OrdemServicoModel listOs) {
        this.listOs.add(listOs);
        this.fireTableDataChanged();
    }
    
    public void deleteRow(int indice){
        this.listOs.remove(indice);
        this.fireTableRowsDeleted(0, getRowCount());
    }
    
    public void updatedRow(int indiceI, int indiceF){
        this.fireTableRowsUpdated(indiceI, indiceF);
    }
    
    public void updatedListRow(int indiceI, OrdemServicoModel os){
        this.listOs.set(indiceI, os);
    }
    
    public void clearList(){
        this.listOs.removeAll(new ArrayList<>());
        this.fireTableRowsDeleted(0, getRowCount());
        
    }
        
}
