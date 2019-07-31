package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val items: ArrayList<Student>) : RecyclerView.Adapter<StudentViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StudentViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student: Student = items[position]
        holder.bind(student)
        holder.buttonDelete?.setOnClickListener {
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
        }
    }


}