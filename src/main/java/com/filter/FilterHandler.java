package com.filter;

import com.config.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @autor sunyiban
 * @date 2019/9/2 10:13
 * @descrpition
 */
@Configuration
public class FilterHandler {

    @Autowired
    private SystemConfig systemConfig;

    @Bean
    // 只有true的时候过滤器才会生效
    @ConditionalOnProperty(name = "system.auth.enable", havingValue = "true", matchIfMissing = true)
    public FilterRegistrationBean getFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SignFilter(systemConfig));
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("sign filter");
        return filterRegistrationBean;
    }

}
