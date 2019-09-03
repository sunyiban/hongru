package com.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @autor sunyiban
 * @date 2019/9/3 11:31
 * @descrpition
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (!handlerMethod.hasMethodAnnotation(AuthRequired.class)) {
            return true;
        }

        AuthRequired auth = handlerMethod.getMethodAnnotation(AuthRequired.class);
        if (auth.value() == AuthType.LOGIN) {
            request.setAttribute("userId", 12391);
            return true;
        }

        response.getWriter().write("this is the authinterceptor end");
        return false;
    }
}
