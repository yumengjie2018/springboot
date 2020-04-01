package com.boco.jlappservice.service.impl;

import com.boco.jlappservice.entity.domainModel.TokenEntity;
import com.boco.jlappservice.entity.domainModel.TokenOriginEntity;
import com.boco.jlappservice.entity.domainModel.UserEntity;
import com.boco.jlappservice.entity.request.LoginRequest;
import com.boco.jlappservice.entity.request.TerminalRecordRequest;
import com.boco.jlappservice.entity.response.ResponseMessage2;
import com.boco.jlappservice.entity.response.ResponseStatus;
import com.boco.jlappservice.entity.response.UserResponseEntity;
import com.boco.jlappservice.entity.response.VerifyTokenResponse;
import com.boco.jlappservice.handle.MyException;
import com.boco.jlappservice.mapper.LoginMapper;
import com.boco.jlappservice.service.LoginService;
import com.boco.jlappservice.utility.PasswordEncoder;
import com.boco.jlappservice.utility.TimeConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * title：LoginServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2019/3/14 10:18
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper mapper;
    @Autowired
    private TokenService tokenService;


    @Override
    public UserResponseEntity login(LoginRequest request) {
        UserResponseEntity response=new UserResponseEntity();
        UserEntity userEntity = mapper.getUser(request.getName());
        if (userEntity == null) {
            throw new MyException(ResponseStatus.Fail.getIndex(),"用户名不存在");
        }
        // 比对密码
        boolean isMatch = PasswordEncoder.matches(request.getPassword(), userEntity.getPassword());
        if (!isMatch) {
            throw new MyException(ResponseStatus.Fail.getIndex(),"密码错误");
        }
        // 清空密码
        userEntity.setPassword(null);
        //获取用户id
        String userId = userEntity.getEntity().getUserId();
        //创建用户token
        return creatToken(request, response, userEntity, userId);
    }

    //创建用户token
    public UserResponseEntity creatToken(LoginRequest request,
                                                         UserResponseEntity response, UserEntity userEntity, String userId) {
        // 计算token
        TokenOriginEntity tokenOriginEntity = new TokenOriginEntity();
        tokenOriginEntity.setName(request.getName());
        tokenOriginEntity.setDeviceId(request.getDeviceId());
        // 获取时间
        String time = TimeConvertor.getTodayTime();
        tokenOriginEntity.setDate(time);
        String token = tokenService.generateToken(tokenOriginEntity);
        // 保存token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        //没有插入
        tokenService.saveToken(tokenEntity);

        // 返回模型
        userEntity.getEntity().setToken(token);
        return userEntity.getEntity();
    }

}