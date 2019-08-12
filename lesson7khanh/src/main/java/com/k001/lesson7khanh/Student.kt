package com.k001.lesson7khanh

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(@PrimaryKey
                   @ColumnInfo(name = "student_name") val name: String,
                   @ColumnInfo(name = "student_age") val age: String,
                   @ColumnInfo(name = "student_telephone") val telephone: String)