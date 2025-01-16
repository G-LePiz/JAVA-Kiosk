# 📱 키오스크를 만들어보자!
계산기의 "필수" 과제를 완료한 분들에게 있어 다시 한번 스스로를 검증하는 기회가 될 것입니다. 기초적인 흐름 제어 및 객체 지향 설계 개념을 복습하고 연습할 수 있습니다. 키오스크는 요구사항이 있는 과제 및 클래스 설계를 할 수 있습니다.

# ⚠️ 클래스 설명
1. Main 클래스
- 시작 지점이 되는 클래스, public static void main(String[] args)
2. MenuItem 클래스
- 세부 메뉴 속성을 가지는 클래스
- 햄버거의 이름, 가격 설명
  - ex) ShackBurger, 6.9, 토마토, 양상추, 쉑소스가 토핑된 치즈버거
- new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거")
3. Kiosk 클래스
- 프로그램 순서 및 흐름 제어를 담당하는 클래스
4. Menu 클래스
- MenuItem 클래스를 관리하는 클래스
  - ex) 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
5. UserSale 클래스
- 소비자에 따라서 할인율이 적용되는지 확인하는 클래스
  - ex) 입력값이 1이라고 하면, 1에 맞추어서 국가유공자인지, 군인인지, 학생인지, 일반인인지를 확인합니다.
6. UserCalculator 클래스
- 소바자의 할인율에 따라서 할인된 값을 계산해주는 클래스
7. Bag 클래스
- 장바구니의 역할을 합니다.

# 🖥️ 개발환경
- JAVA 8
- JDK 21.0.5
- InteliJ IDEA

# 🕰️ 개발기간
2025-01-13 ~ 2025-01-20

# 📌 주요기능

## 기본적인 키오스크를 프로그래밍해보자
1. 요구사항이 가지는 의도
  - 입력 처리와 간단한 흐름 제어를 복습합니다.
  - Scanner 활용법, 조건문, 반복문을 재확인하며 입력 데이터를 처리하는 방법 강화
2. 햄버거 메뉴 출력 및 선택하기
  - Scanner를 사용하여 여러 햄버거 메뉴를 출력합니다.
  - 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성합니다.
  - 반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료합니다.
3. LV.1을 구현하면 이렇게 실행됩니다
```[ SHAKESHACK MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 종료      | 종료
0 <- // 0을 입력

프로그램을 종료합니다.
```
## 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
1. 요구사항이 가지는 의도
   - 객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
   - 햄버거 메뉴를 MenuItem 클래스와 List를 통해 관리합니다.
2. MenuItem 클래스 생성하기
   - 설명: 개별 음식 항목을 관리하는 클래스입니다. 현재는 햄버거만 관리합니다.
   - 클래스는 이름, 가격, 설명 필드를 갖습니다.
3. main 함수에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력합니다
   - MenuItem 객체 생성을 통해 이름, 가격, 설명을 세팅합니다.
   - List를 선언하여 여러 MenuItem을 추가합니다.
4. 반복문을 활용해 menuItems를 탐색하면서 하나씩 접근합니다.

## 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기
1. 요구사항이 가지는 의도
   - 객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
   - main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리합니다.
   - List<MenuItem> menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당합니다.
2. 요구사항이 부합하는지 검토
   - 키오스크 프로그램을 시작하는 메서드가 구현되어야합니다.
     - 콘솔에 햄버거 메뉴를 출력합니다
     - 사용자의 입력을 받아 메뉴를 입력하거나 프로그램을 종료합니다.
     - 유효하지 않은 입력에 대해 오류 메세지를 출력합니다.
     - 0을 입력하면 프로그램이 '뒤로가기'되거나 '종료'됩니다.

## 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기
1. Menu 클래스 생성하기
  - 설명: MenuItem 클래스를 관리하는 클래스입니다.
  - List<MenuItem>은 Kiosk 클래스가 관리하기에 적절하지 않으므로 Menu 클래스가 관리하도록 변경합니다.
  - 여러 버거들을 포함하는 상위 개념 '버거'같은 카테고리 이름 필드를 갖습니다.
  - 메뉴 카테고리 이름을 반환하는 메서드가 구현되어야합니다.

## 캡슐화 적용하기
1. MenuItem, Menu 그리고 Kiosk 클래스의 필드에 직접 접근하지 못하도록 설정합니다.
2. Getter와 Setter 메세드를 사용해 데이터를 관리합니다.
