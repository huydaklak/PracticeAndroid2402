package com.example.myapplication.model;

public class Food {
    private String nameFood;
    private double priceFood;

    public Food(String nameFood, double priceFood) {
        this.nameFood = nameFood;
        this.priceFood = priceFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public double getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(double priceFood) {
        this.priceFood = priceFood;
    }
}
