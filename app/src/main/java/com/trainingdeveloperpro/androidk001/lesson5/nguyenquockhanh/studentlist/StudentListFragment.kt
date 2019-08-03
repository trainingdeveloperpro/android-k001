package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val GRID_LAYOUT_SPAN_COUNT = 2
private const val ACTIVITY_REQUEST_CODE = 0
private var studentList = ArrayList<Student>()

class StudentListFragment : Fragment() {
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView : View = inflater.inflate(R.layout.fragment_student_list, container, false)

        studentList.add(Student("Anh", "20", "53165435"))
        studentList.add(Student("Binh", "19", "6518546"))
        studentList.add(Student("Dung", "21", "65465165"))
        studentList.add(Student("Cuong", "18", "1564616515"))
        studentList.add(Student("Em", "30", "6486853"))
        studentList.add(Student("Ga", "17", "14628989"))
        studentList.add(Student("Hanh", "20", "14589866"))
        studentList.add(Student("Ich", "23", "4894656"))
        studentList.add(Student("Khoi", "25", "51465165"))

        viewManager = GridLayoutManager(activity, GRID_LAYOUT_SPAN_COUNT)
        viewAdapter = StudentAdapter(studentList)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.my_recycler_view)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        val buttonAdd = rootView.findViewById<Button>(R.id.button_add)
        buttonAdd.setOnClickListener {
            val intent = Intent(activity, AddNew::class.java)
            startActivityForResult(intent, ACTIVITY_REQUEST_CODE)
        }
        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null){
            val _name = data.getStringExtra(NAME).toString()
            val _age = data.getStringExtra(AGE).toString()
            val _telephone = data.getStringExtra(TELEPHONE).toString()

            val newStudentList = ArrayList<Student>()
            val newStudent = Student(_name, _age, _telephone)
            newStudentList.addAll(studentList)
            newStudentList.add(newStudent)
            viewAdapter.updateItems(newStudentList)
        }
    }
}