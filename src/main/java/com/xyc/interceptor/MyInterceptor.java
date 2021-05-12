package com.xyc.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by 1 on 2019/5/15.
 */
public class MyInterceptor implements HandlerInterceptor
{

    //在调用目标处理方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
    {
        if(o instanceof HandlerMethod)
        {
            HandlerMethod handlerMethod = (HandlerMethod)o;
            Object bean = handlerMethod.getBean();
            Method method = handlerMethod.getMethod();
            System.out.println(bean.getClass() + " " + method.getName() + " " + method.getParameterTypes());
        }
        return true;    //返回true表示继续执行下一个拦截器或者目标处理方法， false表示不再调用
    }

    //在调用目标处理方法之后，在视图渲染之前执行，可以对视图模型进行修改
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
    {
        System.out.println("posthandle");
    }

    //在渲染视图之后执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
    {
        System.out.println("afterCompletion");
    }
}
