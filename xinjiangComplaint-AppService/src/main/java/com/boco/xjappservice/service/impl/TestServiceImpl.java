package com.boco.xjappservice.service.impl;

import com.boco.xjappservice.entity.response.ResponseStatus;
import com.boco.xjappservice.handle.MyException;
import com.boco.xjappservice.mapper.TestMapper;
import com.boco.xjappservice.service.TestService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * title：TestServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2019/3/13 9:45
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper mapper;
    @Override
    public Integer getTestOracle(String userId){
        if (userId==null){
            throw new MyException(ResponseStatus.Fail.getIndex(),ResponseStatus.Fail.getName());
        }
//        if(ll>k){
//            System.out.println("1111111");
//        }

        return mapper.getTestOracle();
    }
}