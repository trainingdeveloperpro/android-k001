package com.trainingdeveloperpro.androidk001.lesson7linh

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: StudentRepository
    val allStudents: LiveData<List<Student>>

    init {
        val studentsDao = StudentRoomDatabase.getDatabase(
            application,
            viewModelScope
        ).studentDao()
        repository = StudentRepository(studentsDao)

        allStudents = repository.allStudents
    }

    fun insert(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(student)
    }

    fun remove(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.remove(student)
    }
}