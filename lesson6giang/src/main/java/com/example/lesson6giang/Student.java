package com.example.lesson6giang;

public class Student implements Comparable{
    private String mName;
    private String mPhone;
    private int mAge;

    public Student(String mName, String mPhone, int mAge) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.mAge = mAge;
    }

    public Student(String stringExtra) {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }



    @Override
    public int compareTo(Object student) {
        Student compare = (Student) student;

        if (compare.getmName() == this.getmName() && compare.getmAge() == (this.getmAge()) && compare.getmPhone().equals(this.getmPhone())) {
            return 0;
        }
        return (this.getmName().compareTo(((Student) student).getmName()));
    }
}
