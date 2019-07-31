package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_view, parent, false)) {
    private var mName: TextView? = null
    private var mAge: TextView? = null
    private var mTelephone: TextView? = null
    var buttonDelete: ImageButton? = null

    init {
        mName = itemView.findViewById(R.id.user_name)
        mAge = itemView.findViewById(R.id.user_age)
        mTelephone = itemView.findViewById(R.id.user_telephone)
        buttonDelete = itemView.findViewById(R.id.button_delete)
    }

    fun bind(student: Student) {
        mName?.text = student.name
        mAge?.text = student.age
        mTelephone?.text = student.telephone
    }
}