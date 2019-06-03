package com.example.service.domainModel.observer;

import com.example.service.domainModel.test.Subject;

/**
 * @Author yumengjie
 * @Date  2019/3/19 15:38
 * @Description
 **/
public interface Observer {
    public void update(Subject subject);
}
