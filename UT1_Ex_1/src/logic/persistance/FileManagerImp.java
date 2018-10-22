package logic.persistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManagerImp implements IFileManager{
    private static FileManagerImp instance = null;
    private File file;
    
    private FileManagerImp(String fileName){
        loadFile(fileName);
    }
    
    public static FileManagerImp getInstance(String fileName){
        if(instance == null)
            instance = new FileManagerImp(fileName);
        return instance;
    }
    
    private void loadFile(String fileName) {
        String path = "src" +File.separator +"res" +File.separator +fileName;
        this.file = new File(path);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readLines() {
        ArrayList<String> lines = new ArrayList<String>();
        try(BufferedReader bf = new BufferedReader(new FileReader(file));){
            String line = "";
            while( line != null){
                line = bf.readLine();
                lines.add(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return lines;
    }
    @Override
    public void writeLines(List<String> lines) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
