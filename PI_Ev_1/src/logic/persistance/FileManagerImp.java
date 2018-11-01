package logic.persistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logic.obj.Runner;

public class FileManagerImp implements IFileManager {
    private final static String FILENAME_RUNNERS = "runners.csv";
    
    private static FileManagerImp instance = null;
    private File file = null;

    private FileManagerImp() {
        createFile(FILENAME_RUNNERS);
    }

    public static FileManagerImp getInstance(){
        if(instance == null)
            instance = new FileManagerImp();
        return instance;
    }
    
    @Override
    public List<Runner> readRunners() {
        ArrayList<Runner> runners = new ArrayList<Runner>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
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
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for(Runner runner : runners){
                bw.write(runner.toCSV());
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void createFile(String fileName) {
        String path = "src" +File.separator +"res" +File.separator +fileName;
        this.file = new File(path);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
