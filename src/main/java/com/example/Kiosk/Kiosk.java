package com.example.Kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Kiosk {
    private List<Menu> menuList = new ArrayList<>(); // 메뉴 리스트 선언
    Bag b = new Bag();
     // 장바구니 리스트
    public Kiosk(List<Menu> menu){
        this.menuList = menu;
    }

    public void start() throws BadInputError {
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("[ MAIN MENU ]"); // 메인메뉴 출력
                for (int i = 0; i < menuList.size(); i++) { // 상위 카테고리 출력
                    System.out.println(i+1 + "." + menuList.get(i));
                }
                System.out.println("0. 종료 | 종료");
                int num = sc.nextInt(); // 숫자를 입력 받음
                if (num == 0){ // 0을 입력시에 프로그램 종료
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

                    if (secondChoice == 0){ // 0을 입력시, break 해버림
                        break;
                    }
                    if (secondChoice < 0 || secondChoice > selectedMenu.getMenuItems().size()){ // 입력된 숫자가 0보다 작거나, 배열의 크기보다 크면 예외처리를 해버림
                       throw new BadInputError(secondChoice);
                    }

                    MenuItem selectsecondmenu = selectedMenu.getMenuItems().get(secondChoice-1); // 상세 메뉴 고르기
                    System.out.println("선택한 메뉴 :" + selectsecondmenu);
                    System.out.println("==================================================================");
                    System.out.println("몇 개를 주문하시겠습니까?");
                    int itemnum = sc.nextInt();
                    System.out.println("주문 갯수 : " + itemnum);
                    System.out.println("==================================================================");
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인 | 2. 취소");
                    int bagnum = sc.nextInt();
                    if (bagnum == 1){
                        System.out.println(selectsecondmenu + "이 장바구니에 추가되었습니다.");
                        b.add(selectsecondmenu);
                        System.out.println("==================================================================");
                    } else if (bagnum == 2){
                        System.out.println("주문을 취소합니다.");
                        break;
                    } else {
                        throw new BadInputError(bagnum);
                    }

                    b.getBag(); // 장바구니에 있는 아이템 조회
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
                    int ocnum = sc.nextInt();
                    if (ocnum == 4){
                        System.out.println("아래와 같이 주문하시겠습니까?");
                    } else if (ocnum == 5) {
                        System.out.println("진행중인 주문을 취소합니다. 장바구니가 초기화됩니다.");
                        b.clear(); // 장바구니에 있는 음식들 다 초기화를 함
                        break;
                    } else {
                        throw new BadInputError(ocnum);
                    }

                    System.out.println("====================================================");
                    System.out.println("[ Orders ]");
                    System.out.println(b.getBag());
                    System.out.println("====================================================");
                    System.out.println("[ Total ]");

                    double totalamount = b.bag.stream().mapToDouble(i -> Double.valueOf(i.getPrice()*itemnum)).sum(); // 장바구니에 있는 제품의 총 가격

                    System.out.println("W " + totalamount); // 총 가격 출력
                    System.out.println("1. 주문 | 2. 메뉴판");

                    int ordernum = sc.nextInt(); // 주문, 메뉴판 선택

                    if (ordernum == 1){ // 1번 입력시
                        System.out.println("주문을 성공하여 결제창으로 넘어갑니다");
                    } else if (ordernum == 2) { // 2번 입력시
                        System.out.println("메뉴판으로 돌아갑니다");
                        break;
                    } else {
                        throw new BadInputError(ordernum);
                    }

                    while (true){
                        System.out.println("할인정보를 입력해주세요"); // 사용자 유형별 할인 정하기
                        System.out.println("1. 국가 유공자 : 10%");
                        System.out.println("2. 군인 : 5%");
                        System.out.println("3. 학생 : 3%");
                        System.out.println("4. 일반 : 0%");
                        int usernum = sc.nextInt(); // 사용자 유형을 입력받음

                        UserSale usertype = UserSale.getType(String.valueOf(usernum)); // 사용자 유형을 UserSale 클래스에 넘김
                        double u1 = UserCalculator.calculator(usertype, totalamount); // 사용자 유형과 총 가격을 UserCalculator로 넘김
                        System.out.println("주문이 완료 되었습니다. 금액은 W " + u1 + "입니다");
                        System.exit(0);
                    }
                }
            }
        }
    }
