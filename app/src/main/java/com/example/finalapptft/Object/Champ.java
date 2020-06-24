package com.example.finalapptft.Object;

import com.example.finalapptft.Constants.Constant;

public class Champ {
    private String nameChamp;
    //private String linkImg;
    private String origin;
    private String classes;
    private int gold;
    private int id;

    public Champ(String nameChamp) {
        this.nameChamp = nameChamp;
    }

    private String skillName;
    private String skillContents;
    private ActivatedSkill activatedSkill;
    public Champ() {
    }

    public Champ(String nameChamp, String origin, String classes, int gold, int id,String skillName, String skill, ActivatedSkill activatedSkill) {
        this.nameChamp = nameChamp;
        this.origin = origin;
        this.classes = classes;
        this.gold = gold;
        this.id = id;
        this.skillName = skillName;
        this.skillContents = skill;
        this.activatedSkill = activatedSkill;
    }

    public String getNameChamp() {
        return nameChamp;
    }

    public void setNameChamp(String nameChamp) {
        this.nameChamp = nameChamp;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getClasss() {
        return classes;
    }

    public void setClasss(String classs) {
        this.classes = classs;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String linkSkill) {
        this.skillName = linkSkill;
    }

    public String getSkillContents() {
        return skillContents;
    }

    public void setSkillContents(String skill) {
        this.skillContents = skill;
    }

    public ActivatedSkill getActivatedSkill() {
        return activatedSkill;
    }

    public void setActivatedSkill(ActivatedSkill activatedSkill) {
        this.activatedSkill = activatedSkill;
    }

    public String getLinkChamp(){

        String img =  Constant.URL_CHAMP+getNameChamp().replaceAll("\\s","")+".png";

        return img;
    }
    public String getLinkCoverChamp(){

        String img =  Constant.URL_COVERCHAMP+getNameChamp().replaceAll("\\s","")+".jpg";

        return img;
    }
    public String getLinkSlills(){

        String name = (getNameChamp().toLowerCase()).replace(" ","-");
        String skill = (getSkillName().toLowerCase()).replace("'","");
        String skillKT = (skill.replace(" ","-")).replace("!","");
        String img = Constant.URL_SKILLCHAMP+name+"-"+skillKT+".png";
        return img;
    }
    public String color(){
     String color = "";
        if(getGold() == 1){
            color=Constant.COLOR1;
        }
        if(getGold() == 2){
            color=Constant.COLOR2;
        }
        if(getGold() == 3){
            color=Constant.COLOR3;
        }
        if(getGold() == 4){
            color=Constant.COLOR4;
        }
        if(getGold() == 5){
            color=Constant.COLOR5;
        }if(getNameChamp().equals("")){
            color="#000000";
        }

        return color;
    }
}
