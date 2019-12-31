package com.example.service.entity;

/**
 * title：AAA
 * description:
 *
 * @author yumengjie
 * @date 2019/12/31 11:09
 */

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
@Data
public class AAA {

        @Autowired
        private BBB b;


        public AAA() {
            System.out.println("此时b还未被注入: b = " + b);
        }

        @PostConstruct
        private void init() {
            System.out.println("@PostConstruct将在依赖注入完成后被自动调用: b = " + b);
        }

}