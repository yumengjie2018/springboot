package com.example.service.domainModel.observer;

/**
 * title：ConctrteWeaterSubject
 * description:
 *
 * @author yumengjie
 * @date 2019/3/19 15:37
 */

public class ConctrteWeaterSubject extends WeaterSubject {

    private String weaterState;

    public String getWeaterState() {
        return weaterState;
    }

    public void setWeaterState(String weaterState) {
        this.weaterState = weaterState;
        this.notifyObserver();
    }

}