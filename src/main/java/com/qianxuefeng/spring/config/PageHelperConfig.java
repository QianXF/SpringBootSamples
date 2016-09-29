package com.qianxuefeng.spring.config;

import com.github.pagehelper.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
//@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class PageHelperConfig {

    private static Log log = LogFactory.getLog(PageHelperConfig.class);
    @Bean
    public PageHelper pageHelper() {
        log.info("注册MyBatis分页插件PageHelper");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}  