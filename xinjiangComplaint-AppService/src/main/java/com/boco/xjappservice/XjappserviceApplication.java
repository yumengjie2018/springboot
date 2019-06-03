package com.boco.xjappservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boco.xjappservice.mapper")
public class XjappserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XjappserviceApplication.class, args);
    }

}
