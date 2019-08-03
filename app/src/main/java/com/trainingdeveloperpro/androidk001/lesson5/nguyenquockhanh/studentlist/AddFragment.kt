package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

const val NAME : String = "name"
const val AGE : String = "age"
const val TELEPHONE : String = "phone"

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }
}
