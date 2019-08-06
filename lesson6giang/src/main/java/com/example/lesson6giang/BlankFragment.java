package com.example.lesson6giang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.lesson6giang.AddItemActivity.*;


public class BlankFragment extends Fragment {
    private static final String TAG = BlankFragment.class.getName();
    public static final Integer CREATE_STUDENT_REQUEST = 1;

    RecyclerView recyclerView;
    StudentAdapter adapter;
    ArrayList<Student> students = new ArrayList<Student>();

    private static final Integer CREATE_MODEL_REQUEST = 1;

    FloatingActionButton btnAdd, btnSort;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
       recyclerView = rootView.findViewById(R.id.listStudent);

       addListStudent();

       adapter = new StudentAdapter(students, getActivity());
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(linearLayoutManager);

       insertLines();

       createGidLayout();


        //Xoa
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // Inflate the layout for this fragment

        creatButtonClick(rootView);

        return rootView;
    }

    private void creatButtonClick(View rootView) {
        btnAdd = rootView.findViewById(R.id.btnAdd);
        btnSort = rootView.findViewById(R.id.btnSort);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortListStudent();
            }
        });
    }

    private void createGidLayout() {
        //Tao luoi
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void insertLines() {
        //Chen 1 hang ke ngang
        DividerItemDecoration dividerV = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerV);

        //Chen 1 hang ke doc
        DividerItemDecoration dividerH = new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(dividerH);
    }

    private void addListStudent() {
        for (int i = 1; i <=10; i++){
            students.add(new Student("Name " + i, "09446120"+ i, 10 + i));
        }
    }

    public void addStudent(){
        Intent intent = new Intent(getActivity(), AddItemActivity.class);
        startActivityForResult(intent, CREATE_STUDENT_REQUEST);
    }

    private void sortListStudent() {
        ArrayList<Student> newArrayList = new ArrayList<>(students);
        Collections.sort(newArrayList);

        for (Student student : newArrayList) {
            Log.d(TAG, student.getmName());
        }

        MyDiffUtilCallback diffCallback = new MyDiffUtilCallback(newArrayList, students);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        students.clear();
        students.addAll(newArrayList);
        diffResult.dispatchUpdatesTo(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult");
        if (requestCode == CREATE_STUDENT_REQUEST){
            Log.d(TAG, "CREATE_MODEL_REQUEST ok");
            if (resultCode == Activity.RESULT_OK){
                Log.d(TAG, "result ok");
                Log.d(TAG, data.getStringExtra(EXTRA_USER_NAME));
                Log.d(TAG, data.getStringExtra(EXTRA_USER_PHONE));
                Log.d(TAG, data.getStringExtra(EXTRA_USER_AGE));

                ArrayList<Student> newList = new ArrayList<>(students);
                newList.add( new Student(data.getStringExtra(EXTRA_USER_NAME), data.getStringExtra(EXTRA_USER_PHONE),
                        Integer.parseInt(data.getStringExtra(EXTRA_USER_AGE))));
                MyDiffUtilCallback diffUtilCallback = new MyDiffUtilCallback(newList, students);
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

                students.clear();
                students.addAll(newList);
                diffResult.dispatchUpdatesTo(adapter);

            }
        }
    }
}
