package com.example.finalapptft;

import com.example.finalapptft.Object.Activated;
import com.example.finalapptft.Object.ArratChampSinghlton;

import java.util.ArrayList;

public class ArrayActivatedSingleTon {

    private ArrayList<Activated> activateds;

    ArratChampSinghlton arratChampSinghlton = new ArratChampSinghlton();

    public ArrayActivatedSingleTon() {
    }

    private ArratChampSinghlton getArratChampSinghlton(){
        return arratChampSinghlton;
    }


    public ArrayList<Activated> getActivateds() {
        return activateds;
    }

    public void setActivateds(ArrayList<Activated> activateds) {
        this.activateds = activateds;
    }
}
