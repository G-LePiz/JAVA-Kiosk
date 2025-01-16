package com.example.Kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems = new ArrayList<>(); //메뉴 아이템의 리스트를 선언
    private String menus; // 메뉴 필드

    public Menu(String menus) { // 메뉴 생성자
        this.menus = menus;
        this.menuItems = new ArrayList<MenuItem>();
    }

    public String getMenus() { // 카테고리를 가져오기
        return menus;
    }

    public List<MenuItem> getMenuItems() { // 상세 메뉴 조회
        return menuItems;
    }

    public void addmenuItems(MenuItem menuItem){ // 메뉴 아이템 추가
        menuItems.add(menuItem);
    }
    public void showMenuItems(){ // 카테고리안에 있는 것을 출력
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i+1 + "." + menuItems.get(i));
        }
    }
    public String toString(){ // 주소값 출력을 String 출력으로 변경
        return menus;
    }
}
