package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondStudentActivity extends AppCompatActivity {

    TextView txtStudentName;
    TextView txtStudentAge;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_student);

        txtStudentName = findViewById(R.id.txt_student_name);
        txtStudentAge = findViewById(R.id.txt_student_age);
        btnBack = findViewById(R.id.btn_back);

        String studentName = getIntent().getStringExtra("STUDENT_NAME_KEY");
        int studentAge = getIntent().getIntExtra("STUDENT_AGE_KEY", -1);


        if (studentName != null){
            txtStudentName.setText(studentName);
        }
        if (studentAge != -1) {
            txtStudentAge.setText(String.valueOf(studentAge));

            if (studentAge < 18) {
                Toast.makeText(this, "Chưa đủ tuổi", Toast.LENGTH_SHORT).show();
            }
        }

        btnBack.setOnClickListener(v -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}