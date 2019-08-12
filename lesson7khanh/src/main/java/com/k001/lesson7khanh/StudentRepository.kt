package com.k001.lesson7khanh

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class StudentRepository(private val studentDao: StudentDao) {
    val allStudent: LiveData<List<Student>> = studentDao.getAllStudent()
    @WorkerThread
    suspend fun insert(student: Student){
        studentDao.insert(student)
    }

    @WorkerThread
    fun delete(student: Student){
        studentDao.deleteStudent(student)
    }
}