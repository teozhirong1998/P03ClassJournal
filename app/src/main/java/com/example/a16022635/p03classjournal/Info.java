package com.example.a16022635.p03classjournal;

import java.io.Serializable;

public class Info implements Serializable{

    private int week;
    private String grade;


    public Info(int week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getWeek() {

        return week;
    }

    public String getGrade() {
        return grade;
    }
}
