package com.k001.lesson7khanh

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Student::class], version = 1)
abstract class StudentRoomDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object{
        @Volatile
        private var INSTANCE: StudentRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): StudentRoomDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentRoomDatabase::class.java,
                    "Student_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(StudentDatabaseCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }
    private class StudentDatabaseCallback(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO){
                    populateDatabase(database.studentDao())
                }
            }
        }

        suspend fun populateDatabase(studentDao: StudentDao){
            studentDao.deleteAll()
            studentDao.insert(Student("Anh", "20", "53165435"))
            studentDao.insert(Student("Binh", "19", "6518546"))
            studentDao.insert(Student("Dung", "21", "65465165"))
            studentDao.insert(Student("Cuong", "18", "1564616515"))
            studentDao.insert(Student("Em", "30", "6486853"))
            studentDao.insert(Student("Ga", "17", "14628989"))
            studentDao.insert(Student("Hanh", "20", "14589866"))
            studentDao.insert(Student("Ich", "23", "4894656"))
            studentDao.insert(Student("Khoi", "25", "51465165"))
        }
    }
}