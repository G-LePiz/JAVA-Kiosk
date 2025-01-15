package com.example.Kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems = new ArrayList<>(); //메뉴 아이템의 리스트를 선언
    private String menus;

    public Menu(String menus) {
        this.menus = menus;
        this.menuItems = new ArrayList<MenuItem>();
    }

    public String getMenus() { // 메뉴를 가져오기
        return menus;
    }

    public List<MenuItem> getMenuItems() { // 상세 아이템 조회
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
    public String toString(){
        return menus;
    }
}
