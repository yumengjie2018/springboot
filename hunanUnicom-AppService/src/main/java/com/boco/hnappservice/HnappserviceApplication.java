package com.boco.hnappservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.boco.hnappservice.mapper")
public class HnappserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HnappserviceApplication.class, args);
    }

}
