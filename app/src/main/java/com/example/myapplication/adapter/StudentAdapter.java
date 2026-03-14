package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Student;

import org.w3c.dom.Text;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> myStudentsList;

    public StudentAdapter(List<Student> myStudentsList) {
        this.myStudentsList = myStudentsList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = myStudentsList.get(position);
        if (student == null){
            return;
        }
        holder.tvNameStudent.setText(student.getName());
        holder.tvAgeStudent.setText(String.valueOf(student.getAge()));
    }

    @Override
    public int getItemCount() {
        if (myStudentsList != null){
            return myStudentsList.size();
        }
        return 0;
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNameStudent;
        private TextView tvAgeStudent;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameStudent = itemView.findViewById(R.id.txt_name);
            tvAgeStudent = itemView.findViewById(R.id.txt_age);
        }
    }


}
