package main;

/**
 * Created by lmn on 10/10/16.
 */

import datamodel.Constants;
import datamodel.Adduct;
import settings.GlobalSetting;

import java.io.IOException;
import java.util.Date;


public class MetIDiffCore {
    public static void main(String[] args) throws IOException {
        System.out.println(Constants.ELEMENTMASS.get("[13C]"));
        System.out.println(Constants.HYDROGEN_MASS);
        System.out.println(Constants.ELECTRON_MASS);
        System.out.println(Constants.ADDUCTMAP);
        System.out.println(new Adduct("[2M-H]",853.33089));
        GlobalSetting globalSetting = new GlobalSetting("FILE-1");
        globalSetting.setProperty("Hello java!", 100);
        System.out.println(globalSetting);
        globalSetting.readSettings("src/main/resources/inputSettings");

        System.out.println((new Date()).toString().hashCode());
        System.out.println(globalSetting);
        globalSetting.writeSettings("src/main/resources/outputSetings");
    }
}
