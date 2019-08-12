package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.os.Handler

class StudentAdapter(private var items: ArrayList<Student>) : RecyclerView.Adapter<StudentViewHolder>() {
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
            notifyItemChanged(position)
            notifyDataSetChanged()
        }
    }

    fun updateItems(newItems: ArrayList<Student>) {
        updatItemsInternal(newItems)
    }

    fun updatItemsInternal(newItems: ArrayList<Student>) {
        var oldItems: ArrayList<Student> = this.items
        var handler = Handler()
        var runnable = Thread()
        Thread(Runnable {
            var diffResult = DiffUtil.calculateDiff(StudentDiffUtil(oldItems, newItems))
            handler.post(Runnable {
                applyDiffResult(newItems, diffResult)
            })
        }).start()
    }

    fun applyDiffResult(newItems: ArrayList<Student>, diffResult: DiffUtil.DiffResult) {
        dispatchUpdate(newItems, diffResult)
    }

    fun dispatchUpdate(newItems: ArrayList<Student>, diffResult: DiffUtil.DiffResult){
        diffResult.dispatchUpdatesTo(this)
        items.clear()
        items.addAll(newItems)
    }
}