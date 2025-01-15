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

    public static UserSale getType(String usertype){
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
