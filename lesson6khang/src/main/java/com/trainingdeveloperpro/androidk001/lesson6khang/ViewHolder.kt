package com.trainingdeveloperpro.androidk001.lesson6khang

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.student_card, parent, false)){
    private var userName: TextView? = null
    private var userAge: TextView? = null
    private var userPhoneNumber: TextView? = null
    var buttonDelete: ImageButton? = null
    init {
        userName = itemView.findViewById(R.id.text_view_student_name)
        userAge = itemView.findViewById(R.id.text_view_student_age)
        userPhoneNumber = itemView.findViewById(R.id.text_view_student_phone)
        buttonDelete = itemView.findViewById(R.id.button_student_list_delete)
    }

    fun bind(student: Student){
        userName?.text = student.name
        userAge?.text = student.age
        userPhoneNumber?.text = student.phonenumber
    }
}