package com.trainingdeveloperpro.androidk001.studentmanager

import android.app.Activity
import android.content.Intent
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
import com.trainingdeveloperpro.androidk001.lesson6linh.*

private const val GRID_LAYOUT_SPAN_COUNT = 2
private const val CREATE_STUDENT_REQUEST = 1

const val EXTRA_STUDENT_NAME = "com.trainingdeveloperpro.androidk001.studentmanager.STUDENT_NAME"
const val EXTRA_STUDENT_AGE = "com.trainingdeveloperpro.androidk001.studentmanager.STUDENT_AGE"
const val EXTRA_STUDENT_PHONE = "com.trainingdeveloperpro.androidk001.studentmanager.STUDENT_PHONE"

const val BUNDLE_STATE_STUDENTS = "STUDENTS"

class StudentListFragment : Fragment() {
    private val TAG = StudentListFragment::class.java.simpleName
    private var tracker: SelectionTracker<Long>? = null

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: StudentsListAdapter
    private lateinit var students: ArrayList<Student>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_student_list, container, false)

        createRecyclerView(rootView, savedInstanceState)
        setButtonsOnClickListeners(rootView)

        return rootView
    }

    private fun setButtonsOnClickListeners(rootView: View) {
        rootView.findViewById<Button>(R.id.button_student_list_delete)
            .setOnClickListener { deleteSelectedStudentCards() }

        rootView.findViewById<Button>(R.id.button_student_list_add)
            .setOnClickListener { addStudentCard() }

        rootView.findViewById<Button>(R.id.button_student_list_sort)
            .setOnClickListener { onClickButtonSort() }
    }

    private fun createRecyclerView(rootView: View, savedState: Bundle?): RecyclerView {
        LogTool.logD(TAG, "createRecyclerView called, dataset recreated")
        students = if (savedState != null) {
            val loadedStudents = savedState.getParcelableArrayList<Student>(BUNDLE_STATE_STUDENTS)
            loadedStudents!!
        } else {
            getStudents()
        }
        viewManager = GridLayoutManager(activity, GRID_LAYOUT_SPAN_COUNT)
        viewAdapter = StudentsListAdapter(students)
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view_students)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        createRecyclerViewTracker(recyclerView)

        return recyclerView
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogTool.logD(TAG, "onSaveInstanceState called!")
        outState.putParcelableArrayList(BUNDLE_STATE_STUDENTS, students)
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

                val newStudent = Student(newStudentName, newStudentAge, newStudentPhone)

                val newStudentList = ArrayList<Student>()
                newStudentList.addAll(students)
                newStudentList.add(newStudent)

                viewAdapter.updateList(newStudentList)
            }
        }
    }

    private fun sortStudentListByName(): ArrayList<Student> = ArrayList(students.sortedBy { it.name })

    private fun onClickButtonSort() {
        val sortedList = sortStudentListByName()
        viewAdapter.updateList(sortedList)
    }
}
