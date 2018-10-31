package logic.persistance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import logic.obj.Runner;

public class RepositoryImp implements IRepository{
    private static RepositoryImp instance = null;
    //private static FileManager fileManager = new FileManagerImp();
    private ArrayList<Runner> runners = new ArrayList<Runner>();
    
    private RepositoryImp(){}
    
    public static RepositoryImp getInstance(){
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
    public boolean removeRunner(int pos) {
        return removeRunner(this.runners.get(pos));
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
        ArrayList<Runner> tmp = new ArrayList<Runner>();
        for(Runner runner : this.runners)
            tmp.add(runner);
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
        ArrayList<Runner> tmp = new ArrayList<Runner>();
        for(Runner runner : this.runners)
            tmp.add(runner);
        tmp.sort(new Comparator<Runner>(){
            @Override
            public int compare(Runner r1, Runner r2){
                return r2.getDateOfBirth().compareTo(r1.getDateOfBirth());
            }
        });
        return tmp;
    }

    @Override
    public void persist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
