package com.trainingdeveloperpro.androidk001.lesson7linh

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "student_table")
@Parcelize
data class Student(val name: String, var age: Int, @ColumnInfo(name = "phone_number") var phoneNumber: String) :
    Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun toString(): String {
        return "name: $name age $age phone $phoneNumber\n"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Student) {
            return false
        }
        return name == other.name && age == other.age && phoneNumber == other.phoneNumber
    }
}