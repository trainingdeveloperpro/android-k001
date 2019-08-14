package com.example.lesson7giang;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.example.lesson7giang.AddNewStudent.EXTRA_USER_NAME;
import static com.example.lesson7giang.AddNewStudent.EXTRA_USER_AGE;
import static com.example.lesson7giang.AddNewStudent.EXTRA_USER_PHONE;


public class StudentFragment extends Fragment {

    public static final int CREATE_USER_REQUEST = 1;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    FloatingActionButton btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_student, container, false);
        recyclerView = rootView.findViewById(R.id.listStdudent);

        // Add a list student
        addListStudent();

        // Set student adapter
        setStudentAdapter();

        // Insert lines divide table
        inserLines();

        // Set GidLayout
        setGridLayout();

        // Add a student
        addAStudent(rootView);


        return rootView;
    }

    private void addAStudent(View rootView) {
        btnAdd = rootView.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddNewStudent.class);
                startActivityForResult(intent, CREATE_USER_REQUEST);
            }
        });
    }

    private void setGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void inserLines() {
        DividerItemDecoration vertical = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(vertical);

    }

    private void setStudentAdapter() {
        studentAdapter = new StudentAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private StudentViewModel mStudentViewModel;

    private void addListStudent() {
        mStudentViewModel = ViewModelProviders.of(getActivity()).get(StudentViewModel.class);
        mStudentViewModel.getAllStudent().observe(getActivity(), new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentAdapter.setStudent(students);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_USER_REQUEST && resultCode == RESULT_OK){

            StudentViewModel newListstudents = mStudentViewModel;
            Log.d("Toast", "Input ok");
            newListstudents.insert(new Student(data.getStringExtra(EXTRA_USER_NAME), data.getStringExtra(EXTRA_USER_PHONE),
                    Integer.parseInt(data.getStringExtra(EXTRA_USER_AGE))));

            MyDiffUtil diffUtil = new MyDiffUtil(newListstudents, mStudentViewModel);
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtil);

//            mStudentViewModel.deleteAll();
            mStudentViewModel = newListstudents;
            diffResult.dispatchUpdatesTo(studentAdapter);
        }
        else {
            Log.d("Toast", "No input");
            Toast.makeText(getActivity(), R.string.toastAddNoone, Toast.LENGTH_LONG).show();
        }
    }
}
