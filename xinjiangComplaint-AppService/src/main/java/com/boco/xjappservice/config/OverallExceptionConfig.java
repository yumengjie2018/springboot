package com.boco.xjappservice.config;

/**
 * title：MyControllerAdvice
 * description:
 *
 * @author yumengjie
 * @date 2019/6/3 11:10
 */
import com.boco.xjappservice.entity.response.ResponseMessage2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @Author yumengjie
 * @Date  2019/6/3 14:05
 * @Description  统一异常处理
 **/
@ControllerAdvice
@Slf4j
public class OverallExceptionConfig {

    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseMessage2 errorHandler(Exception e) {
        return ResponseMessage2.Failed(e.toString());
    }
}