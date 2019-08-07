package com.trainingdeveloperpro.androidk001.lesson6dat

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Student(val name: String, var age: Int, var phoneNumber: String) : Parcelable {
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