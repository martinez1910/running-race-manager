package logic.report;

import java.util.ArrayList;
import java.util.List;

public class JasperPreviewFactory {
    
    public static List<Report1> getDataSourceReport1(){
        List<Report1> list = new ArrayList<>();
        list.add(new Report1("RaceName", "RaceLocation", 23));
        list.add(new Report1("Name", "Location", 4));
        list.add(new Report1("Testing", "Testing", 32));
        list.add(new Report1("No race", "Nowhere", 0));
        list.add(new Report1("Titan", "Olympus", 4));
        return list;
    }
}
