package com.example.a16022635.p03classjournal;

import java.io.Serializable;

public class Info implements Serializable{
    private String grade;
    private int week;

    public Info(int week,String grade) {
        this.grade = grade;
        this.week = week;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
}
