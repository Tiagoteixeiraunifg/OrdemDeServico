/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordemservico.controller.helper;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ordemservico.model.PecaServicoModel;

/**
 *
 * @author Tiago Teixeira
 */
public class TabelaListaServicoPecaHelper extends AbstractTableModel{
     private final List<PecaServicoModel> listOsPecaServ; 
 
    private final String[] colunas = {"Codigo", "Descricao", "Tipo", "Valor Un", "Valor Total"};
    
    
    public TabelaListaServicoPecaHelper(List<PecaServicoModel> listOsPecaServ) {
        this.listOsPecaServ = listOsPecaServ;
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
        return listOsPecaServ.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        PecaServicoModel os = listOsPecaServ.get(linha);
        switch (coluna) {
            case 0:
                return os.getIdServPeca();
            case 1:
                return os.getDescricao();
            case 2:
                return os.getTipo();
            case 3:
                return os.getValorUn();
            case 4:
                return os.getValorTotal();
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
                return Double.class;
            case 4:
                return Double.class;
            default:
                return null;
        }
    }
    
    public void addRow(PecaServicoModel listOsPecaServ) {
        this.listOsPecaServ.add(listOsPecaServ);
        this.fireTableDataChanged();
    }
    
    public void deleteRow(int indice){
        this.listOsPecaServ.remove(indice);
        this.fireTableRowsDeleted(0, getRowCount());
    }
    
    public void updatedRow(int indiceI, int indiceF){
        this.fireTableRowsUpdated(indiceI, indiceF);
    }
    
    public void updatedListRow(int indiceI, PecaServicoModel listOsPecaServ){
        this.listOsPecaServ.set(indiceI, listOsPecaServ);
    }
    
    public void clearList(){
        this.listOsPecaServ.removeAll(new ArrayList<PecaServicoModel>());
        this.fireTableRowsDeleted(0, getRowCount());
        
    }
}
