package com.example.service.domainModel.observer;

import com.example.service.domainModel.test.ConctrteSubject;
import com.example.service.domainModel.test.Subject;

/**
 * title：ConcreateObserver
 * description:
 *
 * @author yumengjie
 * @date 2019/3/19 15:39
 */

public class ConcreateObserver implements Observer {
    //观察者状态
    private String observerName;

    private String weaterContent;

    private String remindThing;
    @Override
    public void update(Subject subject) {
        weaterContent=((ConctrteSubject)subject).getSubjectState();
        System.out.println(observerName+"收到了"+weaterContent+','+remindThing);
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getWeaterContent() {
        return weaterContent;
    }

    public void setWeaterContent(String weaterContent) {
        this.weaterContent = weaterContent;
    }

    public String getRemindThing() {
        return remindThing;
    }

    public void setRemindThing(String remindThing) {
        this.remindThing = remindThing;
    }
}