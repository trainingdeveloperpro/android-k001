package com.trainingdeveloperpro.androidk001.lesson6linh

import androidx.recyclerview.widget.DiffUtil

class StudentDiffCallback(private val oldList: ArrayList<Student>, private val newList: ArrayList<Student>) :
    DiffUtil.Callback() {
    private val TAG = StudentDiffCallback::class.java.simpleName
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem == newItem
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
}