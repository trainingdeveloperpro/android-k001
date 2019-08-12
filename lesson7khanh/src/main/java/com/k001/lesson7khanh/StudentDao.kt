package com.k001.lesson7khanh

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("SELECT * from student_table ORDER BY student_name ASC")
    fun getAllStudent() : LiveData<List<Student>>

    @Insert
    suspend fun insert(student: Student)

    @Delete
    fun deleteStudent(vararg student: Student)

    @Query("DELETE FROM student_table")
    fun deleteAll()
}