package com.example.myapplication.models;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodViewModel extends ViewModel {
    private List<Food> foodList = new ArrayList<>();

    public List<Food> getFoodList() {
        return foodList;
    }
}
