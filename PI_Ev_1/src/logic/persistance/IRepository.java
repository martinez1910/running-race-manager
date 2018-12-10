package logic.persistance;

import gui.Configuration;
import java.util.List;
import logic.obj.Race;
import logic.obj.Runner;
import logic.obj.RunnerInRace;

public interface IRepository {
    public boolean addRunner(Runner runner);
    public boolean removeRunner(int pos);
    public boolean removeRunner(Runner runner);
    public boolean updateRunner(Runner runner, Runner updatedRunner);
    public Runner getRunner(int pos);
    public List<Runner> getRunners();
    public Runner getNonRemovedRunner(int pos);
    public List<Runner> getNonRemovedRunners();
    public List<Runner> getRunnersByDateOfBirthAsc();
    public List<Runner> getRunnersByDateOfBirthDesc();
    
    public boolean addRace(Race race);
    public boolean removeRace(int pos);
    public boolean removeRace(Race race);
    public boolean updateRace(Race race, Race updatedRace);
    public Race getRace(int pos);
    public List<Race> getRaces();
    public Race getUnfinishedRace(int pos);
    public List<Race> getUnfinishedRaces();
    public Race getFinishedRace(int pos);
    public List<Race> getFinishedRaces();
    public int getAvailableNumRace();
    
    public boolean addRunnerInRace(RunnerInRace runnerInRace);
    public boolean removeRunnerInRace(int pos);
    public boolean removeRunnerInRace(RunnerInRace runnerInRace);
    public boolean removeRunnersInRace(Race race);
    public boolean updateRunnerInRace(RunnerInRace runnerInRace, RunnerInRace updatedRunnerInRace);
    public RunnerInRace getRunnerInRace(int pos);
    public List<RunnerInRace> getRunnersInRaces();
    public List<RunnerInRace> getRunnersInRace(Race race);
    public List<Runner> getRunnersNotInList(List<RunnerInRace> runnersInList);
    
    public void setConfiguration(Configuration configuration);
    public Configuration getConfiguration();
    
    public void persist();
}
