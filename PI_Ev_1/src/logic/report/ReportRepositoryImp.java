package logic.report;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.obj.Race;
import logic.obj.Runner;
import logic.obj.RunnerInRace;
import logic.persistance.IRepository;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportRepositoryImp implements IReportRepository{

    private IRepository repository;

    public ReportRepositoryImp(IRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public boolean getReport1(String directory) {
        List<Object> reports = new ArrayList<>();
        for(Race race : repository.getUnfinishedRaces()){
            Report1 report = new Report1(race.getName(),
                                        race.getLocation(),
                                        repository.getRunnersInRace(race).size());
            reports.add(report);
        }
        
        return fillAndExportToPdf(reports, new HashMap(), "report1", directory);
    }

    @Override
    public boolean getReport2(Race race, String directory) {
        List<Object> reports = new ArrayList<>();
        for(RunnerInRace runnerInRace : repository.getRunnersInRace(race))
            reports.add(runnerInRace);
        
        Map map = new HashMap();
        map.put("RACE_NUMBER", race.getNumRace());
        map.put("RACE_NAME", race.getName());
        map.put("RACE_DATE", race.getDate());
        map.put("RACE_LOCATION", race.getLocation());
        map.put("RACE_MAX_RUNNERS", race.getMaxRunners());
        map.put("RACE_FINISHED", race.isFinished());
        return fillAndExportToPdf(reports, map, "report2", directory);
    }

    @Override
    public boolean getReport3(String directory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getReport4(String directory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private boolean fillAndExportToPdf(List<Object> data, Map param, String reportName, String pdfPath){
        try{
            String jasperPath = "src" +File.separator +"res" +File.separator +"report" +File.separator +reportName +".jasper";
            pdfPath += File.separator +reportName +"_" +System.currentTimeMillis() +".pdf";
            
            JRDataSource dataSource = new JRBeanCollectionDataSource(data);
            JasperPrint print = JasperFillManager.fillReport(jasperPath, param, dataSource);
            JasperExportManager.exportReportToPdfFile(print, pdfPath);
        }catch(JRException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
