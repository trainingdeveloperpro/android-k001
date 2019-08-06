package com.trainingdeveloperpro.androidk001.lesson5giang;

public class Student {
    private String mName;
    private String mPhone;
    private int birthYear;

    public Student(String mName, String mPhone, int birthYear) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.birthYear = birthYear;
    }

    public Student() {
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getmName() {
        return mName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
