package logic.report;

public class Report1 {
    private String raceName;
    private String raceLocation;
    private int raceRunners;

    public Report1(String raceName, String raceLocation, int raceRunners) {
        this.raceName = raceName;
        this.raceLocation = raceLocation;
        this.raceRunners = raceRunners;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getRaceLocation() {
        return raceLocation;
    }

    public void setRaceLocation(String raceLocation) {
        this.raceLocation = raceLocation;
    }

    public int getRaceRunners() {
        return raceRunners;
    }

    public void setRaceRunners(int raceRunners) {
        this.raceRunners = raceRunners;
    }
}
