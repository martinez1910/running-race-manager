package logic.persistance;

import gui.Configuration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import logic.obj.Race;
import logic.obj.Runner;
import logic.obj.RunnerInRace;

public class RepositoryImp implements IRepository{
    private final static long DEFAULT_AUTOMATIC_PERSISTANCE_INTERVAL = 30 * 60 * 1000;
    
    private static RepositoryImp instance = null;
    private final IFileManager fileManager;
    private final ArrayList<Runner> runners;
    private final ArrayList<Race> races;
    private final ArrayList<RunnerInRace> runnersInRaces;
    private Configuration configuration;
    
    private RepositoryImp(){
        fileManager = FileManagerImp.getInstance();
        runners = new ArrayList<>(fileManager.readRunners());
        races = new ArrayList<>(fileManager.readRaces());
        runnersInRaces = new ArrayList<>(fileManager.readRunnersInRaces());
        configuration = fileManager.readConfiguration();
        
        automaticPersistance();
    }
    
    public static RepositoryImp getInstance(){
        if(instance == null)
            instance = new RepositoryImp();
        return instance;
    }

    @Override
    public boolean addRunner(Runner runner) {
        runner = (Runner)util.MyUtil.copy(runner);
        if(!runners.contains(runner))
          return runners.add(runner);
        return false;          
    }

    @Override
    public boolean removeRunner(int pos) {
        return removeRunner(runners.get(pos));
    }
    
    @Override
    public boolean removeRunner(Runner runner) {
        runner = runners.get(runners.indexOf(runner));
        runner.setRemoved(true);
        return true;
    }

    @Override
    public boolean updateRunner(Runner runner, Runner updatedRunner) {
        updatedRunner = (Runner)util.MyUtil.copy(updatedRunner);
        for(int i=0; i < runners.size(); i++)
            if(runners.get(i).equals(runner)){
                runners.set(i, updatedRunner);
                return true;
            }
        return false;
    }

    @Override
    public Runner getRunner(int pos) {
        return (Runner)util.MyUtil.copy(runners.get(pos));
    }

    @Override
    public List<Runner> getRunners() {
        List<Runner> runnersCopy = new ArrayList<>();
        for(Runner runner : runners)
            runnersCopy.add((Runner)util.MyUtil.copy(runner));
        return runnersCopy;
    }
    
    @Override
    public Runner getNonRemovedRunner(int pos){
        return getNonRemovedRunners().get(pos);
    }
    
    @Override
    public List<Runner> getNonRemovedRunners(){
        List<Runner> nonRemovedRunners = new ArrayList<>();
        for(Runner runner : runners)
            if(!runner.isRemoved())
                nonRemovedRunners.add((Runner)util.MyUtil.copy(runner));
        return nonRemovedRunners;
    }

    @Override
    public List<Runner> getRunnersByDateOfBirthAsc() {
        ArrayList<Runner> tmp = new ArrayList<>();
        for(Runner runner : runners)
            tmp.add((Runner)util.MyUtil.copy(runner));
        tmp.sort(new Comparator<Runner>(){
            @Override
            public int compare(Runner r1, Runner r2){
                return r1.getDateOfBirth().compareTo(r2.getDateOfBirth());
            }
        });
        return tmp;
    }

    @Override
    public List<Runner> getRunnersByDateOfBirthDesc() {
        ArrayList<Runner> tmp = new ArrayList<>();
        for(Runner runner : runners)
            tmp.add((Runner)util.MyUtil.copy(runner));
        tmp.sort(new Comparator<Runner>(){
            @Override
            public int compare(Runner r1, Runner r2){
                return r2.getDateOfBirth().compareTo(r1.getDateOfBirth());
            }
        });
        return tmp;
    }

    @Override
    public boolean addRace(Race race) {
        race = (Race) util.MyUtil.copy(race);
        if(!races.contains(race))
          return races.add(race);
        return false;  
    }

    @Override
    public boolean removeRace(int pos) {
        return removeRace(races.get(pos));
    }

    @Override
    public boolean removeRace(Race race) {
        boolean result, finalResult=true;
        for(RunnerInRace runnerInRace : getRunnersInRace(race)){
            result = removeRunnerInRace(runnerInRace);
                if(!result) 
                    finalResult = false;
        }
        
        result = races.remove(race);
        if(finalResult)
            finalResult = result;
        
        return finalResult;
    }

    @Override
    public boolean updateRace(Race race, Race updatedRace) {
        updatedRace = (Race) util.MyUtil.copy(updatedRace);
        for(int i=0; i < races.size(); i++)
            if(races.get(i).equals(race)){
                races.set(i, updatedRace);
                return true;
            }
        return false;
    }

    @Override
    public Race getRace(int pos) {
        return (Race) util.MyUtil.copy(races.get(pos));
    }

    @Override
    public List<Race> getRaces() {
        List<Race> racesCopy = new ArrayList<>();
        for(Race race : races)
            racesCopy.add((Race) util.MyUtil.copy(race));
        return racesCopy;
    }
    
