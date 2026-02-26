package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondCarActivity extends AppCompatActivity {
    TextView txtCarName;
    TextView txtCarPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        txtCarName = findViewById(R.id.tv_car_name);
        txtCarPrice = findViewById(R.id.tv_car_price);

        String carNanme = getIntent().getStringExtra("name_car_key");
        txtCarName.setText(carNanme);

        String carPrice = getIntent().getStringExtra("name_price_key");
        txtCarPrice.setText(carPrice);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}