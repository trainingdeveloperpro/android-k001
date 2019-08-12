package com.k001.lesson7khanh

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {

    private val repository: StudentRepository
    val allStudent: LiveData<List<Student>>

    init{
        val studentDao = StudentRoomDatabase.getDatabase(application, viewModelScope).studentDao()
        repository = StudentRepository(studentDao)
        allStudent = repository.allStudent
    }

    fun insert(student: Student) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(student)
    }

    fun delete(student: Student) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(student)
    }
}