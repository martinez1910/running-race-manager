package cli;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import logic.obj.Match;
import logic.obj.Result;
import logic.persistance.RepositoryImp;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true){
            selectOption(showMenu());
        }
    }
    
    
    private static int showMenu(){
        String str = "#####################";
        str += "# RUGBY MATCHES APP #";
        str += "#####################";
        str += "\nSelect one of the following options:\n";
        str += "1 - Add new match.\n";
        str += "2 - Remove match.\n";
        str += "3 - Show all matches.\n";
        str += "4 - Show all matches ordered by date (asc/desc).\n";
        str += "5 - Show all matches of a given league.\n";
        str += "6 - Exit.";
        System.out.println(str);
        boolean error = false;
        int option = -1;
        do{
            try{
                option = Integer.parseInt(SCANNER.nextLine());
                if(option >= 1 && option <= 6)
                    error = false;
                else
                    throw new NumberFormatException();
            }catch(NumberFormatException e){
                System.out.println("Please, introduce a correct value");
                error = true;
            }
        }while(error);
        return option;
    }
    
    private static void selectOption(int option){
        switch(option){
            case 1:
                newMatch();
                break;
            case 2:
                removeMatch();
                break;
            case 3:
                printAllMatches();
                break;
            case 4:
                printMatchesOrderedByDate();
                break;
            case 5:
                printMatchesByLeague();
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println("\nPlease, choose an option between 1 and 6:");
        }
    }
    
    private static void newMatch() {
        Result result = new Result(-1, -1);
        Match.League league = null;
        Date date = null;
        
        System.out.println("Insert home team (whitespaces will be trimmed):");
        String home = SCANNER.nextLine().trim();
        
        System.out.println("Insert visiting team (whitespaces will be trimmed):");
        String visiting = SCANNER.nextLine().trim();
        
        boolean error = false;
        do{
            System.out.println("Insert a division(" +Arrays.toString(Match.League.values()) +"):");
            String division = SCANNER.nextLine().toUpperCase()
                    ;
            try{
                Match.League leagueAux = Match.League.valueOf(division);
                switch(leagueAux){
                    case FIRST:
                    case SECOND:
                    case THIRD:
                        league = leagueAux;
                        error = false;
                        break;
                }
            }catch(IllegalArgumentException e){
                System.out.println("Please, write a valid option.");
                error = true;
            }
        }while(error);
        
        do{
            System.out.println("Insert home team score:");
            String strHomeScore = SCANNER.nextLine();
            try{
                int homeScore = Integer.parseInt(strHomeScore);
                if(homeScore >= 0){
                    result.setHomeResult(homeScore);
                    error = false;
                }
                else
                    error = true;
            }catch(NumberFormatException e){
                error = true;
            }
        }while(error);
        
        do{
            System.out.println("Insert visiting team score:");
            String strVisitingScore = SCANNER.nextLine();
            try{
                int visitingScore = Integer.parseInt(strVisitingScore);
                if(visitingScore >= 0){
                    result.setVisitingResult(visitingScore);
                    error = false;
                }
                else
                    error = true;
            }catch(NumberFormatException e){
                error = true;
            }
        }while(error);
        
        do{
            System.out.println("Insert date (dd-mm-yyyy):");
            String strDate = SCANNER.nextLine();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //issues with this line.
            try{
                date = dateFormat.parse(strDate);
                error = false;
            }catch(ParseException e){
                error = true;
            }
        }while(error);
        
        Match match = new Match(home, visiting, league, result, date);
        RepositoryImp.getInstance().addMatch(match);
    }

    private static void removeMatch() {
        boolean error = false;
        List<Match> matches = RepositoryImp.getInstance().getMatches();
        if(matches.isEmpty()){
            System.out.println("No matches found!");
            return;
        }
        do{
            String strAux = "";
            if(matches.size() > 1)
                strAux = " - " +(matches.size()-1);
            String str = "Which match do you want to remove? (valid range [0" +strAux +"])";
            System.out.println(str);
            int pos = Integer.parseInt(SCANNER.nextLine());
            if(pos >= 0 && pos < matches.size()){
                RepositoryImp.getInstance().removeMatch(pos);
                error = false;
            }else{
                System.out.println("Please, write a valid option:");
                error = true;
            }
        }while(error);
    }

    private static void printAllMatches() {
        List<Match> matches = RepositoryImp.getInstance().getMatches();
        if(matches.isEmpty()){
            System.out.println("No matches found!");
            return;
        }
        printListOfMatches(matches);        
    }

    private static void printMatchesOrderedByDate() {
        if(RepositoryImp.getInstance().getMatches().isEmpty()){
            System.out.println("No matches found!");
            return;
        }
        boolean error = false;
        do{
            String str = "Ascendant or descendant order?";
            System.out.println(str);
            switch(SCANNER.nextLine().toLowerCase()){
                case "asc":
                case "ascendant":
                    printListOfMatches(RepositoryImp.getInstance().getMatchesOrderedByDateAsc());
                    error = false;
                    break;
                case "desc":
                case "descendant":
                    printListOfMatches(RepositoryImp.getInstance().getMatchesOrderedByDateDesc());
                    error = false;
                    break;
                default:
                    System.out.println("Please, write a valid option:");
                    error = true;
            }
        }while(error);
    }

    private static void printMatchesByLeague() {
        if(RepositoryImp.getInstance().getMatches().isEmpty()){
            System.out.println("No matches found!");
            return;
        }
        
        boolean error = false;
        do{
            String str = "Which league? (" +Arrays.toString(Match.League.values()) +"):";
            System.out.println(str);
            String leagueStr = SCANNER.nextLine().toUpperCase();
            try{
                Match.League league = Match.League.valueOf(leagueStr);
                switch(Match.League.valueOf(leagueStr)){
                    case FIRST:
                    case SECOND:
                    case THIRD:
                        printListOfMatches(RepositoryImp.getInstance().getMatchesByLeague(league));
                        error = false;
                        break;
                }
            }catch(IllegalArgumentException e){
                System.out.println("Please, write a valid option.");
                error = true;
            }
        }while(error);
    }

    private static void exit() {
        boolean error = false;
        do{
            String str = "Are you sure you want to exit? Y/N";
            System.out.println(str);
            switch(SCANNER.nextLine().toLowerCase()){
                case "y":
                case "yes":
                    persist();
                    System.exit(0);
                case "n":
                case "no":
                    error = false;
                    break;
                default:
                    System.out.println("Please, write a valid option:");
                    error = true;
            }
        }while(error);
    }
    
    private static void persist(){
        if(RepositoryImp.getInstance().getMatches().isEmpty()) return;
        
        boolean error = false;
        do{
            String str = "Do you want to save the changes made? Y/N";
            System.out.println(str);
            switch(SCANNER.nextLine().toLowerCase()){
                case "y":
                case "yes":
                    RepositoryImp.getInstance().persist();
                case "n":
                case "no":
                    break;
                default:
                    System.out.println("Please, write a valid option:");
                    error = true;
            }
        }while(error);
    }
    
    private static void printListOfMatches(List<Match> matches){
        if(matches.isEmpty()){
            System.out.println("No matches found!");
            return;
        }
        for(int i = 0; i < matches.size(); i++)
            System.out.println(i +" - " +matches.get(i));
    }
}
