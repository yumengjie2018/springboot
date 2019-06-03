package com.example.service.domainModel.observer;

/**
 * title：Client
 * description:
 *
 * @author yumengjie
 * @date 2019/3/19 16:06
 */

public class Client {

    public static void main(String[] args) {
        //创建目标
        ConctrteWeaterSubject weater=new ConctrteWeaterSubject();
        //创建观察者
        ConcreateObserver observerGril=new ConcreateObserver();
        observerGril.setObserverName("黄明的女朋友");
        observerGril.setRemindThing("是我们的额第一次约会");

        ConcreateObserver observerMum=new ConcreateObserver();
        observerMum.setObserverName("老妈");
        observerMum.setRemindThing("买东西");
        //注册观察者
        weater.attach(observerGril);
        weater.attach(observerMum);

        //目标发布天气
        weater.setWeaterState("明天天气明朗");
    }
}