package com.boco.hnappservice.service.impl;

import com.boco.hnappservice.mapper.TestMapper;
import com.boco.hnappservice.service.TestService;
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
    public int getTestOracle() {
        return mapper.getTestOracle();
    }
}