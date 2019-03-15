package com.example.service.entity.request;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * title：ComponentTest
 * description:
 *
 * @author yumengjie
 * @date 2019/3/11 10:16
 */

@Component
public class ComponentTest implements CommandLineRunner {

    public static String testName;
    @Override
    public void run(String... arg0) throws Exception {

        System.out.println("项目启动成功");
        }
}