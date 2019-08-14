package com.example.lesson7giang;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository mRepository;
    LiveData<List<Student>> mAllStudent;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new StudentRepository(application);
        mAllStudent = mRepository.getAllStudent();
    }


    LiveData<List<Student>> getAllStudent(){
        return  mAllStudent;
    }

    public void insert(Student student){
        mRepository.insert(student);
    }

    public int size(){
        return mAllStudent.getValue().size();
    }

    public String getName(int position){
        return mAllStudent.getValue().get(position).getName();
    }

    public void deleteAll(){
        mAllStudent.removeObserver((Observer<? super List<Student>>) mAllStudent);
    }
}
