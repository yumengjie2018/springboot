package com.example.service;

import com.example.service.component.LoginResponseComponent;
import com.example.service.config.RedisTemplateService;
import com.example.service.entity.AAA;
import com.example.service.entity.LoginResponse;
import com.example.service.entity.response.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * title：test
 * description:
 *
 * @author yumengjie
 * @date 2019/5/23 15:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class test {
private  static  int i;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplateService redisTemplateService;

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
        @Test
        public void test()  {

//            // 保存字符串
//            stringRedisTemplate.opsForValue().set("aaa", "111");

//            AAA aaa=new AAA();
//            aaa.getB();
            ArrayList<String> user=LoginResponseComponent.getUser();
            user.forEach(s -> System.out.println(s));
            System.out.println("总数"+user.size());
        }

    @Test
    public void redisTest(){


//        User user = new User();
//        user.setId("11");
//        user.setUsername("test11");
//        user.setPassword("hello redis");

        LoginResponse user =getPersonList();

//        redisTemplateService.update("user",User.class);
        boolean re =redisTemplateService.delete("user");

        redisTemplateService.set("user",user);

        LoginResponse us = redisTemplateService.get("user",LoginResponse.class);
        List<Person> personList=us.getPersonList();
        for (Person person:personList) {
            System.out.println("id"+person.getId());
            System.out.println("name"+person.getName());
            System.out.println("age"+person.getName());
            System.out.println("-----------------------------------------------");
        }
        System.out.println(us.getPersonList().toString());
    }




//    @Test
//    public void personTest(){
//
//        List<Person> list = getPersonList();
////清空
//        while (redisTemplate.opsForList().size("oowwoo") > 0){
//            redisTemplate.opsForList().leftPop("oowwoo");
//        }
////存储
//        redisTemplate.opsForList().rightPushAll("oowwoo", list);
//
////取出
//        List<Person> oowwoo = redisTemplate.opsForList().range("oowwoo", 0, -1);
//        log.info(">>>>>>>>>>>>>>>list = {}", oowwoo.toString());
//        Iterator<Person> it = oowwoo.iterator();
//        while(it.hasNext()){
//            Person p = it.next();
//            log.info("person = {}", p.toString());
//        }
//
//}

    private LoginResponse getPersonList() {
        LoginResponse loginResponse=new LoginResponse();
        Person p1 = new Person();
        p1.setId(1L);
        p1.setName("张一");
        p1.setAge(11);

        Person p2 = new Person();
        p2.setId(2L);
        p2.setName("张二");
        p2.setAge(22);

        Person p3 = new Person();
        p3.setId(3L);
        p3.setName("张三");
        p3.setAge(33);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        loginResponse.setPersonList(list);
        return loginResponse;
    }

}