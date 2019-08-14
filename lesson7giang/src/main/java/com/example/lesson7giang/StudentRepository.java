package com.example.lesson7giang;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepository {
    private StudentDAO mStudentDao;
    private LiveData<List<Student>> mAllStudent;

    StudentRepository(Application application){
        StudentRoomDatabase db = StudentRoomDatabase.getDatabase(application);
        mStudentDao = db.studentDAO();
        mAllStudent = mStudentDao.getAllStudent();
    }

    LiveData<List<Student>> getAllStudent(){
        return  mAllStudent;
    }

    public void insert(Student student){
        new insertAsynTask(mStudentDao).execute(student);
    }

    private static class insertAsynTask extends AsyncTask<Student, Void, Void>{

        private StudentDAO mAsyncTaskDao;

        insertAsynTask(StudentDAO dao){
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final Student... students) {
            mAsyncTaskDao.insert(students[0]);
            return null;
        }
    }

}
