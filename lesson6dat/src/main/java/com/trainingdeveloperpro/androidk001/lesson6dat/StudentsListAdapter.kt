package com.trainingdeveloperpro.androidk001.lesson6dat

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class StudentsListAdapter(private val students: ArrayList<Student>) :
    RecyclerView.Adapter<StudentsListAdapter.StudentViewHolder>() {

    private val TAG = StudentsListAdapter::class.java.simpleName

    var tracker: SelectionTracker<Long>? = null

    init {
        setHasStableIds(true)
    }

    class StudentViewHolder(private val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
        fun bind(student: Student, isStudentSelected: Boolean = false) {
            val textViewStudentName: TextView = cardView.findViewById(R.id.text_view_student_name)
            textViewStudentName.text = student.name

            val textViewStudentAge: TextView = cardView.findViewById(R.id.text_view_student_age)
            textViewStudentAge.text = student.age.toString()


            val textViewStudentPhone: TextView = cardView.findViewById(R.id.text_view_student_phone)
            textViewStudentPhone.text = student.phoneNumber

            cardView.isActivated = isStudentSelected
        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): Long? = itemId
            }
    }

    override fun getItemCount() = students.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.student_card, parent, false) as CardView
        return StudentViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        tracker?.let {
            holder.bind(students[position], it.isSelected(position.toLong()))
        }
    }

    fun removeItem(index: Int) {
        students.removeAt(index)
        notifyItemChanged(index)
        notifyDataSetChanged()
    }

    fun updateList(newStudents: ArrayList<Student>) {
        notifyDataSetChanged()

        val diffCallback = StudentDiffCallback(students, newStudents)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        LogTool.logD(TAG, "updateList old list $students")
        students.clear()
        students.addAll(newStudents)
        LogTool.logD(TAG, "updateList new list $students")

        diffResult.dispatchUpdatesTo(this)
    }
}
