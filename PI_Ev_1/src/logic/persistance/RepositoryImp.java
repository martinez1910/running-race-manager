package logic.persistance;

import java.util.ArrayList;
import java.util.List;
import logic.obj.Runner;

public class RepositoryImp implements IRepository{
    private static RepositoryImp instance = null;
    //private static FileManager fileManager = new FileManagerImp();
    private ArrayList<Runner> runners = new ArrayList<Runner>();
    
    private RepositoryImp(){}
    
    public RepositoryImp getInstance(){
        if(instance == null)
            instance = new RepositoryImp();
        return instance;
    }

    @Override
    public boolean addRunner(Runner runner) {
        if(!runners.contains(runner))
          return runners.add(runner);
        return false;          
    }

    @Override
    public boolean removeRunner(Runner runner) {
        return runners.remove(runner);
    }

    @Override
    public boolean updateRunner(Runner runner, Runner updatedRunner) {
        for(Runner rn : runners)
            if(rn.equals(runner)){
                rn = updatedRunner;
                return true;
            }
        return false;
    }

    @Override
    public Runner getRunner(int pos) {
        return runners.get(pos);
    }

    @Override
    public List<Runner> getRunners() {
        return runners;
    }

    @Override
    public List<Runner> getRunnersByDateOfBirthAsc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Runner> getRunnersByDateOfBirthDesc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
