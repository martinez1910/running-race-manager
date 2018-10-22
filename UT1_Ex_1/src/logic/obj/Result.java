package logic.obj;


public class Result {
    private int homeResult, visitingResult;

    public Result(int homeResult, int visitingResult) {
        this.homeResult = homeResult;
        this.visitingResult = visitingResult;
    }

    public int getHomeResult() {
        return homeResult;
    }

    public void setHomeResult(int homeResult) {
        this.homeResult = homeResult;
    }

    public int getVisitingResult() {
        return visitingResult;
    }

    public void setVisitingResult(int visitingResult) {
        this.visitingResult = visitingResult;
    }

    @Override
    public String toString() {
        return homeResult + "-" + visitingResult;
    }    
}
