package datamodel.database;

/**
 * Created by lmn on 10/12/16.
 */
public class IDResultMS1 extends IDEntry{
    protected double scoreMS1;

    public IDResultMS1(String code, String databaseName){
        super(code, databaseName);
    }

    public double getScoreMS1(){return scoreMS1;}

    public void setScoreMS1(double scoreMS1){this.scoreMS1 = scoreMS1;}

    public void setIDResultMS1(IDEntry idEntry){
        this.copyIDEntry(idEntry);
    }

    public String toString(){
        String tempStr = super.toString();
        StringBuilder tempStr1 = new StringBuilder(tempStr);
        tempStr1.append("MS1_score-").append(scoreMS1).append("\n");
        return tempStr1.toString();
    }
}