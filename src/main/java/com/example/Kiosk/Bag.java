package com.example.Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag { // 장바구니 클래스
     List<MenuItem> bag = new ArrayList<>();
     List<Integer> foodnum = new ArrayList<>();
     double result;

    public void add(MenuItem selectsecondmenu) { // 장바구니 추가
        bag.add(selectsecondmenu);
    }

    public List<MenuItem> getBag() { // 장바구니 조회
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
//            System.out.println(foodnum.get(i));
        }
        return foodnum;
    }

    public double totalmoney(){ // 구매한 수에 비례한 총 가격
        for (int i = 0; i < bag.size(); i++) {
            result += bag.get(i).getPrice() * foodnum.get(i);
        }
        return result;
    }

    public double getResult() {
        return result;
    }

    public List<MenuItem> removeItem(String itemname){ // 메뉴 아이템을 받아서 필터링을 함
        return bag.stream()
                .filter(item -> !item.getName().equals(itemname))
                .collect(Collectors.toList());
    }

}
