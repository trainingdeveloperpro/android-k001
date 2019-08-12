package com.k001.lesson7khanh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentListAdapter internal constructor(): RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){

    private var student = emptyList<Student>()

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val studentName: TextView = itemView.findViewById(R.id.user_name)
        val studentAge: TextView = itemView.findViewById(R.id.user_age)
        val studentTelephone: TextView = itemView.findViewById(R.id.user_telephone)
        val buttonDelete: ImageButton = itemView.findViewById(R.id.button_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current = student[position]
        holder.studentName.text = current.name
        holder.studentAge.text = current.age
        holder.studentTelephone.text = current.telephone
        holder.buttonDelete.setOnClickListener {
            this.student = student.minus(current)
            notifyItemChanged(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = student.size

    internal fun setStudent(student: List<Student>){
        this.student = student
        notifyDataSetChanged()
    }

}