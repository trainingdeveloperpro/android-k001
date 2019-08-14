package com.example.lesson7giang;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {

    @Query("SELECT * from student_table ORDER BY studentName ASC")
    LiveData<List<Student>> getAllStudent();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student student);

    @Query("DELETE FROM student_table")
    void deleteAll();

}
