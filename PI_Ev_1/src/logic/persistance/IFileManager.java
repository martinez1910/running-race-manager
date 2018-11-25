package logic.persistance;

import java.util.List;
import logic.obj.Race;
import logic.obj.Runner;
import logic.obj.RunnerInRace;

public interface IFileManager {
    public List<Runner> readRunners();
    public void persistRunners(List<Runner> runners);
    
    public List<Race> readRaces();
    public void persistRaces(List<Race> races);
    
    public List<RunnerInRace> readRunnersInRaces();
    public void persistRunnersInRaces(List<RunnerInRace> runnersInRaces);
}
