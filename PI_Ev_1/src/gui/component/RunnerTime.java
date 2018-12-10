package gui.component;

/**
 * Object containing the runner's time and its number in the race.
 * @author Alejandro Martínez Remis
 */
public class RunnerTime {
    private int number;
    private long time;

    public RunnerTime(int number, long time) {
        this.number = number;
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
