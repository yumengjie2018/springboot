package com.example.service.TestLambda;

import com.example.service.domainModel.Complex;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

@RunWith(SpringRunner.class)
@SpringBootTest
public final class TestLambda1 {

    @Value("${stati:statics}")
    private String basePath ;
    

//    private final short areaCode,prefix,lineNum;





    @Test
    public  void test1(){

        List<String> list= new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("马六");
        System.out.println(list.get(0));

        list.forEach(li-> System.out.println(li+"干什么"));
//        Runnable no=() -> System.out.println("hello");

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

}
