package com.trainingdeveloperpro.androidk001.lesson7linh

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val GRID_LAYOUT_SPAN_COUNT = 2
private const val CREATE_STUDENT_REQUEST = 1

const val EXTRA_STUDENT_NAME = "com.trainingdeveloperpro.androidk001.lesson7linh.STUDENT_NAME"
const val EXTRA_STUDENT_AGE = "com.trainingdeveloperpro.androidk001.lesson7linh.STUDENT_AGE"
const val EXTRA_STUDENT_PHONE = "com.trainingdeveloperpro.androidk001.lesson7linh.STUDENT_PHONE"

const val BUNDLE_STATE_STUDENTS = "STUDENTS"

class StudentListFragment : Fragment() {
    private val TAG = StudentListFragment::class.java.simpleName
    private var tracker: SelectionTracker<Long>? = null

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: StudentsListAdapter

    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_student_list, container, false)

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        studentViewModel.allStudents.observe(this, Observer { students ->
            students?.let { viewAdapter.updateList(it) }
        })
        createRecyclerView(rootView, savedInstanceState)
        setButtonsOnClickListeners(rootView)

        return rootView
    }

    private fun setButtonsOnClickListeners(rootView: View) {
        rootView.findViewById<Button>(R.id.button_student_list_delete)
            .setOnClickListener { deleteSelectedStudentCards() }

        rootView.findViewById<Button>(R.id.button_student_list_add)
            .setOnClickListener { addStudentCard() }
    }

    private fun createRecyclerView(rootView: View, savedState: Bundle?): RecyclerView {
        LogTool.logD(
            TAG,
            "createRecyclerView called, dataset recreated"
        )
        viewManager = GridLayoutManager(
            activity,
            GRID_LAYOUT_SPAN_COUNT
        )
        viewAdapter = StudentsListAdapter()
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view_students)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        createRecyclerViewTracker(recyclerView)

        return recyclerView
    }

    private fun createRecyclerViewTracker(recyclerView: RecyclerView) {
        tracker = SelectionTracker.Builder<Long>(
            "myselection",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            StudentCardItemLookup(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(SelectionPredicates.createSelectAnything()).build()

        viewAdapter.tracker = tracker
    }

    private fun deleteSelectedStudentCards() {
        val indexToDelete = ArrayList<Int>()

        tracker?.selection!!.forEach {
            indexToDelete.add(it.toInt())
        }
        indexToDelete.sortDescending()
        for (index in indexToDelete) {
            val deletedStudent = viewAdapter.removeItem(index)
            studentViewModel.remove(deletedStudent)
        }
        tracker?.clearSelection()
    }

    private fun addStudentCard() {
        val intent = Intent(activity, CreateStudentCardActivity::class.java)
        startActivityForResult(intent, CREATE_STUDENT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CREATE_STUDENT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val newStudentName = data?.getStringExtra(EXTRA_STUDENT_NAME).toString()
                val newStudentAge = data?.getStringExtra(EXTRA_STUDENT_AGE).toString().toInt()
                val newStudentPhone = data?.getStringExtra(EXTRA_STUDENT_PHONE).toString()

                val newStudent = Student(
                    newStudentName,
                    newStudentAge,
                    newStudentPhone
                )
                studentViewModel.insert(newStudent)
            }
        }
    }

}
