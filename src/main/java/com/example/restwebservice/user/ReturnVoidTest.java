package com.example.restwebservice.user;

public class ReturnVoidTest {
    public String returnMethod(String paramValue) { // String return 메소드
        String returnValue = paramValue; // 값 넣어서 보내주면 returnValue에 넣어 초기화

        return returnValue; // 값 반환
    }

    public void voidMethod() { // void 메소드
        System.out.println("no return"); // void 메소드는 return 값이 없음
    }

    public static void main(String[] args) {
        ReturnVoidTest rvt = new ReturnVoidTest(); // 객체화

        System.out.println(rvt.returnMethod("call")); // returnMethod 호출
        rvt.voidMethod();			     // voidMethod 호출
    }

}