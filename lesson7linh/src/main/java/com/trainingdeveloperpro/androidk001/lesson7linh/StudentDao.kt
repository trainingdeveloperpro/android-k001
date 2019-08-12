package com.trainingdeveloperpro.androidk001.lesson7linh

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM student_table ORDER BY name ASC")
    fun getAllStudents(): LiveData<List<Student>>

    @Insert
    suspend fun insert(student: Student)

    @Delete
    fun remove(student: Student)

    @Query("DELETE FROM student_table")
    fun deleteAllStudents()
}