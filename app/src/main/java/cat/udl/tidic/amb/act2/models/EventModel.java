package cat.udl.tidic.amb.act2.models;

import android.util.Log;

import androidx.annotation.NonNull;

public class EventModel {
    private String nom;
    private String desc;
    private int year;
    private int month;
    private int day;

    public EventModel() {
        this.nom = "";
        this.desc = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;

    }

    public EventModel(String nom, String desc, int year, int month, int day) {
        this.nom = nom;
        this.desc = desc;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @NonNull
    @Override
    public String toString(){
        if (this.nom.contentEquals("")){
            return "";
        }else{
            return "El event: "  + this.nom + " que consiste en: " + this.desc + " dara lugar en la fecha del: " + this.day + "/" + this.month + "/" + this.year;
        }

    }
}
