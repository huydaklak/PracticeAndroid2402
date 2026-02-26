package com.example.myapplication.model;

public class Car {
    private String carName;
    private double carPrice;

    public Car(String carName, double carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public void display(){
        System.out.println("Tên xe " + carName + " " +"Giá xe : " + carPrice);
    }
}
