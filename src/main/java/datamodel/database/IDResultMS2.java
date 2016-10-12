package datamodel.database;

/**
 * Created by lmn on 10/12/16.
 */
public class IDResultMS2 extends IDResultMS1{
    protected double scoreMS2;

    public IDResultMS2(String code, String databaseName){
        super(code, databaseName);
    }

    public double getScoreMS2(){return scoreMS2;}
    public void setScoreMS2(double scoreMS2){this.scoreMS2 = scoreMS2;}

    public void setIDResultMS2(IDResultMS1 idResultMS1){
        this.copyIDEntry(idResultMS1);
        this.scoreMS1 = idResultMS1.scoreMS1;
    }

    public String toString(){
        String tempStr = super.toString();
        StringBuilder tempStr1 = new StringBuilder(tempStr);
        tempStr1.append("MS2_score-").append(scoreMS2).append("\n");
        return tempStr1.toString();
    }
}
