package com.trainingdeveloperpro.androidk001.lesson7linh

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Student::class], version = 1)
abstract class StudentRoomDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): StudentRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentRoomDatabase::class.java,
                    "Student_database"
                ).addCallback(
                    StudentDatabaseCallback(
                        scope
                    )
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class StudentDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            INSTANCE?.let { studentRoomDatabase ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(studentRoomDatabase.studentDao())
                }
            }
        }

        private suspend fun populateDatabase(studentDao: StudentDao) {
            studentDao.deleteAllStudents()

            studentDao.insert(Student("Lam", 19, "123456789"))
            studentDao.insert(Student("Mai", 20, "342342343"))
            studentDao.insert(Student("Huy", 21, "345332223"))
            studentDao.insert(Student("Trung", 22, "3234233334"))
            studentDao.insert(Student("Hoang", 19, "3234233334"))
            studentDao.insert(Student("Khanh", 20, "3212312322"))
            studentDao.insert(Student("Nhi", 20, "4534543566"))
            studentDao.insert(Student("Phuong", 21, "35432453465"))
            studentDao.insert(Student("Phong", 20, "4353453466"))
            studentDao.insert(Student("Duy", 20, "4375632213"))
            studentDao.insert(Student("Duc", 20, "3233434343"))
            studentDao.insert(Student("Phuc", 20, "3123532345"))
            studentDao.insert(Student("Dung", 20, "3578642246"))
        }
    }
}