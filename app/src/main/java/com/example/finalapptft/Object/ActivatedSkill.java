package com.example.finalapptft.Object;

public class ActivatedSkill {

    private String Cateloty1;
    private String Cateloty2;
    private String Cateloty3;

    public ActivatedSkill() {
    }

    public ActivatedSkill(String cateloty) {
        Cateloty1 = cateloty;

    }

    public ActivatedSkill(String cateloty, String cateloty2) {
        Cateloty1 = cateloty;
        Cateloty2 = cateloty2;

    }

    public ActivatedSkill(String cateloty, String cateloty2, String cateloty3) {
        Cateloty1 = cateloty;
        Cateloty2 = cateloty2;
        Cateloty3 = cateloty3;

    }

    public String getCateloty1() {
        return Cateloty1;
    }

    public void setCateloty1(String cateloty) {
        Cateloty1= cateloty;
    }

    public String getCateloty2() {
        return Cateloty2;
    }

    public void setCateloty2(String cateloty2) {
        Cateloty2 = cateloty2;
    }

    public String getCateloty3() {
        return Cateloty3;
    }

    public void setCateloty3(String cateloty3) {
        Cateloty3 = cateloty3;
    }

}
