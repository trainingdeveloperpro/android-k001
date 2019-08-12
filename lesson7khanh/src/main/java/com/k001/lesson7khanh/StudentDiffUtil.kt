package com.k001.lesson7khanh

import androidx.recyclerview.widget.DiffUtil

class StudentDiffUtil(private val oldList: List<Student>, private val newList: List<Student>): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].telephone == newList[newItemPosition].telephone
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if(oldList[oldItemPosition].name == newList[newItemPosition].name) {
            return oldList[oldItemPosition].age == newList[newItemPosition].age
        } else false
    }
}