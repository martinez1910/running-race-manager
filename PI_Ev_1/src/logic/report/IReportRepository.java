package logic.report;

import logic.obj.Race;

public interface IReportRepository {
    public boolean getReport1(String directory);
    public boolean getReport2(Race race, String directory);
    public boolean getReport3(String directory);
    public boolean getReport4(String directory);
}
