package com.example.lesson7giang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView phone;
        public TextView age;
        private View itemview;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            itemview = itemView;
            name = itemView.findViewById(R.id.txtName);
            age = itemView.findViewById(R.id.txtAge);
            phone = itemView.findViewById(R.id.txtPhone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteStudent(getAdapterPosition());
                }
            });
        }

        public void deleteStudent(int position){
            mStudents.remove(position);
            notifyItemRemoved(position);
        }
    }

    private final LayoutInflater mInflater;
    private List<Student> mStudents = Collections.emptyList();

    StudentAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View studentView = mInflater.inflate(R.layout.item_student, parent, false);
        StudentViewHolder viewHolder = new StudentViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = (Student) mStudents.get(position);
        holder.name.setText(student.getName());
        holder.age.setText(student.getAge() + " years");
        holder.phone.setText(student.getPhone());
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    void setStudent(List<Student> student) {
        mStudents = student;
        notifyDataSetChanged();
    }
}
