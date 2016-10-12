package datamodel.adduct2mol;

/**
 * Created by lmn on 10/10/16.
 */

import datamodel.adduct.AdductType;

import static datamodel.Constants.ADDUCTMAP;
import static datamodel.Constants.ELECTRON_MASS;

public class AdductRaw {
    protected double mz;
    protected String adductType;
    protected double neuralMass;

    public AdductRaw(double mz, String adductType) {
        this.mz = mz;
        this.adductType = adductType;
        this.neuralMass = mz2neu(mz,adductType);
    }

    public AdductRaw(String adductType, double neuralMass){
        this.adductType = adductType;
        this.neuralMass = neuralMass;
        this.mz = neu2mz(neuralMass,adductType);
    }

    public double mz2neu(double mz, String adductType){
        AdductType adduct = ADDUCTMAP.get(adductType);
        if (adduct.getCharge() == 0) return mz;
        double neuralMass = (mz * Math.abs(adduct.getCharge()) + ELECTRON_MASS * adduct.getCharge() - adduct.getMass())/adduct.getMolNum();
        return neuralMass;
    }

    public double neu2mz(double neuralMass, String adductType){
        AdductType adduct = ADDUCTMAP.get(adductType);
        if (adduct.getCharge() == 0) return neuralMass;
        double mz = (neuralMass * adduct.getMolNum() + adduct.getMass() - ELECTRON_MASS * adduct.getCharge()) / Math.abs(adduct.getCharge());
        return mz;
    }

    public double getMZ() {return mz;}

    public double getNeuralMass() {return neuralMass;}

    public String getAdductType() {return adductType;}

    public void copyAdductRaw(AdductRaw adductRaw){
        this.mz = adductRaw.getMZ();
        this.adductType = adductRaw.getAdductType();
        this.neuralMass = adductRaw.getNeuralMass();
    }

    @Override
    public String toString() {
        return String.format("mz_%s neural_mass_%s adduct_type_%s", new Object[]{mz, neuralMass, adductType});
    }
}
