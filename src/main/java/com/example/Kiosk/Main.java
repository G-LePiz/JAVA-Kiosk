package com.example.Kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu burgers = new Menu("Burgers"); // 햄버거라는 카테고리 추가
        burgers.addmenuItems(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addmenuItems(new MenuItem("SmokeBurger", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addmenuItems(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addmenuItems(new MenuItem("Hambuger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        Menu drinks = new Menu("Drinks"); // Drinks라는 카테고리 추가
        drinks.addmenuItems(new MenuItem("Americano", 4.5, "산뜻하고 신맛이 나는 원두로 만든 아메리카노"));
        drinks.addmenuItems(new MenuItem("Ice-Americano", 5.0, "여름에 뜨거운 커피 대신에 시원한 커피를 마셔보세요!"));
        drinks.addmenuItems(new MenuItem("CaffeLatte", 5.5, "신선한 우유와 함께 섞인 커피를 마셔보세요!"));
        drinks.addmenuItems(new MenuItem("Cappuccino", 6.0, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        Menu desserts = new Menu("Desserts"); // Desserts라는 카테고리 추가
        desserts.addmenuItems(new MenuItem("CupCake", 7.0, "달콤한 컵 케이크!"));
        desserts.addmenuItems(new MenuItem("FrachToast", 9.0, "아침에 잘 어울리는 프렌치 토스트를 맛 봐보세요!"));
        desserts.addmenuItems(new MenuItem("Cookie", 3.0, "커피에는 쿠키가 잘 어울리는 법이죠"));
        desserts.addmenuItems(new MenuItem("Cappuccino", 10.0, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));


        Kiosk k = new Kiosk(Arrays.asList(burgers,drinks,desserts)); // 키오스크에 카테고리를 넣음.
        try {
            k.start(); // 키오스크 시작
        } catch (BadInputError e) {
            throw new RuntimeException(e); // 예외처리
        }


    }
}
