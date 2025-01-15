package com.example.Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList = new ArrayList<>(); // 메뉴 리스트 선언
    private List<MenuItem> bag = new ArrayList<>(); // 장바구니 리스트
    public Kiosk(List<Menu> menu){
        this.menuList = menu;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<MenuItem> getBag() {
        for (int i=0; i<bag.size(); i++){
            System.out.println("현재 장바구니 상태: " + bag.get(i));
        }
        return bag;
    }

    public void start() throws BadInputError {
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("[ MAIN MENU ]");
                for (int i = 0; i < menuList.size(); i++) { // 상위 카테고리 출력
                    System.out.println(i+1 + "." + menuList.get(i));
                }
                System.out.println("0. 종료 | 종료");
                int num = sc.nextInt(); // 숫자를 입력 받음
                if (num == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                if (num <0 || num > menuList.size()){
                    System.out.println("잘못된 숫자를 입력했습니다");
                    continue;
                }

                Menu selectedMenu = menuList.get(num-1);
                while (true){
                    System.out.println("[" + selectedMenu.getMenus() + "]");
                    selectedMenu.showMenuItems();
                    System.out.println("0. 뒤로가기");

                    int secondChoice = sc.nextInt();

                    if (secondChoice == 0){
                        break;
                    }
                    if (secondChoice < 0 || secondChoice > selectedMenu.getMenuItems().size()){
                        System.out.println("잘못된 입력입니다.");
                    }

                    MenuItem selectsecondmenu = selectedMenu.getMenuItems().get(secondChoice-1);
                    System.out.println("선택한 메뉴 :" + selectsecondmenu);
                    System.out.println("==================================================================");
                    System.out.println("몇 개를 주문하시겠습니까?");
                    int itemnum = sc.nextInt();
                    System.out.println("주문 갯수 : " + itemnum);
                    System.out.println("==================================================================");
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인 | 2. 취소");
                    if ("1".equals(sc.next())){
                        System.out.println(selectsecondmenu + "이 장바구니에 추가되었습니다.");
                        bag.add(selectsecondmenu);
                        System.out.println("==================================================================");
                    } else if ("2".equals(sc.next())){
                        System.out.println("주문을 취소합니다.");
                        break;
                    } else {
                        throw new BadInputError();
                    }
                    getBag(); // 장바구니에 있는 아이템 조회
                    System.out.println("주문한 상품 갯수:" + itemnum);
                    System.out.println("추가로 더 주문하시겠습니까?");
                    System.out.println("1. 예 | 2. 아니요");
                    if ("1".equals(sc.next())){ // 1번을 누르면 다시 추가로 주문하는 목록
                        continue;
                    } else if ("2".equals(sc.nextLine())) {
                        break; // 2가 아닌 숫자를 입력하면 예외처리로 들어감
                    }
                    System.out.println("[ ORDER MENU ]");
                    System.out.println("4. Orders | 장바구니를 확인 후 주문합니다.");
                    System.out.println("5. Cancel | 진행중인 주문을 취소합니다.");
                    if("4".equals(sc.next())){
                        System.out.println("아래와 같이 주문하시겠습니까?");
                    } else if ("5".equals(sc.next())) {
                        System.out.println("진행중인 주문을 취소합니다");
                        break;
                    } else {
                        throw new BadInputError();
                    }

                    System.out.println("====================================================");
                    System.out.println("[ Orders ]");
                    System.out.println(getBag());
                    System.out.println("====================================================");
                    System.out.println("[ Total ]");
                    System.out.println("W " + selectedMenu.getMenuItems().get(secondChoice-1).getPrice());
                    System.out.println("1. 주문 | 2. 메뉴판");
                    if ("1".equals(sc.next())){
                        //System.out.println("주문이 완료되었습니다. 금액은 W" + selectedMenu.getMenuItems().get(secondChoice-1).getPrice() +"입니다");
                        //System.exit(0); // 주문후 시스템을 종료함
                        System.out.println("주문이 완료되어 결제창으로 넘어갑니다.");
                    } else if ("2".equals(sc.next())) {
                        System.out.println("메뉴판으로 돌아갑니다.");
                        continue; // 주문후 시스템을 종료함
                    } else {
                        throw new BadInputError();
                    }
                    System.out.println("할인정보를 입력해주세요");
                    System.out.println("1. 국가 유공자 : 10%");
                    System.out.println("2. 군인 : 5%");
                    System.out.println("3. 학생 : 3%");
                    System.out.println("4. 일반 : 0%");
                    int usernum = sc.nextInt();
                    UserSale usertype = UserSale.getType(String.valueOf(usernum));
                    System.out.println(UserCalculator.result);
                    // 1. 총 값을 어떻게 넘기냐.
                    // 2. 장바구니에
                }
            }
        }
    }
