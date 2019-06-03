package com.example.service.entity.request;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * title：FrameworkMicroserviceApplication
 * description:
 *
 * @author yumengjie
 * @date 2019/3/26 17:42
 */

public class FrameworkMicroserviceApplication {
    private Logger logger = LoggerFactory.getLogger(FrameworkMicroserviceApplication.class);
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String longDateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static FrameworkMicroserviceApplication application;
    @Value("${spring.application.name}")
    private String applicationName;

    public String getApplicationName() {
        return this.applicationName;
    }

    public FrameworkMicroserviceApplication() {
        application = this;
    }

    public static FrameworkMicroserviceApplication getApplication() {
        return application;
    }

    public void start() {
        StringBuilder log = new StringBuilder();
        log.append("\n************************************************\n");
        log.append("**\n");
        log.append("**                     项目启动成功                                \n");
        log.append("**\n");
        log.append("**\n");
        log.append("**   启动时间:" + (new DateTime(new Date())).toString() + "\n");
        log.append("**   项目名称:" + this.applicationName + "\n");
        log.append("**\n");
        log.append("************************************************\n");
        this.logger.info(log.toString());
    }

//    public <T> T getBean(Class<T> clazz) {
//        return SpringContextUtil.getBean(clazz);
//    }
//
//    public String getBean(String key) {
//        return EnvironmentUtil.getProperty(key);
//    }
//
//    @Bean
//    @LoadBalanced
//    RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
//
//    @Bean
//    public SSOClient getSSO() {
//        return new SSOClient();
//    }
//
//    @Bean
//    public Converter<String, Date> addNewConvert() {
//        return new Converter<String, Date>() {
//            public Date convert(String source) {
//                if (StringUtils.isBlank(source)) {
//                    return null;
//                } else {
//                    source = source.trim();
//
//                    try {
//                        if (source.contains("-")) {
//                            Date dtDate = null;
//                            SimpleDateFormat formatter;
//                            if (source.contains(":")) {
//                                try {
//                                    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//                                    dtDate = formatter.parse(source);
//                                } catch (Exception var5) {
//                                    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                                    dtDate = formatter.parse(source);
//                                }
//                            } else {
//                                formatter = new SimpleDateFormat("yyyy-MM-dd");
//                                dtDate = formatter.parse(source);
//                            }
//
//                            return dtDate;
//                        }
//
//                        if (source.matches("^\\d+$")) {
//                            Long lDate = new Long(source);
//                            return new Date(lDate);
//                        }
//                    } catch (Exception var6) {
//                        throw new RuntimeException(String.format("parser %s to Date fail", source));
//                    }
//
//                    throw new RuntimeException(String.format("parser %s to Date fail", source));
//                }
//            }
//        };
//    }
//}
}