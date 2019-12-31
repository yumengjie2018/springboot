package com.example.service.service.impl;

import com.example.service.service.IntefaceA;

/**
 * title：IntefaceImpl
 * description:
 *
 * @author yumengjie
 * @date 2019/12/2 15:25
 */

public class IntefaceImpl implements IntefaceA {
   public void test(){
       IntefaceA.message("");
       IntefaceA.super.mess();
   }
}