package logic.persistance;

import java.util.List;
import logic.obj.Match;


public interface IRepository {
    public void addMatch(Match match);
    
    public void removeMatch(int pos);
    
    public void removeMatch(Match match);
    
    public List<Match> getMatches();
    
    /**
     * Relies on {@link #getMatches() getMatches} method.
     * @return 
     */
    public List<Match> getMatchesOrderedByDateAsc();
    
    /**
     * Relies on {@link #getMatches() getMatches} method.
     * @return 
     */
    public List<Match> getMatchesOrderedByDateDesc();
    
    /**
     * Relies on {@link #getMatches() getMatches} method.
     * @param league
     * @return 
     */
    public List<Match> getMatchesByLeague(Match.League league);
    
    public void persist();
}
