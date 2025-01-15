package com.example.Kiosk;

public class BadInputError extends Exception{
    public BadInputError(){
        super("없는 번호입니다. 재시도해주십시오.");
    } // 잘못된 입력 시 예외처리를 해버림
}
