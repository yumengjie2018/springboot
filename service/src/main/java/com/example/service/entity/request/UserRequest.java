package com.example.service.entity.request;

import lombok.Data;

/**
 * title：UserRequest
 * description:
 *
 * @author yumengjie
 * @date 2019/11/29 15:44
 */
@Data
public class UserRequest {
    private int pageSize = 20;
    private int pageIndex = 1;
    private boolean isTotal = false;
}