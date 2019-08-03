package com.trainingdeveloperpro.androidk001.lesson5linh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val GRID_LAYOUT_SPAN_COUNT = 2 //TODO: Remove hardcoded value

class StudentListFragment : Fragment() {
    var tracker: SelectionTracker<Long>? = null

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: StudentsListAdapter
    private lateinit var students: ArrayList<Student>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_student_list, container, false)

        students = getStudents()
        viewManager = GridLayoutManager(activity, GRID_LAYOUT_SPAN_COUNT)
        viewAdapter = StudentsListAdapter(students)
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view_students)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        tracker = SelectionTracker.Builder<Long>(
            "myselection",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            StudentCardItemLookup(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(SelectionPredicates.createSelectAnything()).build()

        viewAdapter.tracker = tracker

        val button: Button = rootView.findViewById(R.id.button_student_list_delete)
        button.setOnClickListener {
            deleteSelectedStudentCards()
        }

        return rootView
    }

    private fun getStudents(): ArrayList<Student> {
        val students = ArrayList<Student>()

        students.add(Student("Lam", 19, "123456789"))
        students.add(Student("Mai", 20, "342342343"))
        students.add(Student("Huy", 21, "345332223"))
        students.add(Student("Trung", 22, "3234233334"))
        students.add(Student("Hoang", 19, "3234233334"))
        students.add(Student("Khanh", 20, "3212312322"))
        students.add(Student("Nhi", 20, "4534543566"))
        students.add(Student("Phuong", 21, "35432453465"))
        students.add(Student("Phong", 20, "4353453466"))
        students.add(Student("Duy", 20, "4375632213"))
        students.add(Student("Duc", 20, "3233434343"))
        students.add(Student("Phuc", 20, "3123532345"))
        students.add(Student("Dung", 20, "3578642246"))

        return students
    }

    private fun deleteSelectedStudentCards() {
        val indexToDelete = ArrayList<Int>()

        tracker?.selection!!.forEach {
            indexToDelete.add(it.toInt())
        }
        indexToDelete.sortDescending()
        for (index in indexToDelete) {
            viewAdapter.removeItem(index)
        }
        tracker?.clearSelection()
    }
}
