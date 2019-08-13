package com.trainingdeveloperpro.androidk001.lesson6khang

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

const val NAME : String = "name"
const val AGE : String = "age"
const val PHONENUMBER : String = "phone"

class StudentAddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_student_add, container, false)
    }

}