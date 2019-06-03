package com.example.service.domainModel.test;

import java.util.ArrayList;
import java.util.List;

/**
 * title：WeaterSubject
 * description:
 *目标对象 它知道观察它的观察者
 * @author yumengjie
 * @date 2019/3/19 15:36
 */

public class Subject {

    private List<Observer> observerList =new ArrayList<Observer>();

    public void attach(Observer observer){
        observerList.add(observer);
    }
    public void detach(Observer observer) {
        observerList.remove(observer);
    }
    protected void notifyObserver(){
        for (Observer observer: observerList ) {
            observer.update(this);
        }
    }
}