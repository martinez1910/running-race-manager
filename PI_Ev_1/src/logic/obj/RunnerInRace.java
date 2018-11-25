package logic.obj;

import java.io.Serializable;
import logic.persistance.RepositoryImp;

public class RunnerInRace implements Serializable{
    private int numRunner;
    private int numRace;
    private int number;
    private int position;
    private long time;

    public RunnerInRace(int numRunner, int numRace, int number, int position, long time) {
        this.numRunner = numRunner;
        this.numRace = numRace;
        this.number = number;
        this.position = position;
        this.time = time;
    }

    public RunnerInRace(String[] runnerInRace) {
        if(runnerInRace.length != 5) 
            throw new IllegalArgumentException("Cannot construct the object with the given array (inconsistent number of elements found)");
        this.numRunner = Integer.parseInt(runnerInRace[0]);
        this.numRace = Integer.parseInt(runnerInRace[1]);
        this.number = Integer.parseInt(runnerInRace[2]);
        this.position = Integer.parseInt(runnerInRace[3]);
        this.time = Long.parseLong(runnerInRace[4]);
    }
    
    public int getNumRunner() {
        return numRunner;
    }

    public void setNumRunner(int numRunner) {
        this.numRunner = numRunner;
    }

    public int getNumRace() {
        return numRace;
    }

    public void setNumRace(int numRace) {
        this.numRace = numRace;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    public Runner getRunner(){
        return RepositoryImp.getInstance().getRunner(this.numRunner);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof RunnerInRace)) return false;
        RunnerInRace runnerInRace = (RunnerInRace) obj;
        return runnerInRace.numRunner == this.numRunner
                && runnerInRace.numRace == this.numRace;
    }
    
    public String toCSV(){
        String csv = "";
        csv += this.numRunner +",";
        csv += this.numRace +",";
        csv += this.number +",";
        csv += this.position +",";
        csv += this.time;
        return csv;
    }
    
    @Override
    public String toString() {
        return "RunnerInRace{" + "numRunner=" + numRunner + ", numRace=" + numRace + ", number=" + number + ", position=" + position + ", time=" + time + '}';
    }
}
