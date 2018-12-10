package gui.component;

/**
 * Interface to be implemented by the listener of the {@link gui.component.JStopwatch JStopwatch}
 * @author Alejandro Martínez Remis
 */
public interface JStopwatchListener {
    /**
     * Receives a {@link gui.component.RunnerTime RunnerTime} instance with
     * the runner's number and the finishing time.
     * @param runnerTime 
     */
    public void runnerGiven(RunnerTime runnerTime);
}
