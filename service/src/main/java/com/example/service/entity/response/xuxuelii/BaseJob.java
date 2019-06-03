package com.example.service.entity.response.xuxuelii;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * title：BaseJob
 * description:
 *
 * @author yumengjie
 * @date 2019/4/19 13:52
 */


@Component
public abstract class BaseJob extends IJobHandler {
    @Value("${job.rerun:rerun}")
    private String rerun;
    @Value("${job.regex:,}")
    private String regex;
    public static final Logger logger = LoggerFactory.getLogger(BaseJob.class);

    public BaseJob() {
    }

    public ReturnT<String> execute(String param) {
        boolean reRun = false;
        Date date = new Date();
        String[] params = null;
        Map<String, Object> map = new HashMap();
        if (param != null && !param.trim().equals("")) {
            params = param.split(this.regex);
            reRun = params[0].equals(this.rerun);
        }

        try {
            if (reRun) {
                String executeTime = params[1];
                date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(executeTime);
                if (params.length > 2) {
                    param = param.split(this.regex, 3)[2];
                } else {
                    param = "";
                }

                logger.info("手动执行调度任务" + executeTime);
            }

            StringTokenizer entrys = new StringTokenizer(param, "^");

            while(entrys.hasMoreTokens()) {
                StringTokenizer items = new StringTokenizer(entrys.nextToken(), "'");
                map.put(items.nextToken(), items.hasMoreTokens() ? items.nextToken() : null);
            }

            logger.info("开始调度任务" + new Date());
            Result result = this.go(map, reRun, date);
            return this.convert(result);
        } catch (Exception var8) {
            var8.printStackTrace();
            logger.error("执行任务出错" + var8.getMessage());
            return FAIL;
        }
    }

    public abstract Result go(Map<String, Object> var1, Boolean var2, Date var3) throws Exception;

    private <T> ReturnT<T> convert(Result<T> result) {
        int code = result.getCode();
        String msg = result.getMsg();
        T t = result.getContent();
        ReturnT<T> returnT = new ReturnT(code, msg);
        returnT.setContent(t);
        return returnT;
    }
}
