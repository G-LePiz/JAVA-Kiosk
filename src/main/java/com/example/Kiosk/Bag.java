package com.example.Kiosk;

import java.util.ArrayList;
import java.util.List;

public class Bag { // 장바구니 클래스
    static List<MenuItem> bag = new ArrayList<>();

    public static void add(MenuItem selectsecondmenu) {
        bag.add(selectsecondmenu);
    }

    public List<MenuItem> getBag() { // 장바구니 출력
        for (int i=0; i<bag.size(); i++){
            System.out.println("현재 장바구니 상태: " + bag.get(i));
        }
        return bag;
    }

}
