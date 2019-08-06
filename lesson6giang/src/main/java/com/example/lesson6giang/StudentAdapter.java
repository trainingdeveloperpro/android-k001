package com.example.lesson6giang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List mStdudents;
    private Context context;

    public StudentAdapter(List mStdudents, Context context) {
        this.mStdudents = mStdudents;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View studentView = inflater.inflate(R.layout.student_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = (Student) mStdudents.get(position);
        holder.studentname.setText(student.getmName());
        holder.age.setText(student.getmAge() + " Years");
        holder.phone.setText(student.getmPhone());
    }

    @Override
    public int getItemCount() {
        return mStdudents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private View itemview;
        public TextView studentname;
        public TextView phone;
        public TextView age;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemview = itemView;
            studentname = itemView.findViewById(R.id.txtName);
            age = itemView.findViewById(R.id.txtAge);
            phone = itemView.findViewById(R.id.txtPhone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteIteam(getAdapterPosition());
                }
            });
        }

        public void deleteIteam(int position){
            mStdudents.remove(position);
            notifyItemRemoved(position);
        }
    }
}
