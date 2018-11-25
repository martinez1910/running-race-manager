package logic.obj;

import java.io.Serializable;
import java.util.Date;

public class Race implements Serializable{
    private int numRace;
    private String name;
    private Date date;
    private String location;
    private int maxRunners;
    private boolean finished;

    public Race(int numRace, String name, Date date, String location, int maxRunners, boolean finished) {
        this.numRace = numRace;
        this.name = name;
        this.date = date;
        this.location = location;
        this.maxRunners = maxRunners;
        this.finished = finished;
    }
    
    public Race(String[] race) {
        if(race.length != 6) 
            throw new IllegalArgumentException("Cannot construct the object with the given array (inconsistent number of elements found)");
        this.numRace = Integer.parseInt(race[0]);
        this.name = race[1];
        this.date = new Date(Long.parseLong(race[2]));;
        this.location = race[3];
        this.maxRunners = Integer.parseInt(race[4]);
        this.finished = Boolean.parseBoolean(race[5]);
    }
    
    public int getNumRace() {
        return numRace;
    }

    public void setNumRace(int numRace) {
        this.numRace = numRace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxRunners() {
        return maxRunners;
    }

    public void setMaxRunners(int maxRunners) {
        this.maxRunners = maxRunners;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof Race)) return false;
        Race race = (Race) obj;
        return race.name.equals(this.name)
                && race.date.equals(this.date)
                && race.location.equals(this.location);
    }
    
    public String toCSV(){
        String csv = "";
        csv += this.numRace +",";
        csv += this.name +",";
        csv += this.date.getTime() +",";
        csv += this.location +",";
        csv += this.maxRunners +",";
        csv += this.finished;
        return csv;
    }

    @Override
    public String toString() {
        return "Race{" +"numRace=" +numRace + "name=" + name + ", date=" + date + ", location=" + location + ", maxRunners=" + maxRunners + ", finished=" + finished + '}';
    }
}
