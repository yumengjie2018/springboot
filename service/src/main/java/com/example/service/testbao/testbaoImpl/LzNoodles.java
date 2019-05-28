package com.example.service.testbao.testbaoImpl;

import com.example.service.testbao.INoodles;

/**
 * title：LzNoodles
 * description:
 *
 * @author yumengjie
 * @date 2019/3/12 17:17
 */

public class LzNoodles implements INoodles {

    @Override
    public String desc() {
        System.out.println("1111111111");
        return "兰州拉面，好吃。";
    }
}