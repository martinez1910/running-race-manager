package logic.report;

import logic.obj.Race;
import logic.obj.Runner;

public interface IReportRepository {
    public boolean getReport1(String directory);
    public boolean getReport2(Race race, String directory);
    public boolean getReport3(Race race, String directory);
    public boolean getReport4(Runner runner, String directory);
}
