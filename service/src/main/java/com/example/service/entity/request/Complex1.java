package com.example.service.entity.request;

/**
 * title：Complex1
 * description:
 *
 * @author yumengjie
 * @date 2019/11/13 15:46
 */

public class Complex1 {

    private final  double re;

    private final double im;

    private Complex1(double re,double im){
        this.re=re;
        this.im=im;
    }
    public static Complex1 valueOf(double re,double im){
        return new Complex1(re,im);
    }
}