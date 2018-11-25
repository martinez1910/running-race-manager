package gui.tablemodel;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.obj.Race;
import logic.persistance.RepositoryImp;

public class RaceTableModel extends AbstractTableModel {
    private final List<Race> races;
    private final String[] columnNames = {"Núm. Carrera", "Nombre", "Fecha", "Ubicación", "Núm. Corredores", "Máx. Núm. Corredores"};
    
    public RaceTableModel(List<Race> races){
        this.races = races;
    }
    
    @Override
    public int getRowCount() {
        return this.races.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.races.get(rowIndex).getNumRace();
            case 1:
                return this.races.get(rowIndex).getName();
            case 2:
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                return format.format(this.races.get(rowIndex).getDate());
            case 3:
                return this.races.get(rowIndex).getLocation();
            case 4:
                return RepositoryImp.getInstance().getRunnersInRace(this.races.get(rowIndex)).size();
            case 5:
                return this.races.get(rowIndex).getMaxRunners();
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
