package gui.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import logic.obj.RunnerInRace;

public class RunnerInFinishedRaceTableModel extends AbstractTableModel {
    private final List<RunnerInRace> runnersInRace;
    private final String[] columnNames = {"Nombre", "Dorsal", "Posición", "Tiempo"};
    
    public RunnerInFinishedRaceTableModel(List<RunnerInRace> runnersInRace){
        this.runnersInRace = runnersInRace;
    }
    
    @Override
    public int getRowCount() {
        return this.runnersInRace.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.runnersInRace.get(rowIndex).getRunner().getName();
            case 1:
                return this.runnersInRace.get(rowIndex).getNumber();
            case 2:
                return this.runnersInRace.get(rowIndex).getPosition();
            case 3:
                return this.runnersInRace.get(rowIndex).getFormattedTime();
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
