package com.example.service.service.impl;

import com.example.service.config.InterfaceConfig;
import com.example.service.entity.response.MabitsResponse;
import com.example.service.service.MabitsService;
import org.springframework.stereotype.Service;

/**
 * title：MabitsServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2019/2/13 9:42
 */
@Service
public class MabitsServiceImpl implements MabitsService {

    @Override
    public MabitsResponse getMabits() {

        MabitsResponse mabitsResponse=new MabitsResponse();
        mabitsResponse.setAddress("西安");
        mabitsResponse.setName("凤栖原");
        mabitsResponse.setName(InterfaceConfig.NAME);
        return mabitsResponse;
    }
}