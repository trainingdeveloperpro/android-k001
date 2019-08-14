package com.example.lesson7giang;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "studentName")
    private String mName;

    @NonNull
    @ColumnInfo(name = "studentPhone")
    private String mPhone;

    @ColumnInfo(name = "studentAge")
    private int mAge;

    public Student(@NonNull String mName, @NonNull String mPhone, int mAge) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.mAge = mAge;
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public String getPhone() {
        return this.mPhone;
    }

    public int getAge() {
        return this.mAge;
    }
}
