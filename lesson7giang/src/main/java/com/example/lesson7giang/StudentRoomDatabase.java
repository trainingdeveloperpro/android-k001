package com.example.lesson7giang;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentRoomDatabase extends RoomDatabase {
    public abstract StudentDAO studentDAO();

    private static volatile StudentRoomDatabase INSTANCE;

    static StudentRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (StudentRoomDatabase.class){
                if (INSTANCE == null){
                    // create database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StudentRoomDatabase.class, "student_database").addCallback(sRoomDatabaseCallBack).build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallBack =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    public static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final StudentDAO mDao;

        PopulateDbAsync(StudentRoomDatabase db) {
            mDao = db.studentDAO();
        }

        @Override
        protected Void doInBackground(final Void... voids) {
            mDao.deleteAll();
            mDao.insert(new Student("Giang", "03214212381", 20));
            mDao.insert(new Student("Nam", "03214212322", 21));
            mDao.insert(new Student("Ha", "0321421322", 11));
            mDao.insert(new Student("Kha", "03214212332", 32));
            mDao.insert(new Student("Hao", "03214212441", 12));
            mDao.insert(new Student("Hoc", "03214212332", 21));
            for (int i = 1; i <= 20; i++){
                mDao.insert(new Student("Name " + i, "0321421233" + i, 13 + i));
            }
            return null;
        }
    }
}
