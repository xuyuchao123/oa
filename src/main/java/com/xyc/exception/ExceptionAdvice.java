package com.xyc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by 1 on 2019/5/15.
 * 异常处理类
 */
@ControllerAdvice       //表明该类是一个异常处理通知
public class ExceptionAdvice
{
    @ExceptionHandler(NullPointerException.class)       //表明该方法处理空指针异常
    public String nullPointer(Exception e)
    {
        System.out.println("发生空指针异常");
        System.out.println(e.getClass().getName() + e.getMessage());
        return "exception/nullPointer";
    }
}
