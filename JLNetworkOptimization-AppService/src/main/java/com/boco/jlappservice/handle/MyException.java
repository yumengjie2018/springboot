package com.boco.jlappservice.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * title：MyException
 * description:
 *
 * @author yumengjie
 * @date 2019/6/3 15:59
 */
@Data
public class MyException extends RuntimeException {

    @ApiModelProperty("执行状态 ")
    private int status ;

    public MyException(int status,String message){
        super(message);
        this.status=status;
    }

}