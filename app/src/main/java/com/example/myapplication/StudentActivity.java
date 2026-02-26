package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentActivity extends AppCompatActivity {
    EditText edStudentName;
    EditText edStudentAge;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student);

        edStudentName = findViewById(R.id.ed_student_name);
        edStudentAge = findViewById(R.id.ed_student_age);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(v -> {
            String studentName = edStudentName.getText().toString();
            String studenAgeStr = edStudentAge.getText().toString();

            if (studentName.isEmpty()){
                Toast.makeText(this, "Nhập tên", Toast.LENGTH_LONG).show();
                return;
            }
            if (studenAgeStr.isEmpty()){
                Toast.makeText(this, "Nhập tuổi", Toast.LENGTH_LONG).show();
                return;
            }
            try {
                int studentAge = Integer.parseInt(studenAgeStr);
                Intent intent = new Intent(StudentActivity.this, SecondStudentActivity.class);
                intent.putExtra("STUDENT_NAME_KEY", studentName);
                intent.putExtra("STUDENT_AGE_KEY", studentAge);
                startActivity(intent);
            }
            catch (NumberFormatException e){
                Toast.makeText(this, "Tuổi phải là số", Toast.LENGTH_LONG).show();
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}