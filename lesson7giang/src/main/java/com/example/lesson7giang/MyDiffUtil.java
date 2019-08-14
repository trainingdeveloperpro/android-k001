package com.example.lesson7giang;

import androidx.recyclerview.widget.DiffUtil;


public class MyDiffUtil extends DiffUtil.Callback {
    StudentViewModel newList;
    StudentViewModel oldList;

    public MyDiffUtil(StudentViewModel newList, StudentViewModel oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }


    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.getName(newItemPosition) == oldList.getName(newItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
}
