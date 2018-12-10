package logic.persistance;

import gui.Configuration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logic.obj.Race;
import logic.obj.Runner;
import logic.obj.RunnerInRace;

public class FileManagerImp implements IFileManager {
    private final static String FILENAME_RUNNERS = "runners.csv";
    private final static String FILENAME_RACES = "races.csv";
    private final static String FILENAME_RUNNERS_IN_RACES = "runners_in_races.csv";
    private final static String FILENAME_CONFIGURATION = "config.csv";
    
    private static FileManagerImp instance = null;
    private File fileRunners = null;
    private File fileRaces = null;
    private File fileRunnersInRaces = null;
    private File fileConfiguration = null;

    private FileManagerImp() {
        createFile(FILENAME_RUNNERS);
        createFile(FILENAME_RACES);
        createFile(FILENAME_RUNNERS_IN_RACES);
        createFile(FILENAME_CONFIGURATION);
    }

    public static FileManagerImp getInstance(){
        if(instance == null)
            instance = new FileManagerImp();
        return instance;
    }
    
    private void createFile(String fileName) {
        String path = "src" +File.separator +"res" +File.separator +fileName;
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        switch(fileName){
            case FILENAME_RUNNERS:
                this.fileRunners = file;
                break;
            case FILENAME_RACES:
                this.fileRaces = file;
                break;
            case FILENAME_RUNNERS_IN_RACES:
                this.fileRunnersInRaces = file;
                break;
            case FILENAME_CONFIGURATION:
                this.fileConfiguration = file;
                break;
        }
    }   
    
    @Override
    public List<Runner> readRunners() {
        ArrayList<Runner> runners = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileRunners))){
            String line = br.readLine();
            while(line != null){
                String[] runnerStrings = line.split(",");
                runners.add(new Runner(runnerStrings));
                line = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return runners;
    }

    @Override
    public void persistRunners(List<Runner> runners) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileRunners))){
            for(Runner runner : runners){
                bw.write(runner.toCSV());
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Race> readRaces() {
        ArrayList<Race> races = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileRaces))){
            String line = br.readLine();
            while(line != null){
                String[] raceStrings = line.split(",");
                races.add(new Race(raceStrings));
                line = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return races;
    }

    @Override
    public void persistRaces(List<Race> races) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileRaces))){
            for(Race race : races){
                bw.write(race.toCSV());
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<RunnerInRace> readRunnersInRaces() {
        ArrayList<RunnerInRace> runnersInRaces = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileRunnersInRaces))){
            String line = br.readLine();
            while(line != null){
                String[] runnerInRaceStrings = line.split(",");
                runnersInRaces.add(new RunnerInRace(runnerInRaceStrings));
                line = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return runnersInRaces;
    }

    @Override
    public void persistRunnersInRaces(List<RunnerInRace> runnersInRaces) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileRunnersInRaces))){
            for(RunnerInRace runnerInRace : runnersInRaces){
                bw.write(runnerInRace.toCSV());
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Configuration readConfiguration(){
        try(BufferedReader br = new BufferedReader(new FileReader(fileConfiguration))){
            String line = br.readLine();
            if(line != null){
                String[] configStrings = line.split(",");
                return new Configuration(configStrings);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void persistConfiguration(Configuration configuration){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileConfiguration))){
            bw.write(configuration.toCSV());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
