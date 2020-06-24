package com.example.finalapptft.Object;

public class Activated {
    private String content;
    private int amount;
    private String active;
    private String colorString;
    private int oder;

    public Activated() {
    }

    public Activated(String content, int amount, String active, String colorString, int oder) {
        this.content = content;
        this.amount = amount;
        this.active = active;
        this.colorString = colorString;
        this.oder = oder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getColorString() {
        return colorString;
    }

    public void setColorString(String colorString) {
        this.colorString = colorString;
    }

    public int getOder() {
        return oder;
    }

    public void setOder(int oder) {
        this.oder = oder;
    }

    public Activated( int amount,String content) {
        this.amount = amount;
        this.content = content;
    }
}
