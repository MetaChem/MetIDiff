package main;

/**
 * Created by lmn on 10/10/16.
 */

import datamodel.Constants;
import datamodel.Adduct;

public class MetIDiffCore {
    public static void main(String[] args){
        System.out.println(Constants.ELEMENTMASS.get("[13C]"));
        System.out.println(Constants.HYDROGEN_MASS);
        System.out.println(Constants.ELECTRON_MASS);
        System.out.println(Constants.ADDUCTMAP);
        System.out.println(new Adduct("[2M-H]",853.33089));
    }
}
