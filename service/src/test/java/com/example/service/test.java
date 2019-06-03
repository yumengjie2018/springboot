package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * title：test
 * description:
 *
 * @author yumengjie
 * @date 2019/5/23 15:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
private  static  int i;
@Test
public void ll(){
        System.out.println(i+"yyyyyyyyyyyy");
        int[] p =new int[10];
        for (int i=0;i<p.length;i++){
            System.out.println(i+"IIIIIIII++++++++++++");
        }
    System.out.println("-------------------------------------");
    p =new int[10];
    for (int i=0;i<p.length;++i){
        System.out.println(i+"IIIIIIII++++++++++++");
    }
    int j=0;
    j=j++;
    System.out.println(j+"-----------");


    }

}