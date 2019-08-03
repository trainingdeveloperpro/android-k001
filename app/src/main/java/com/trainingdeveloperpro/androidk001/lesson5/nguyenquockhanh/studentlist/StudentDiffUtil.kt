package com.trainingdeveloperpro.androidk001.lesson5.nguyenquockhanh.studentlist

import androidx.recyclerview.widget.DiffUtil

class StudentDiffUtil(private val oldList : ArrayList<Student>, private val newList : ArrayList<Student>) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].telephone == newList[newItemPosition].telephone
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}