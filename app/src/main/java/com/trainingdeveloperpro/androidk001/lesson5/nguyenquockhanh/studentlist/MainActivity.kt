package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentList = ArrayList<Student>()
        studentList.add(Student("Anh", "20", "53165435"))
        studentList.add(Student("Binh", "19", "6518546"))
        studentList.add(Student("Cuong", "21", "65465165"))
        studentList.add(Student("Dung", "18", "1564616515"))
        studentList.add(Student("Em", "30", "6486853"))
        studentList.add(Student("Ga", "17", "14628989"))
        studentList.add(Student("Hanh", "20", "14589866"))
        studentList.add(Student("Ich", "23", "4894656"))
        studentList.add(Student("Khoi", "25", "51465165"))

        my_recycler_view.layoutManager = GridLayoutManager(this, 2)

        my_recycler_view.adapter = MyAdapter(studentList)
    }


}
