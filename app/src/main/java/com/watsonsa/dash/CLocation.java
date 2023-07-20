package com.watsonsa.dash;

import android.location.Location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CLocation extends Location {
    private boolean bUseMaticUnits = false;
    public CLocation(Location location){
        this(location, true);
    }
    public CLocation(Location location, boolean bUseMaticUnits){
        super(location);
        this.bUseMaticUnits = bUseMaticUnits;
    }
    public boolean getUseMaticUnits(){
        return this.bUseMaticUnits;
    }
    public void setUseMaticUnits(boolean bUseMaticUnits){
        this.bUseMaticUnits = bUseMaticUnits;
    }

    @Override
    public float distanceTo(@NonNull Location dest) {
       float nDistance = super.distanceTo(dest);
       if (!this.getUseMaticUnits()){
           //convertimos metros a patas
           nDistance = nDistance * 3.2808398501312f;
       }
       return nDistance;
    }

    @Override
    public double getAltitude() {
        double nAltitude = super.getAltitude();
        if (!this.getUseMaticUnits()){
            //convertimos metros a patas
            nAltitude = nAltitude * 3.2808398501312d;
        }
        return nAltitude;
    }

    @Override
    public float getSpeed() {
        float nSpeed = super.getSpeed();
        if (!this.getUseMaticUnits()){
            //convertimos metros/segunfo a millas/hora
            nSpeed = super.getSpeed() * 2.23693629f;
        }
        return nSpeed;
    }

    public CLocation(@Nullable String provider) {
        super(provider);
    }

    @Override
    public float getAccuracy() {
        float nAccurancy = super.getAccuracy();
        if (!this.getUseMaticUnits()){
            //convertimos metros a patas
            nAccurancy = nAccurancy * 3.2808398501312f;
        }
        return nAccurancy;
    }
}
