package gui.tablemodel;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.obj.Runner;

/**
 * Table model for runners.
 * @author Alejandro Martínez Remis
 */
public class RunnerTableModel extends AbstractTableModel {
    private final List<Runner> runners;
    private final String[] columnNames = {"Nombre", "DNI", "Fecha de nacimiento", "Dirección", "Teléfono"};
    
    public RunnerTableModel(List<Runner> runners){
        this.runners = runners;
    }
    
    @Override
    public int getRowCount() {
        return this.runners.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.runners.get(rowIndex).getName();
            case 1:
                return this.runners.get(rowIndex).getId();
            case 2:
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                return format.format(this.runners.get(rowIndex).getDateOfBirth());
            case 3:
                return this.runners.get(rowIndex).getAddress();
            case 4:
                return this.runners.get(rowIndex).getPhoneNumber();
            default:
                util.MyUtil.unreachableCode("Invalid columnIndex");
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    } 
}
