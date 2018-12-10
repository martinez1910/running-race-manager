package logic.persistance;

import gui.Configuration;
import java.util.List;
import logic.obj.Race;
import logic.obj.Runner;
import logic.obj.RunnerInRace;

/**
 * Interface to be implemented by the system in charge of the file management
 * for persistence.
 * @author Alejandro Martínez Remis
 */
public interface IFileManager {
    /**
     * Retrieves the runners from their file
     * @return The list of runners
     */
    public List<Runner> readRunners();
    /**
     * Writes the runners into their file
     * @param configuration The runners to be written
     */
    public void persistRunners(List<Runner> runners);
    
    /**
     * Retrieves the races from their file
     * @return The list of races
     */
    public List<Race> readRaces();
    /**
     * Writes the races into their file
     * @param configuration The races to be written
     */
    public void persistRaces(List<Race> races);
    
    /**
     * Retrieves the runners in races from their file
     * @return The list of runners in races
     */
    public List<RunnerInRace> readRunnersInRaces();
    /**
     * Writes the runners in races into their file
     * @param configuration The runners in races to be written
     */
    public void persistRunnersInRaces(List<RunnerInRace> runnersInRaces);
    
    /**
     * Retrieves the configuration from its file
     * @return The configuration
     */
    public Configuration readConfiguration();
    /**
     * Writes the configuration into its file
     * @param configuration The configuration to be written
     */
    public void persistConfiguration(Configuration configuration);
}
