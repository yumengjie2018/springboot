package com.example.service.TestLambda;

import com.example.service.domainModel.Complex;
import com.example.service.service.IntefaceA;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.method.P;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public final class TestLambda1 {

    @Value("${stati:statics}")
    private String basePath ;
    

//    private final short areaCode,prefix,lineNum;





    @Test
    public  void test1(){

//        List<String> list= new ArrayList<String>();
//        list.add("张三");
//        list.add("李四");
//        list.add("王五");
//        list.add("马六");
//        System.out.println(list.get(0));
//
//        list.forEach(li-> System.out.println(li+"干什么"));
////        Runnable no=() -> System.out.println("hello");
//
//        Complex complex=new Complex(2,3);
//
//       Complex c=new Complex(5,3);
//       Complex  cc=c.plus(complex);
//        System.out.println(cc.toString()+"11111111111111111111");
        List<String> data = new ArrayList<>();
        data.add("张三");
        data.add("李四");
        data.add("王三");
        data.add("马六");
                        data.parallelStream().forEach(x-> System.out.println(x));
        System.out.println("--------------------");
        data.stream().forEach(System.out::println);
        System.out.println("+++++++++++++++++");
        List<String> kk=data.stream().sorted().limit(2).collect(Collectors.toList());
        kk.forEach(System.out::println);
        List<String> ll=data.stream()
                .filter(x -> x.length() == 2)
                .map(x -> x.replace("三","五"))
                .sorted()
                .filter(x -> x.contains("五")).collect(Collectors.toList());
        ll.forEach(string-> System.out.println(string));
        for (String string:ll) {
            System.out.println(string);
        }
        ll.stream().sorted().forEach(s -> System.out.println(s));
//                .forEach(System.out::println);
      Thread thread=new Thread(()->{ System.out.println(1); });
      thread.start();

        LocalDateTime   currentTime=LocalDateTime.now();

        System.out.println("当前时间"+currentTime);
        LocalDate localDate=currentTime.toLocalDate();
        System.out.println("当前日期"+localDate);

        Thread tt=new Thread(()-> System.out.println("111"));
    }
    @Test
    public  void test2(){

        Complex ll=new Complex(0,0);
        Complex y=ll.minus(ll);
        ll.equals(0);
        ll.hashCode();
        System.out.println(basePath);
        System.out.println("-------------------");

        String dir="D://yumengjie/ll";
        String dirs="ll"+File.separator+"yy";
        File dirFile= new File(dir);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }

    }
    @Test
    public void test3(){

        Integer[] testint = {1,2,3,4};
        Optional<Integer> sumAll=Stream.of(testint).reduce(Integer::sum);
        System.out.println(sumAll.filter(x->x>7));
    }

    @Test
    public void reduceTest() {
        String testS[]={"hello"," ","world"," ","!"};
        Optional<String> sumAll = Stream.of(testS).reduce(String::concat);
        System.out.println(sumAll.flatMap(x-> Optional.ofNullable(null)));//Optional.empty
        System.out.println(sumAll.flatMap(x-> Optional.of(x.toUpperCase())));//Optional[HELLO WORLD !]
        System.out.println(sumAll.get());
    }
    public static void main(String[] args) {
        Vector v =new Vector(3,2);
        System.out.println(v.size()+","+v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));

        System.out.println(v.size()+","+v.capacity());
        v.addElement(5.45);
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        System.out.println("First element: " +
                (Integer)v.firstElement());
        System.out.println("Last element: " +
                (Integer)v.lastElement());
        if(v.contains(new Integer(3)))
            System.out.println("Vector contains 3.");
        // enumerate the elements in the vector.
        Enumeration vEnum = v.elements();
        System.out.println("\nElements in vector:");
        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
        System.out.println();
    }

    public static void main1(String[] args) {
        Path dictionary= Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        "Hello world!".chars().forEach(System.out::println);
    }
}
