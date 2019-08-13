package com.trainingdeveloperpro.androidk001.lesson6khang

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

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class StudentListFragment : Fragment() {
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: StudentListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_student_list, container, false)

        studentList.add(Student("Dat", "20", "0194758291"))
        studentList.add(Student("Van", "19", "0471972571"))
        studentList.add(Student("Dung", "21", "0184651928"))
        studentList.add(Student("Duy", "19", "0927164483"))
        studentList.add(Student("Lam", "22", "0197561824"))
        studentList.add(Student("Hau", "19", "0852958614"))
        studentList.add(Student("Hao", "20", "0947598251"))
        studentList.add(Student("Tai", "21", "0285527589"))
        studentList.add(Student("Hung", "22", "01257652650"))

        viewManager = GridLayoutManager(activity, GRID_LAYOUT_SPAN_COUNT)
        viewAdapter = StudentListAdapter(studentList)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.text_view_student_phone)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        val buttonAdd = rootView.findViewById<Button>(R.id.button_student_list_add)
        buttonAdd.setOnClickListener {
            val intent = Intent(activity, StudentAddNew::class.java)
            startActivityForResult(intent, ACTIVITY_REQUEST_CODE)
        }
        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val _name = data.getStringExtra(NAME).toString()
            val _age = data.getStringExtra(AGE).toString()
            val _phonenumber = data.getStringExtra(PHONENUMBER).toString()

            val newStudentList = ArrayList<Student>()
            val newStudent = Student(_name, _age, _phonenumber)
            newStudentList.addAll(studentList)
            newStudentList.add(newStudent)
            viewAdapter.updateItems(newStudentList)
        }
    }
}

