package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.interfaces.OnFoodClickListener;
import com.example.myapplication.model.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> foodList;
    private OnFoodClickListener listener;

    public FoodAdapter(List<Food> foodList, OnFoodClickListener listener) {
        this.foodList = foodList;
        this.listener = listener;
    }

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);

        holder.txtNameFood.setText(food.getNameFood());
        holder.txtPriceFood.setText(String.valueOf(food.getPriceFood()));

        holder.itemView.setOnClickListener(v -> {
            if(listener != null){
                listener.onFoodClick(food);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(foodList != null){
            return foodList.size();
        }
        return 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNameFood;
        private TextView txtPriceFood;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameFood = itemView.findViewById(R.id.txt_food_name);
            txtPriceFood = itemView.findViewById(R.id.txt_food_price);
        }
    }

}
