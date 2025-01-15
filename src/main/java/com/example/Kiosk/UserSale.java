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
            return UserSale.국가유공자;
        } else if (usertype.equals("2")){
            return UserSale.군인;
        } else if (usertype.equals("3")){
            return UserSale.학생;
        } else if (usertype.equals("4")) {
            return UserSale.일반;
        }
        return null;
    }
}
