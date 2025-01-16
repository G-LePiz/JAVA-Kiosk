package com.example.Kiosk;

public class MenuItem {
    private String name; // 음식의 이름
    private double price; // 음식의 가격
    private String fooddetail; // 음식의 설명

    public MenuItem(String name, double price, String fooddetail){ // MenuItem의 생성자
        this.name = name;
        this.price = price;
        this.fooddetail = fooddetail;
    }

    public double getPrice() { // 음식의 가격을 조회
        return price;
    }

    public String toString(){ // toString을 사용하여, 주소값을 Stirng 형태로 변경함
        return name + " | W " + price + " | " + fooddetail;
    }
}
