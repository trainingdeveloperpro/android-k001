package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_view, parent, false)){
    private var userName: TextView? = null
    private var userAge: TextView? = null
    private var userTelephone: TextView? = null
    var buttonDelete: ImageButton? = null
    init {
        userName = itemView.findViewById(R.id.user_name)
        userAge = itemView.findViewById(R.id.user_age)
        userTelephone = itemView.findViewById(R.id.user_telephone)
        buttonDelete = itemView.findViewById(R.id.button_delete)
    }

    fun bind(student: Student){
        userName?.text = student.name
        userAge?.text = student.age
        userTelephone?.text = student.telephone
    }
}