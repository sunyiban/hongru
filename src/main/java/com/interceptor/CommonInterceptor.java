package com.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @autor sunyiban
 * @date 2019/8/21 15:30
 * @descrpition
 */
@Configuration
public class CommonInterceptor {

    @Configuration
    protected static class InterceptorConfiguration implements WebMvcConfigurer {
        @Autowired
        private RequestInterceptor requestInterceptor;

        @Autowired
        private AuthInterceptor authInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(requestInterceptor);
            registry.addInterceptor(authInterceptor);
        }
    }

}
