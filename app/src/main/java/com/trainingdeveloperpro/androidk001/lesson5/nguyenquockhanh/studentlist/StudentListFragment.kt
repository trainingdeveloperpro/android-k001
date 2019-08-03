package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val GRID_LAYOUT_SPAN_COUNT = 2

class StudentListFragment : Fragment() {
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView : View = inflater.inflate(R.layout.fragment_student_list, container, false)

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

        viewManager = GridLayoutManager(activity, GRID_LAYOUT_SPAN_COUNT)
        viewAdapter = StudentAdapter(studentList)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.my_recycler_view)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return rootView
    }
}
