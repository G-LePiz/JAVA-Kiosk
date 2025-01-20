package com.example.Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag { // 장바구니 클래스
     List<MenuItem> bag = new ArrayList<>(); // 장바구니 리스트 선언
     List<Integer> foodnum = new ArrayList<>(); // 음식의 갯수 리스트 선언
     double result; // 결과 필드

    public void add(MenuItem selectsecondmenu) { // 장바구니를 리스트에 추가 메서드
        bag.add(selectsecondmenu);
    }

    public List<MenuItem> getBag() { /* 장바구니 조회 메서드 */
        for (int i=0; i<bag.size(); i++){
            //System.out.println(bag.get(i));
            System.out.println(bag.get(i));
        }
        return bag;
    }

    public void clear(){ // 장바구니 초기화
        bag.clear();
        foodnum.clear();
    }

    public void add(int foodnumber){ // 음식의 갯수 리스트에 추가
        foodnum.add(foodnumber);
    }

    public List<Integer> getFoodnum() { // 음식의 갯수 조회
        for (int i = 0; i < foodnum.size(); i++) {
            foodnum.get(i);
        }
        return foodnum;
    }

    public double totalmoney(){ // 총 가격
        for (int i = 0; i < bag.size(); i++) {
            result += bag.get(i).getPrice() * foodnum.get(i);
        }
        return result;
    }

    public double getResult() { // 총 가격을 조회하는 메서드
        return result;
    }

    public List<MenuItem> removeItem(String itemname){ // 메뉴 아이템을 받아서 필터링을 함
        return bag.stream()
                .filter(item -> !item.getName().equals(itemname))
                .collect(Collectors.toList());
    }

}
