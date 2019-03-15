package com.example.service.testbao;

import com.example.service.testbao.testbaoImpl.GanKouNoodles;
import com.example.service.testbao.testbaoImpl.LzNoodles;
import com.example.service.testbao.testbaoImpl.PaoNoodles;

/**
 * title：Factory
 * description:
 *
 * @author yumengjie
 * @date 2019/3/12 17:20
 */

public class Factory {

    private static final int TYPE_LZ=1;

    private static final int TYPE_PAO=2;

    private static final int TYPE_GANKOU=3;


    public static INoodles createNood(int type){
        switch (type){
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PAO:
                return new PaoNoodles();
            case TYPE_GANKOU:
                default:
                return new GanKouNoodles();
        }
    }

    public static void main(String[] args) {
        INoodles iNoodles=Factory.createNood(Factory.TYPE_LZ);
        String out=iNoodles.desc();
        System.out.println(out+"香");
        System.out.println("22222222222");
        System.out.println(Factory.createNood(Factory.TYPE_GANKOU).desc());
        System.out.println(Factory.createNood(Factory.TYPE_PAO).desc());
    }
}