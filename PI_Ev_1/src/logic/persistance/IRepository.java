package logic.persistance;

import java.util.List;
import logic.obj.Runner;

public interface IRepository {
    public boolean addRunner(Runner runner);
    public boolean removeRunner(int pos);
    public boolean removeRunner(Runner runner);
    public boolean updateRunner(Runner runner, Runner updatedRunner);
    public Runner getRunner(int pos);
    public List<Runner> getRunners();
    public List<Runner> getRunnersByDateOfBirthAsc();
    public List<Runner> getRunnersByDateOfBirthDesc();
    
    public void persist();
    public void automaticPersistance();
}
