package main;

/**
 * Created by lmn on 10/10/16.
 */

import datamodel.Constants;
import datamodel.adduct2mol.AdductRaw;
import datamodel.adduct2mol.MolMS1ID;
import datamodel.database.IDEntry;
import datamodel.database.IDResultMS1;
import datamodel.database.IDResultMS2;
import settings.GlobalSetting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class MetIDiffCore {
    public static void main(String[] args) throws IOException {
        System.out.println(Constants.ELEMENTMASS.get("[13C]"));
        System.out.println(Constants.HYDROGEN_MASS);
        System.out.println(Constants.ELECTRON_MASS);
        System.out.println(Constants.ADDUCTMAP);
        System.out.println(new AdductRaw("[2M-H]",853.33089));
        GlobalSetting globalSetting = new GlobalSetting("FILE-1");
        globalSetting.setProperty("Hello java!", 100);
        System.out.println(globalSetting);
        globalSetting.readSettings("src/main/resources/inputSettings");

        System.out.println((new Date()).toString().hashCode());
        System.out.println(globalSetting);
        globalSetting.writeSettings("src/main/resources/outputSetings");

        IDEntry idEntrya = new IDEntry("HMDB333","HMDB-walawa");
        idEntrya.setIDItem(IDEntry.Item.molName, "Harry Potter");
        System.out.println(idEntrya);
        IDResultMS1 idResultMS1a = new IDResultMS1(idEntrya.getCode(),idEntrya.getDatabaseName());
        idResultMS1a.setScoreMS1(89.908);
        System.out.println(idResultMS1a);
        idResultMS1a.setIDResultMS1(idEntrya);
        System.out.println(idResultMS1a);
        IDResultMS2 idResultMS2a = new IDResultMS2(idResultMS1a.getCode(),idResultMS1a.getDatabaseName());
        idResultMS2a.setIDResultMS2(idResultMS1a);
        idResultMS2a.setScoreMS2(35.00);
        System.out.println(idResultMS2a);

        System.out.println("**************");
        IDEntry idEntryb = new IDEntry("HMDB444","HMDB");
        idEntryb.setIDItem(IDEntry.Item.molName,"Hermonine");
        IDResultMS1 idResultMS1b = new IDResultMS1(idEntryb.getCode(),idEntryb.getDatabaseName());
        idResultMS1b.setIDResultMS1(idEntryb);
        idResultMS1b.setScoreMS1(4657);
        ArrayList<IDResultMS1> ms1ids = new ArrayList<>();
        ms1ids.add(idResultMS1a);
        ms1ids.add(idResultMS1b);
        MolMS1ID molMS1ID = new MolMS1ID(345.56, "[M+H]",ms1ids);
        System.out.println(molMS1ID);

    }
}
