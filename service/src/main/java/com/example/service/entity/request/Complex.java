package com.example.service.entity.request;

import java.util.Objects;

/**
 * title：Complex
 * description:
 *
 * @author yumengjie
 * @date 2019/11/13 15:21
 */

public final class Complex {

    private final double re;

    private final double im;

    public Complex(double re,double im){
        this.re=re;
        this.im=im;
    }
    public double realPart(){
        return re;
    }
    public double imageinaryPart(){
        return im;
    }
    public Complex plus(Complex c){
        return new Complex(re+c.re,im+c.im);
    }
    public Complex minus(Complex c){
        return new Complex(re-c.re,im-c.im);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 &&
                Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(re, im);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }
}