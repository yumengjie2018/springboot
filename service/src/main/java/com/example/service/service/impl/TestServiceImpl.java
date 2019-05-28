package com.example.service.service.impl;

import com.example.service.entity.Gril;
import com.example.service.service.TestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * title：TestServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2018/12/28 15:29
 */
@Service
public class TestServiceImpl implements TestService {

    public ArrayList<Gril> getGril(Gril gril) {
        ArrayList<Gril> grilList=new ArrayList<>();
        if(gril.getAge()!=null){
            Gril ll=new Gril();
            ll.setAge(gril.getAge());
            ll.setSize("B");
            grilList.add(ll);
        }
        return grilList;
    }
}