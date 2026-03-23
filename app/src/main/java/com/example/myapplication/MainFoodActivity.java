package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.FoodAdapter;
import com.example.myapplication.interfaces.OnFoodClickListener;
import com.example.myapplication.model.Food;
import com.example.myapplication.models.FoodViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFoodActivity extends AppCompatActivity implements OnFoodClickListener {
    private Button btnAdd;
    private RecyclerView rcvFood;
    private FoodAdapter adapter;
    private List<Food> foodList;
    private FoodViewModel foodViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_food);

        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);

        btnAdd = findViewById(R.id.btn_add_food);
        rcvFood = findViewById(R.id.rcv_food);

        foodList = foodViewModel.getFoodList();
        adapter = new FoodAdapter(foodList, this);

        rcvFood.setLayoutManager(new LinearLayoutManager(this));
        rcvFood.setAdapter(adapter);



        btnAdd.setOnClickListener(v -> {
            showDialogAddFood();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showDialogAddFood() {
        View view = getLayoutInflater().inflate(R.layout.dialog_add_food,null);

        EditText edtName = view.findViewById(R.id.edt_food_name);
        EditText edtPrice = view.findViewById(R.id.edt_food_price);

        new AlertDialog.Builder(this).setTitle("add food").setView(view).setPositiveButton("Add", (dialog, which) -> {
            String name = edtName.getText().toString();
            double price = Double.parseDouble(edtPrice.getText().toString());

            Food food = new Food(name,price);
            foodList.add(food);
            adapter.notifyItemInserted(foodList.size()-1);
        }).setNegativeButton("Cancel", null).show();
    }


    @Override
    public void onFoodClick(Food food) {
        Intent intent = new Intent(this, FoodDetailActivity.class);
        intent.putExtra("name",food.getNameFood());
        intent.putExtra("price",food.getPriceFood());

        startActivity(intent);
    }
}