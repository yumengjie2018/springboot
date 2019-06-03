package com.example.service.domainModel.test;

/**
 * title：ConctrteWeaterSubject
 * description:
 *
 * @author yumengjie
 * @date 2019/3/19 15:37
 */

public class ConctrteSubject extends Subject {

    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObserver();
    }
}