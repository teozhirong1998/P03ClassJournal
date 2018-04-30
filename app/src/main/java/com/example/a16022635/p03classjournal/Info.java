package com.example.a16022635.p03classjournal;

import java.io.Serializable;

public class Info implements Serializable{
    private String grade;


    public Info(String grade) {
        this.grade = grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}
