package com.example.service.component;

import com.example.service.mapper.LoginReponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.Session;
import java.util.ArrayList;

/**
 * title：LoginResponseComponent
 * description:
 *
 * @author yumengjie
 * @date 2019/12/31 14:56
 */
@Component
public class LoginResponseComponent {

    private  static LoginReponseMapper mapper;
    @Autowired
    public LoginResponseComponent(LoginReponseMapper mapper){
        this.mapper=mapper;
    }
//    @PostConstruct
//    public void init(){
//
//    }

    public static ArrayList<String> getUser(){

        ArrayList<String> user = mapper.getUser();


        return user;
    }

}
