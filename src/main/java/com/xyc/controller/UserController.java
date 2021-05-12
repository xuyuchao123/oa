package com.xyc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyc.entity.SysUser;
import com.xyc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 2019/3/31.
 * 实现Controller接口的方式创建控制器
 */
@Controller
public class UserController
{
    protected static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Resource
    private UserService userService;

    public UserController() {
    }

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public ModelAndView toLogin()
    {
        LOGGER.debug("debug日志");
        LOGGER.info("info日志");
        LOGGER.warn("warn日志");
        LOGGER.error("error日志");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checkLogin(String username, String password, HttpSession session)
    {
        System.out.println(username);
//        SysUser sysUser = userService.login(userName, password);
        ModelAndView mv = new ModelAndView();
        SysUser sysUser = new SysUser();
        sysUser.setUserNum(username);
        sysUser.setPassword(password);
        session.setAttribute("loginUser", sysUser);
        Map<String,Object> resMap = new HashMap<String,Object>();
        resMap.put("code",0);
//        return "redirect:/procOperate";
        return resMap;
    }

    //修改密码 BCryptPasswordEncoder加密
    @RequestMapping(value="/update",method= RequestMethod.GET)
    public void updateSysUser(String userName)
    {
        userService.updateUser(userName,"1");
    }



    //通用跳转方法
    @RequestMapping(value="/{viewName}",method= RequestMethod.GET)
    public String toProcOperate(@PathVariable("viewName") String viewName,ModelMap modelMap)
    {
//        System.out.println(modelMap.get("procInstId"));
        return viewName;
    }

}
