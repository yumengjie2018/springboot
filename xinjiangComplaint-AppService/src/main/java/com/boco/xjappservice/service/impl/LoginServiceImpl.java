package com.boco.xjappservice.service.impl;

import com.boco.xjappservice.entity.domainModel.TokenEntity;
import com.boco.xjappservice.entity.domainModel.TokenOriginEntity;
import com.boco.xjappservice.entity.domainModel.UserEntity;
import com.boco.xjappservice.entity.request.LoginRequest;
import com.boco.xjappservice.entity.response.UserResponseEntity;
import com.boco.xjappservice.mapper.LoginMapper;
import com.boco.xjappservice.service.LoginService;
import com.boco.xjappservice.utility.PasswordEncoder;
import com.boco.xjappservice.utility.RsaUtil;
import com.boco.xjappservice.utility.TimeConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * title：LoginServiceImpl
 * description:
 *
 * @author yumengjie
 * @date 2019/3/14 10:18
 */
@Service
public class LoginServiceImpl implements LoginService {
    private  final String errorString = "用户名或密码错误";
    @Autowired
    private LoginMapper mapper;
    @Autowired
    private TokenService tokenService;
    @Override
    public UserResponseEntity originalLogin(LoginRequest request) throws Exception {
        UserEntity userEntity=mapper.getUser(request.getName());
        if (userEntity == null) {
            throw new Exception(errorString);
        }
        // 比对密码
        boolean isMatch = PasswordEncoder.matches(request.getPassword(), userEntity.getPassword());
        if (!isMatch) {
            throw new Exception(errorString);
        }
        // 清空密码
        userEntity.setPassword(null);
        String userId = userEntity.getEntity().getUserId();

        // 计算token
        TokenOriginEntity tokenOriginEntity = new TokenOriginEntity();
        tokenOriginEntity.setName(request.getName());
        tokenOriginEntity.setDeviceId(request.getDeviceId());
        tokenOriginEntity.setDate(TimeConvertor.getTodayTime());
        String token = tokenService.generateToken(tokenOriginEntity);

        // 保存token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        tokenService.saveToken(tokenEntity);

        // 返回模型
        userEntity.getEntity().setToken(token);
        //对时间戳加密
        try {
            userEntity.getEntity().setTimeSpan(RsaUtil.encrypt(Long.toString(request.getTimeSpan() + 1), request.getClientPublicKey()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return userEntity.getEntity();
    }
}