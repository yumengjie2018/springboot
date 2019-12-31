package com.example.service.TestLambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * title：LambdaStream
 * description:
 *
 * @author yumengjie
 * @date 2019/8/19 14:07
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaStream {

    @Test
    public void stream(){
        Random random=new Random();
        random.ints().limit(10).forEach(System.out::println);
        List<Integer> numbers=Arrays.asList(1,2,3,3,4,5,6,7);
        List<Integer> squaresList=numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());


        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("列表"+strings);
        strings.stream().filter(string->string.isEmpty()).count();


    }

}