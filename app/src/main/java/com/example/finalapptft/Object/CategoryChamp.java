package com.example.finalapptft.Object;

import java.util.ArrayList;

public class CategoryChamp {
    private String sectionName;
    private ArrayList<Champ> champs;

    public CategoryChamp(String sectionName, ArrayList<Champ> champs) {
        this.sectionName = sectionName;
        this.champs = champs;
    }

    public CategoryChamp() {
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public ArrayList<Champ> getChamps() {
        return champs;
    }

    public void setChamps(ArrayList<Champ> champs) {
        this.champs = champs;
    }
}
