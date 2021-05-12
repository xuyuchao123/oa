package com.xyc.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

/**
 * Created by 1 on 2019/3/23.
 */
public class MyExecutionListener implements ExecutionListener
{

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception
    {
        if(delegateExecution.getEventName().equals("end"))
        {
            System.out.println("流程结束");
        }
    }
}
