package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectTest {

    //类变量
    private static String name;
    //实例变量
    private String ll="";
    @Test
    public void test1(){
        //局部变量
        String pwd;
        System.out.println("pppppppp");

        ArrayList<String> ssList=new ArrayList<>();
        ssList.add("张三");
        ssList.add("李四");
        ssList.add("王五");
        for (String ll:ssList) {
            System.out.println(ll+"11");
        }

        System.out.println("pppppppppp");
        ssList.forEach(ss-> System.out.println(ss+"kk"));
    }
    @Test
    public static void main(String args[]) throws Exception {
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        Arrays.sort(array);

        printArray("数组排序结果为", array);
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素 2  在第 " + index + " 个位置");
    }
    @Test
    public static void printArray(String message, int array[]) {
        System.out.println(message
                + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
