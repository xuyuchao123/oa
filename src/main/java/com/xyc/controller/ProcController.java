package com.xyc.controller;

import com.xyc.entity.ProcInstance;
import com.xyc.entity.SysUser;
import com.xyc.service.ProcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by 1 on 2019/4/26.
 */
@Controller
//@SessionAttributes("param") //该注解可以将指定的model参数放入session中
public class ProcController
{
    @Resource
    private ProcService procService;

    @RequestMapping(value = "/startProc",method = RequestMethod.POST)
    public String starProc(String procKey, String busKey, String userName, RedirectAttributes ra)
    {
//        Map<String, Object> map = new HashMap<String,Object>();
//        map.put("student", "小绿");
        String procInstId = procService.startProc(procKey,busKey,userName);
        ra.addFlashAttribute("procInstId",procInstId);
        return "redirect:/succProc";
    }
    //删除流程部署
    @RequestMapping(value="/deleteProcDefByName", method= RequestMethod.POST)
    public ModelAndView deleteProcDef(String procName)
    {
        procService.deleteProcDefByName(procName);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("procOperate");
        return mav;
    }

    //删除流程实例
    @RequestMapping(value="/deleteProcInst",method=RequestMethod.POST)
    public ModelAndView deleteProcInst(String procInstId, HttpSession session)
    {
        procService.deleteProcInst(procInstId);
        SysUser sysUser = (SysUser)session.getAttribute("loginUser");
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", sysUser);
        mav.setViewName( "procOperate");
        return mav;
    }

    //查找当前所有流程信息
    @RequestMapping(value="/findAllProcInst", method= RequestMethod.GET)
    public ModelAndView findAllProcInst(String procName)
    {
        List<ProcInstance> processInstanceList = procService.findAllProc();
        ModelAndView mav = new ModelAndView();
        mav.addObject("pIList",processInstanceList);
        mav.setViewName("viewProcInst");
        return mav;
    }

    //根据流程实例id获取对应的流程信息
    @RequestMapping(value="/findProcInstById", method= RequestMethod.GET)
    public void findProcInstById(String procInstId)
    {
        ProcInstance pi = procService.findProcInstById(procInstId,null);
    }


}
