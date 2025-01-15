package com.example.Kiosk;

public class UserCalculator {
    static double result;

    public double calculator(UserSale userSale){ // 소비자의 유형에 따라 할인을 계산하는 정보
        switch (userSale){
            case 국가유공자 -> result = result - (result/0.1); //국가유공자인 경우에는 10%의 할인
            case 군인 -> result = result - (result/0.05); // 군인인 경우에는 5%의 할인
            case 학생 -> result = result - (result/0.03); // 학생인 경우에는 3%의 할인
            case 일반 -> result = result; // 일반인 경우에는 0%의 할인
        }
        return result;
    }
}
