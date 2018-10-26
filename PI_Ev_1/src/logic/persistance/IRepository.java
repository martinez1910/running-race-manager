package logic.persistance;

import java.util.List;
import logic.obj.Runner;

public interface IRepository {
    public boolean addRunner(Runner runner);
    public boolean removeRunner(Runner runner);
    public boolean updateRunner(Runner runner, Runner updatedRunner);
    public Runner getRunner(int pos);
    public List<Runner> getRunners();
    /**
     * Relies on {@link #getRunners() getRunners} method.
     * @return runners ordered by birthdate(asc)
     */
    public List<Runner> getRunnersByDateOfBirthAsc();
    /**
     * Relies on {@link #getRunners() getRunners} method.
     * @return runners ordered by birthdate(desc)
     */
    public List<Runner> getRunnersByDateOfBirthDesc();
    
    public void persist();
}
