package com.example.Kiosk;

public class MenuItem {
    private String name;
    private double price;
    private String fooddetail;

    public MenuItem(String name, double price, String fooddetail){
        this.name = name;
        this.price = price;
        this.fooddetail = fooddetail;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return name + " | W " + price + " | " + fooddetail;
    }
}
