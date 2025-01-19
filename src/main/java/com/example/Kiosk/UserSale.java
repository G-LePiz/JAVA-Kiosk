package com.example.Kiosk;

public enum UserSale {
    국가유공자("1"),
    군인("2"),
    학생("3"),
    일반("4");

    private String usertype;

    UserSale(String usertype) {
        this.usertype = usertype;
    }

    public static UserSale getType(String usertype){ // 결제하는 사람의 등급을 받아서, 등급에 맞게 결제하도록 도와줌
        if(usertype.equals("1")){
            System.out.println("국가유공자 할인대상입니다."); // 1번을 입력하면 국가유공자로 인식하여, 국가유공자 할인으로 들어감
            return UserSale.국가유공자;
        } else if (usertype.equals("2")){
            System.out.println("군인 할인대상입니다."); // 2번을 입력하면 군인으로 인식하여, 군인 할인으로 들어감
            return UserSale.군인;
        } else if (usertype.equals("3")){
            System.out.println("학생 할인대상입니다."); // 3번을 입력하면 학생으로 인식하여, 학생 할인으로 들어감
            return UserSale.학생;
        } else if (usertype.equals("4")) {
            System.out.println("일반 할인대상입니다."); // 4번을 입력하면 일반으로 인식하여, 할인이 들어가지않음.
            return UserSale.일반;
        }
        return null; // 1,2,3,4번에서 해당사항이 아닐 시에는 null로 반환
    }
}
