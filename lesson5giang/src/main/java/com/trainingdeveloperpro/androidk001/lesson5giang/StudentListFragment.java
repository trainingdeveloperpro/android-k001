package com.trainingdeveloperpro.androidk001.lesson5giang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentListFragment extends Fragment {
    RecyclerView recyclerView;
    StudentAdapter adapter;
    ArrayList<Student> students;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_student_list, container, false);
        recyclerView = rootView.findViewById(R.id.studentsList);

        students = new ArrayList<Student>();
        //Tự phát sinh 50 dữ liệu mẫu
        for (int i = 1; i <= 50; i++) {
            students.add(new Student("Name "+i , "0946808100", 20 + i));
        }

        adapter = new StudentAdapter(students, getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Chèn một kẻ ngang giữa các phần tử
        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerHorizontal);

        //Chèn một kẻ đứng giữa các phần tử
        DividerItemDecoration dividerVertical =
                new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(dividerVertical);

        int spanCount = 2;//Số cột nếu thiết lập lưới đứng, số dòng nếu lưới ngang
        int orientation = GridLayoutManager.HORIZONTAL;//Lưới đứng

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        // xoa
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }
}
