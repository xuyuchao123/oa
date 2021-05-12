package com.xyc.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * Created by 1 on 2019/3/15.
 */
public class AssigneeListener implements TaskListener
{

    @Override
    public void notify(DelegateTask delegateTask)
    {
        /**
         * 任务的执行人可以动态的赋值,在生成该节点任务时会触发该监听器设置任务执行人
         *      方法一：（必须在web环境） WebApplicationContext ac = WebApplicationContextUtils
         *       	.getWebApplicationContext(ServletActionContext.getServletContext());
         xxxxService xxxxService = (xxxxService) ac.getBean("xxxxService");
         方法二：通过JDBC来进行数据库操作
         */
//        动态分配（这里是从上一节点中的task变量的map中获取，只要流程没有结束，所有的变量都是可以获取）
//        String value = (String)delegateTask.getVariable("aaa");
//        delegateTask.setAssignee(value);
        //静态分配(用于确定该执行人就只有一种固定情况)
        delegateTask.setAssignee("班主任1");
    }
}
