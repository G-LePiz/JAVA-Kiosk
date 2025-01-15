package com.example.Kiosk;

public class MenuItem {
    private String name;
    private double price;
    private String fooddetail;

    public MenuItem(String name, double price, String fooddetail){ // MenuItem의 생성자
        this.name = name;
        this.price = price;
        this.fooddetail = fooddetail;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){ // toString을 사용하여, 주소값을 Stirng 형태로 변경함
        return name + " | W " + price + " | " + fooddetail;
    }
}
