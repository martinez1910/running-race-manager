package logic.persistance;

import java.util.List;
import logic.obj.Runner;

public interface IFileManager {
    public List<Runner> readRunners();
    public void persistRunners(List<Runner> runners);
}
