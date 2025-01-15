package com.example.Kiosk;

public class BadInputError extends Exception{
    public BadInputError(){
        super("없는 번호입니다. 재시도해주십시오.");
    }
}
