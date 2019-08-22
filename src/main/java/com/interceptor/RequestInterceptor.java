package com.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor sunyiban
 * @date 2019/8/21 15:17
 * @descrpition 请求信息打印
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    ObjectMapper objectMapper;

    public static ThreadLocal<Long> startTime = new ThreadLocal();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime.set(System.currentTimeMillis());
        Method method = ((HandlerMethod) handler).getMethod();
        String pathInfo = request.getRequestURI();
        String methodName = method.getDeclaringClass().getName() + "." + method.getName();
        String requestMethod = request.getMethod();
        Map<String, Object> requestParam = new HashMap<>();
        request.getParameterMap().forEach((key, value) -> {
            requestParam.put(key, value[0]);
        });

        System.out.println("请求地址：" + pathInfo + ";请求方式：" + requestMethod + ";方法名：" + methodName + ";参数：" + objectMapper.writeValueAsString(requestParam));
        return true;
    }
}
