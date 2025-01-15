package com.example.Kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu burgers = new Menu("Burgers");
        burgers.addmenuItems(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addmenuItems(new MenuItem("SmokeBurger", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addmenuItems(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addmenuItems(new MenuItem("Hambuger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");

        Kiosk k = new Kiosk(Arrays.asList(burgers,drinks,desserts)); // 키오스크에 카테고리를 넣음.
        try {
            k.start();
        } catch (BadInputError e) {
            throw new RuntimeException(e);
        }


    }
}
