package datamodel.adduct2mol;

import datamodel.database.IDResultMS1;

import java.util.ArrayList;

/**
 * Created by lmn on 10/10/16.
 */
public class MolMS1ID extends AdductRaw{

    protected int idNum;
    protected ArrayList<IDResultMS1> ms1IDs;

    public MolMS1ID(double mz, String adductType, ArrayList<IDResultMS1> tempms1IDs) {
        super(mz, adductType);
        this.ms1IDs = tempms1IDs;
        this.idNum = this.ms1IDs.size();
    }

    public ArrayList<IDResultMS1> getMS1IDs(){return this.ms1IDs;}

    public int getIdNum(){return this.idNum;}

    public void addMS1ID(IDResultMS1 tempms1ID){
        this.ms1IDs.add(tempms1ID);
    }

    public void addMS1IDs(ArrayList<IDResultMS1> tempms1IDs){
        this.ms1IDs.addAll(tempms1IDs);
    }

    public void setMS1IDs(ArrayList<IDResultMS1> tempms1IDs){
        this.ms1IDs = tempms1IDs;
        this.idNum = this.ms1IDs.size();
    }

    public void copyMolMS1ID(MolMS1ID molMS1ID){
        super.copyAdductRaw(molMS1ID);
        this.setMS1IDs(molMS1ID.getMS1IDs());
    }

    public String toString(){
        String tempStr = super.toString();
        StringBuilder tempStr1 = new StringBuilder(tempStr);
        for (IDResultMS1 idResultMS1:ms1IDs){
            tempStr1.append(idResultMS1.toString());
        }
        return tempStr1.toString();
    }

}
