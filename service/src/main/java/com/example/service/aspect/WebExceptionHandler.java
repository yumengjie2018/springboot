package com.example.service.aspect;

import com.example.service.entity.response.ResponseMessage;
import lombok.extern.java.Log;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * title：WebExceptionHandler
 * description:
 *
 * @author yumengjie
 * @date 2019/3/26 9:45
 */
@ControllerAdvice
@ResponseBody
@Log
public class WebExceptionHandler {


    @ExceptionHandler
    public ResponseMessage happenException(Exception e) {
        log.info("发生异常");
        ResponseMessage response = new ResponseMessage();
        response.setStatus(0);
        response.setMessage("后台异常，请联系管理员");
        return response;

    }
}

