package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.merge("1",1,(count,incr)->count+incr);
        map.merge("1",1,Integer::sum);
    }
    @Test
    public static void main(String args[]) throws Exception {
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        Arrays.sort(array);
//        printArray("数组排序结果为", array);
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素 2  在第 " + index + " 个位置");
        Comparator<String> comparator = (String o1, String o2) -> o1.compareTo(o2);
        Stream<String> stream=Stream.of("a","b");
        List<String> list=stream.collect(Collectors.toList());

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello thread");
            }
        });

        Thread thread1=new Thread(()-> System.out.println("Hello thread"));


    }
    @Test
    public  void test1111() {

        List<String> data = new ArrayList<>();
        data.add("张三");
        data.add("李四");
        data.add("王三");
        data.add("马六");

        data.stream()
                .filter(x -> x.length() == 2)
                .map(x -> x.replace("三","五"))
                .sorted()
                .filter(x -> x.contains("五"))
                .forEach(System.out::println);
//
//        System.out.println(message
//                + ": [length: " + array.length + "]");
//        for (int i = 0; i < array.length; i++) {
//            if(i != 0){
//                System.out.print(", ");
//            }
//            System.out.print(array[i]);
//        }
//        System.out.println();
    }
}
