package com.xyc.security;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 2020/4/1.
 */
public class MyAuthenticationFailureHandlerImpl implements AuthenticationFailureHandler
{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
    {
        System.out.println("failure");
    }
}
