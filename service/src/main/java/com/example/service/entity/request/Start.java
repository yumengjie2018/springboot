package com.example.service.entity.request;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * title：Start
 * description:
 *
 * @author yumengjie
 * @date 2019/3/26 17:49
 */
@Log
@Component
public class Start {
    @Value("${spring.application.name}")
    private static String applicationName;


    public static void start() {
//        Start start=new Start();
//        String applicationName=start.applicationName;
        StringBuilder logg = new StringBuilder();
        logg.append("\n************************************************\n");
        logg.append("**\n");
        logg.append("**                     项目启动成功                                \n");
        logg.append("**\n");
        logg.append("**\n");
        logg.append("**   启动时间:" + (new DateTime(new Date())).toString() + "\n");
        logg.append("**   项目名称:" + applicationName + "\n");
        logg.append("**\n");
        logg.append("************************************************\n");
        log.info(logg.toString());
    }

}