    @Override
    public Race getUnfinishedRace(int pos) {
        return getUnfinishedRaces().get(pos);
    }

    @Override
    public List<Race> getUnfinishedRaces() {
        List<Race> racesCopy = new ArrayList<>();
        for(Race race : races)
            if(!race.isFinished())
                racesCopy.add((Race) util.MyUtil.copy(race));
        return racesCopy;
    }
    
    @Override
    public Race getFinishedRace(int pos){
        return getFinishedRaces().get(pos);
    }
    
    @Override
    public List<Race> getFinishedRaces(){
        List<Race> racesCopy = new ArrayList<>();
        for(Race race : races)
            if(race.isFinished())
                racesCopy.add((Race) util.MyUtil.copy(race));
        return racesCopy;
    }
    
    @Override
    public int getAvailableNumRace(){
        if(this.races.isEmpty()) return 0;        
        return races.get(races.size()-1).getNumRace()+1;
    }

    @Override
    public boolean addRunnerInRace(RunnerInRace runnerInRace) {
        runnerInRace = (RunnerInRace) util.MyUtil.copy(runnerInRace);
        if(!runnersInRaces.contains(runnerInRace))
          return runnersInRaces.add(runnerInRace);
        return false;
    }

    @Override
    public boolean removeRunnerInRace(int pos) {
        return removeRunnerInRace(runnersInRaces.get(pos));
    }

    @Override
    public boolean removeRunnerInRace(RunnerInRace runnerInRace) {
        return runnersInRaces.remove(runnerInRace);
    }
    
    @Override
    public boolean removeRunnersInRace(Race race){
        boolean result, finalResult = true;
        for(RunnerInRace runnerInRace : getRunnersInRace(race)){
            result = runnersInRaces.remove(runnerInRace);
            if(!result)
                finalResult = false;
        }
        return finalResult;
    }

    @Override
    public boolean updateRunnerInRace(RunnerInRace runnerInRace, RunnerInRace updatedRunnerInRace) {
        updatedRunnerInRace = (RunnerInRace) util.MyUtil.copy(updatedRunnerInRace);
        for(int i=0; i < runnersInRaces.size(); i++)
            if(runnersInRaces.get(i).equals(runnerInRace)){
                runnersInRaces.set(i, updatedRunnerInRace);
                return true;
            }
        return false;
    }

    @Override
    public RunnerInRace getRunnerInRace(int pos) {
        return (RunnerInRace) util.MyUtil.copy(runnersInRaces.get(pos));
    }

    @Override
    public List<RunnerInRace> getRunnersInRaces() {
        List<RunnerInRace> runnersInRacesCopy = new ArrayList<>();
        for(RunnerInRace runnerInRace : runnersInRaces)
            runnersInRacesCopy.add((RunnerInRace) util.MyUtil.copy(runnerInRace));
        return runnersInRaces;
    }    
    
    @Override
    public List<RunnerInRace> getRunnersInRace(Race race) {
        ArrayList<RunnerInRace> runnersInRace = new ArrayList<>();
        if(races.contains(race))
            for(RunnerInRace runnerInRace : runnersInRaces)
                if(runnerInRace.getNumRace() == race.getNumRace())
                    runnersInRace.add((RunnerInRace) util.MyUtil.copy(runnerInRace));
        
        return runnersInRace;        
    }  
    
    
    @Override
    public List<Runner> getRunnersNotInList(List<RunnerInRace> runnersInList) {
        List<Runner> runnersNotInList = this.getNonRemovedRunners();
        for(RunnerInRace runnerInRace : runnersInList)
            runnersNotInList.remove(runnerInRace.getRunner());
        return runnersNotInList;
    }
    
    @Override
    public void setConfiguration(Configuration configuration){
        this.configuration = (Configuration) util.MyUtil.copy(configuration);
    }
    
    @Override
    public Configuration getConfiguration(){
        return (Configuration) util.MyUtil.copy(this.configuration);
    }
    

    @Override
    public void persist() {
        fileManager.persistRunners(this.runners);
        fileManager.persistRaces(this.races);
        fileManager.persistRunnersInRaces(this.runnersInRaces);
        fileManager.persistConfiguration(this.configuration);
    }
    
    private void automaticPersistance(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                persist();
            }
        };
        
        Timer timer = new Timer(true);
        if(configuration == null)
            timer.scheduleAtFixedRate(timerTask, DEFAULT_AUTOMATIC_PERSISTANCE_INTERVAL, DEFAULT_AUTOMATIC_PERSISTANCE_INTERVAL);
        else{
            if(configuration.getMinutesAutoPersist() == 0){
                timerTask = null;
                return;
            }
            long interval = configuration.getMinutesAutoPersist()*60*1000;
            timer.scheduleAtFixedRate(timerTask, interval, interval);
        }
            
        
    }
}
