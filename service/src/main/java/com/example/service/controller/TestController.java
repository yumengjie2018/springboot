//package com.example.service.controller;
//
//import com.example.service.entity.Gril;
//import com.example.service.entity.response.ResponseMessage;
//import com.example.service.mapper.ProductCategoryRepository;
//import com.example.service.service.TestService;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * title：TestController
// * description:表单验证
// *
// * @author yumengjie
// * @date 2018/12/28 15:25
// */
//@RestController
//@RequestMapping(value = "/api/test")
//@Api(tags = "测试")
//public class TestController {
//    @Autowired
//    private TestService service;
//    @Autowired
//    private ProductCategoryRepository mapper;
//    @GetMapping("/t")
//    public ArrayList<Gril> getGril(@Valid Gril gril, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//            return new ArrayList<>();
//        }
//        System.out.println("ljjjjjjj");
//        return service.getGril(gril);
//    }
//    @GetMapping("/getPerson")
//    public ResponseMessage<Gril> getPerson(Gril gril){
//        ResponseMessage<Gril> response=new ResponseMessage<>();
//        //用静态方法封装
//        response.setMessage("成功");
//        response.setStatus(0);
//        return response;
//    }
//    @PostMapping( "/addPerson")
//    public Gril addPerson(Gril gril) {
//        return mapper.save(gril);
//    }
//    @DeleteMapping("/deletePerson")
//    public boolean deletePerson(Gril gril) {
//        return true;
//    }
//    @GetMapping("/getAllPerspon")
//    public List<Gril> getAll(){
//        return mapper.findAll();
//    }
//
//}