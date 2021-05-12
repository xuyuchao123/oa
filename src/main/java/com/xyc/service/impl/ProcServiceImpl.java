package com.xyc.service.impl;

import com.xyc.entity.ProcInstance;
import com.xyc.service.ProcService;
import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 2019/4/30.
 */
@Service("procService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProcServiceImpl implements ProcService
{
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private IdentityService identityService;

    @Override
    public void deleteProcDefByName(String procName)
    {
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().
                processDefinitionName(procName).orderByProcessDefinitionVersion().desc().list();
        String deployId = processDefinitionList.get(0).getDeploymentId();
        repositoryService.deleteDeployment("10001",true);
    }

    //根据流程定义key值及业务key值，提交人，开启流程实例并完成流程提交操作，返回流程实例id
    @Override
    public String startProc(String procKey, String busKey, String userName)
    {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("submitUser", userName);
        identityService.setAuthenticatedUserId(userName);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(procKey,busKey,map);
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        taskService.complete(task.getId());
       return processInstance.getId();
    }

    public void findProcDefByProcKey(String procKey)
    {
       ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(procKey).latestVersion().singleResult();
    }

    @Override
    public List<ProcInstance> findAllProc()
    {
       List<ProcessInstance> procInstList = runtimeService.createProcessInstanceQuery().includeProcessVariables().list();
       List<ProcInstance> piList = new ArrayList<ProcInstance>();
       for(ProcessInstance processInstance : procInstList)
       {
           ProcInstance pi = this.findProcInstById(processInstance.getId(),processInstance);
            piList.add(pi);
       }
       return piList;
    }

    @Override
    public void deleteProcInst(String procInstId)
    {
       ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(procInstId).singleResult();
       if(pi == null)       //该流程实例已执行完成
       {
            historyService.deleteHistoricProcessInstance(procInstId);
       }
       else
       {                    //该流程未执行结束
            runtimeService.deleteProcessInstance(procInstId,"");
            historyService.deleteHistoricProcessInstance(procInstId);
       }
    }

    public ProcInstance findProcInstById(String procInstId, ProcessInstance pi)
    {
        if(pi == null)
        {
            pi = runtimeService.createProcessInstanceQuery().includeProcessVariables()
                    .processInstanceId(procInstId).singleResult();
        }
        ProcInstance procInstance = new ProcInstance();
        if(pi != null)
        {
            procInstance.setProcInstId(procInstId);
            ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().
                    processDefinitionId(pi.getProcessDefinitionId()).latestVersion().singleResult();
            procInstance.setProcName(procDef.getName());
            Map<String,Object> map = pi.getProcessVariables();
            if(pi.getProcessVariables().get("submitUser") != null)
            {
                procInstance.setSubmitUserName(pi.getProcessVariables().get("submitUser").toString());
            }
            procInstance.setCurNode(runtimeService.createExecutionQuery().processInstanceId(pi.getId()).singleResult().getActivityId());
            System.out.println(procInstance.getCurNode());
            return procInstance;
        }
        else
        {
            return null;
        }
    }
}
