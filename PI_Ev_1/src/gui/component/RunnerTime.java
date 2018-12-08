package gui.component;

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
