package com.example.Kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Kiosk {
    private List<Menu> menuList = new ArrayList<>(); // 메뉴 리스트 선언
    Bag b = new Bag();
    UserCalculator uc = new UserCalculator();
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

                    MenuItem selectSecondMenu = selectedMenu.getMenuItems().get(secondChoice-1); // 상세 메뉴 고르기
                    System.out.println("선택한 메뉴 :" + selectSecondMenu);
                    System.out.println("==================================================================");
                    System.out.println("몇 개를 주문하시겠습니까?");
                    int itemNum = sc.nextInt();
                    System.out.println("주문 갯수 : " + itemNum);
                    System.out.println("==================================================================");
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인 | 2. 취소");
                    int bagNum = sc.nextInt();
                    if (bagNum == 1){
                        System.out.println(selectSecondMenu + "이 장바구니에 추가되었습니다.");
                        b.add(selectSecondMenu);
                        System.out.println("==================================================================");
                    } else if (bagNum == 2){
                        System.out.println("주문을 취소합니다.");
                        break;
                    } else {
                        throw new BadInputError(bagNum);
                    }

                    b.getBag(); // 장바구니에 있는 아이템 조회
                    System.out.println("주문한 상품 갯수:" + itemNum);
                    b.add(itemNum); // 리스트에 주문한 갯수 추가
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
                    int ocNum = sc.nextInt();
                    if (ocNum == 4){
                        System.out.println("아래와 같이 주문하시겠습니까?");
                    } else if (ocNum == 5) {
                        System.out.println("진행중인 주문을 취소합니다. 장바구니가 초기화됩니다.");
                        b.clear(); // 장바구니에 있는 음식들 다 초기화를 함
                        break;
                    } else {
                        throw new BadInputError(ocNum);
                    }

                    System.out.println("====================================================");
                    System.out.println("[ Orders ]");
                    System.out.println("현재 장바구니 상태 ");
                    b.getBag();
                    System.out.println("주문한 개수: " + b.getFoodnum());
//                    b.getFoodnum();
                    System.out.println("====================================================");
                    System.out.println("[ Total ]");

                    System.out.println("W " + b.totalmoney()); // 총 가격 출력
                    System.out.println("1. 주문 | 2. 메뉴판");
                    int orderNum = sc.nextInt(); // 주문, 메뉴판 선택

                    if (orderNum == 1){ // 1번 입력시
                        System.out.println("주문을 성공하여 결제창으로 넘어갑니다");
                    } else if (orderNum == 2) { // 2번 입력시
                        System.out.println("메뉴판으로 돌아갑니다");
                        break;
                    }  else {
                        throw new BadInputError(orderNum);
                    }
                    System.out.println("장바구니에서 제거할 아이템이 있습니까?");
                    System.out.println("1. 예 | 2. 아니요");
                    int bagRemove = sc.nextInt();
                    sc.nextLine(); // 버퍼를 지우는 것
                    if(bagRemove == 1){
                        System.out.println("삭제할 메뉴를 입력해주세요.");
                        String itemName = sc.nextLine();
                        List<MenuItem> removeItem = b.removeItem(itemName);
                        System.out.println(removeItem);
                        System.out.println("삭제되었습니다.");
                    }
                        System.out.println("할인정보를 입력해주세요"); // 사용자 유형별 할인 정하기
                        System.out.println("1. 국가 유공자 : 10%"); // 국가 유공자
                        System.out.println("2. 군인 : 5%");
                        System.out.println("3. 학생 : 3%");
                        System.out.println("4. 일반 : 0%");
                        int userNum = sc.nextInt(); // 사용자 유형을 입력받음

                        UserSale userType = UserSale.getType(String.valueOf(userNum)); // 사용자 유형을 UserSale 클래스에 넘김
                        double userTypeTotalPrice = UserCalculator.calculator(userType, b.getResult()); // 사용자 유형과 총 가격을 UserCalculator로 넘김
                        System.out.println("주문이 완료 되었습니다. 금액은 W " + userTypeTotalPrice + "입니다");
                        System.exit(0);



                }
            }
        }
    }
