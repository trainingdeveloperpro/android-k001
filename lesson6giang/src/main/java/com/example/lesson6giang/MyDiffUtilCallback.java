package com.example.lesson6giang;

import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

public class MyDiffUtilCallback extends DiffUtil.Callback {
    ArrayList<Student> oldList;
    ArrayList<Student> newList;

    public MyDiffUtilCallback(ArrayList<Student> oldList, ArrayList<Student> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    public MyDiffUtilCallback() {
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
        return newList.get(newItemPosition).getmName() == oldList.get(oldItemPosition).getmName();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        return false;
    }


}
