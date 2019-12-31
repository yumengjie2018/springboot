package com.example.service.service;

public interface IntefaceA {
    static void message(String msg){
        System.out.println("接口A的消息："+msg);
    }
    default void mess(){
        System.out.println("ceshiA");
    }
}
