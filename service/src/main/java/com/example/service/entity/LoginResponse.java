package com.example.service.entity;

import com.example.service.entity.response.Person;
import lombok.Data;

import java.util.List;

/**
 * title：LoginResponse
 * description:
 *
 * @author yumengjie
 * @date 2019/11/8 15:40
 */
@Data
public class LoginResponse {

    private List<Person> personList;
}