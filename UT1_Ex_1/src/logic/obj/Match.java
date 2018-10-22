
package logic.obj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Match {
    public enum League{
        FIRST , SECOND, THIRD
    }
    private String homeTeam, visitingTeam;
    private League league;
    private Result result;
    private Date date;

    public Match(String homeTeam, String visitingTeam, League league, Result result, Date date) {
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.league = league;
        this.result = result;
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeam(String visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * TODO: Format date
     * @return 
     */
    @Override
    public String toString() {
        return "Match{" + "homeTeam=" + homeTeam + ", visitingTeam=" + visitingTeam + ", league=" + league + ", result=" + result + ", date=" +(new SimpleDateFormat("dd-mm-yyyy")).format(date) + '}';
    }
}
