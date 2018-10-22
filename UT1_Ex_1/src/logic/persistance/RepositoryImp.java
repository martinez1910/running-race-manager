package logic.persistance;

import java.util.ArrayList;
import java.util.List;
import logic.obj.Match;

public class RepositoryImp implements IRepository {
    private final static String fileName = "matches.txt";
    
    private static RepositoryImp instance = null;
    private IFileManager fileManager;
    private List<Match> matches = new ArrayList<Match>();
    
    private RepositoryImp(){
        fileManager = FileManagerImp.getInstance(fileName);
        initLoadMatches();
    }
    
    public static RepositoryImp getInstance(){
        if(instance == null)
            instance = new RepositoryImp();
        return instance;
    }
    
    private void initLoadMatches() {
       for(String line : fileManager.readLines())
           if(line != null && !line.trim().equals(""))
               matches.add(MatchMapper.map(line));
    }

    @Override
    public  void addMatch(Match match) {
        matches.add(match);
    }

    @Override
    public void removeMatch(int pos) {
        matches.remove(pos);
    }

    @Override
    public void removeMatch(Match match) {
        matches.remove(match);
    }

    @Override
    public List<Match> getMatches() {
        return this.matches;
    }

    @Override
    public List<Match> getMatchesOrderedByDateAsc() {
        ArrayList<Match> matchesTmp = new ArrayList<Match>();
        for(Match match : matches)
            matchesTmp.add(match);
        matchesTmp.sort((m1,m2) -> m1.getDate().compareTo(m2.getDate()));
        return matchesTmp;
    }

    @Override
    public List<Match> getMatchesOrderedByDateDesc() {
        ArrayList<Match> matchesTmp = new ArrayList<Match>();
        for(Match match : matches)
            matchesTmp.add(match);
        matchesTmp.sort((m1,m2) -> m2.getDate().compareTo(m1.getDate()));
        return matchesTmp;
    }

    @Override
    public List<Match> getMatchesByLeague(Match.League league) {
        ArrayList<Match> matchesTmp = new ArrayList<Match>();
        for(Match match : matches)
            if(match.getLeague().equals(league))
                matchesTmp.add(match);
        return matchesTmp;
    }   
    
    @Override
    public void persist(){
        ArrayList<String> matchesStr = new ArrayList<String>();
        for(Match match : matches)
            matchesStr.add(MatchMapper.map(match));
        this.fileManager.writeLines(matchesStr);
    }
}
