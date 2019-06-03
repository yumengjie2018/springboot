package com.example.service.entity.response.xuxuelii;

import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * title：TestSc
 * description:
 *
 * @author yumengjie
 * @date 2019/4/19 14:09
 */
@JobHandler(value = "TestSc")
@Component
@Slf4j
public class TestSc extends BaseJob {


    @Override
    public Result go(Map<String, Object> map, Boolean aBoolean, Date date) {
        try {
            if (null == date) {
                log.error("--------------->>>>>>>>调度开始时间为空!");
                return Result.FAILE;
            }
            System.out.println("1111111111111111111111");
            System.out.println("1111111111111111111111");
            System.out.println("1111111111111111111111");
            System.out.println("1111111111111111111111");

        } catch (Exception e) {
            log.error("--------------->>>>>>>>调度异常!");
            e.printStackTrace();
            return Result.FAILE;
        }
        return Result.OK;
    }
}