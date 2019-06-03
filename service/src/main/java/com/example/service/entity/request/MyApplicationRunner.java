package com.example.service.entity.request;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * title：MyApplicationRunner
 * description:
 *
 * @author yumengjie
 * @date 2019/3/26 16:44
 */

@Component
@Order(2)     //如果多个自定义的 ApplicationRunner  ，用来标明执行的顺序
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("-------------->" + "项目启动，now=" + new Date());
        System.out.println("获取到的参数： " + applicationArguments.getOptionNames());
        System.out.println("获取到的参数： " + applicationArguments.getNonOptionArgs());
        System.out.println("获取到的参数： " + applicationArguments.getSourceArgs());
//        myTimer();
         }

        public static void myTimer () {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("------定时任务--------");
                }
            }, 0, 2000);
        }
    }

