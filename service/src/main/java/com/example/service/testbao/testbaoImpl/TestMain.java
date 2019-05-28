package com.example.service.testbao.testbaoImpl;

import com.example.service.testbao.Factory;
import com.example.service.testbao.INoodles;

/**
 * title：TestMain
 * description:
 *
 * @author yumengjie
 * @date 2019/3/12 17:25
 */

public class TestMain {

    public static void main(String[] args) {
        INoodles iNoodles=Factory.createNood(1);
        iNoodles.desc();
        System.out.println("11111111111111");
        Factory.createNood(2).desc();
        System.out.println("22222222222222");
        Factory.createNood(3).desc();
        System.out.println("333333333333333");
    }
}