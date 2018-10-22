package logic.persistance;

import java.util.List;

public interface IFileManager {
    public List<String> readLines();
    public void writeLines(List<String> lines);
}
