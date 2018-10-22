package logic.persistance;

import java.util.Date;
import logic.obj.Match;
import logic.obj.Result;

public class MatchMapper {
    public static Match map(String str){
        String[] properties = str.split(" ");
        Match match = new Match(properties[0],
                                properties[1],
                                Match.League.valueOf(properties[2].toUpperCase()),
                                new Result(Integer.parseInt(properties[3]), Integer.parseInt(properties[4])),
                                new Date(Long.parseLong(properties[5])));
        
        return match;
    }
    
    public static String map(Match match){
        String str = "";
        str += match.getHomeTeam() +" ";
        str += match.getVisitingTeam() +" ";
        str += match.getLeague().name() +" ";
        str += match.getResult().getHomeResult() +" ";
        str += match.getResult().getVisitingResult() +" ";
        str += match.getDate().getTime();
        return str;
    }
}
