package com.boco.jlappservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boco.jlappservice.mapper")
public class JLappserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JLappserviceApplication.class, args);
    }

}
