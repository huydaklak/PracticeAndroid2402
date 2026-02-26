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

public class CarActivity extends AppCompatActivity {

    EditText edCarName;
    EditText edCarPrice;
    Button btnAddCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edCarName = findViewById(R.id.ed_car_name);
        edCarPrice = findViewById(R.id.ed_car_price);
        btnAddCar = findViewById(R.id.btn_add);

        btnAddCar.setOnClickListener(v -> {
            String carName = edCarName.getText().toString();
            String priceInput = edCarPrice.getText().toString();

            if (carName.isEmpty()){
                Toast.makeText(this, "Vui long nhap ten", Toast.LENGTH_LONG).show();
                return;
            }

            if (priceInput.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập giá xe", Toast.LENGTH_LONG).show();
                return;
            }

            try {
                Intent intent = new Intent(CarActivity.this, SecondCarActivity.class);
                intent.putExtra("name_car_key", carName);
                intent.putExtra("name_price_key", priceInput);
                startActivity(intent);
            }
            catch (NumberFormatException e){
                Toast.makeText(this, "Giá xe không hợp lệ", Toast.LENGTH_SHORT).show();
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}