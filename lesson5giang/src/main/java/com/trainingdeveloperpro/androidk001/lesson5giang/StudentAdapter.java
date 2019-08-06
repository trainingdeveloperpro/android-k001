package com.trainingdeveloperpro.androidk001.lesson5giang;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List mStutents;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;
    private Object mRecentlyDeletedItem;
    private int mRecentlyDeletedItemPosition;
    private Activity mActivity;

    public StudentAdapter(List _student, Context mContext) {
        this.mStutents = _student;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử sinh viên
        View studentView = inflater.inflate(R.layout.student_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = (Student) mStutents.get(position);

        holder.studentname.setText(student.getmName());
        holder.birthyear.setText(student.getBirthYear()+" Years");
        holder.phone.setText(student.getmPhone());

    }

    @Override
    public int getItemCount() {
        return mStutents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public TextView studentname;
        public TextView birthyear;
        public TextView phone;

        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            studentname = itemView.findViewById(R.id.studentname);
            birthyear = itemView.findViewById(R.id.birthyear);
            phone = itemView.findViewById(R.id.txtPhone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteItem(getAdapterPosition());
                }
            });
        }
    }

    public void deleteItem(int position) {
        mStutents.remove(position);
        notifyItemRemoved(position);
    }
}