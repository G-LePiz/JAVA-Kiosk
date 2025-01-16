package com.example.Kiosk;

import java.util.ArrayList;
import java.util.List;

public class Bag { // 장바구니 클래스
     List<MenuItem> bag = new ArrayList<>();

    public void add(MenuItem selectsecondmenu) { // 장바구니 추가
        bag.add(selectsecondmenu);
    }

    public List<MenuItem> getBag() { // 장바구니 조회
        for (int i=0; i<bag.size(); i++){
            System.out.println("현재 장바구니 상태: " + bag.get(i));
        }
        return bag;
    }

    public void clear(){ // 장바구니 초기화
        bag.clear();
    }

}
