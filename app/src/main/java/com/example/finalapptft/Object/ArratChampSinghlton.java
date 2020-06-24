package com.example.finalapptft.Object;

import java.util.ArrayList;

public class ArratChampSinghlton {
    private ArrayList<Champ> arr;

    private  static  ArratChampSinghlton arratChampSinghlton = new ArratChampSinghlton() ;

    public ArratChampSinghlton() {
    }

    public ArrayList<Champ> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Champ> arr) {
        this.arr = arr;
    }

    public static ArratChampSinghlton getarratChampSinghlton(){
        return  arratChampSinghlton;
    }
}
