package com.example.service.domainModel.test;

/**
 * title：ConcreateObserver
 * description:
 *
 * @author yumengjie
 * @date 2019/3/19 15:39
 */

public class ConcreateObserver implements  Observer {
    //观察者状态
    private String observerState;
    @Override
    public void update(Subject subject) {
        observerState=((ConctrteSubject)subject).getSubjectState();
    }
}