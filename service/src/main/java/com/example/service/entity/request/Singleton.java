package com.example.service.entity.request;

/**
 * title：Singleton
 * description:
 *
 * @author yumengjie
 * @date 2019/3/12 14:40
 */

public class Singleton {

    private Singleton(){

    }

    private static Singleton single=new Singleton();

    //静态工厂方法
    public static  Singleton getInstance(){

        return single;
    }
}