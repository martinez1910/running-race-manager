package gui;

import java.io.Serializable;

/**
 * Represents the configuration of the application
 * @author Alejandro Martínez Remis
 */
public class Configuration implements Serializable{
    private String lookAndFeel;
    private int minutesAutoPersist;

    public Configuration(String lookAndFeel, int minutesAutoPersist) {
        this.lookAndFeel = lookAndFeel;
        this.minutesAutoPersist = minutesAutoPersist;
    }
    
    public Configuration(String[] config) {
        if(config.length != 2) 
            throw new IllegalArgumentException("Cannot construct the object with the given array (inconsistent number of elements found)");
        this.lookAndFeel = config[0];
        this.minutesAutoPersist = Integer.parseInt(config[1]);
    }

    public String getLookAndFeel() {
        return lookAndFeel;
    }

    public void setLookAndFeel(String lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public int getMinutesAutoPersist() {
        return minutesAutoPersist;
    }

    public void setMinutesAutoPersist(int minutesAutoPersist) {
        this.minutesAutoPersist = minutesAutoPersist;
    }
    
    public String toCSV(){
        String csv = "";
        csv += this.lookAndFeel +",";
        csv += this.minutesAutoPersist;
        return csv;
    }
}
