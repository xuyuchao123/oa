package com.xyc.service;

import com.xyc.entity.ProcInstance;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * Created by 1 on 2019/4/30.
 */
public interface ProcService
{
    public void deleteProcDefByName(String procName);

    public String startProc(String procKey, String busKey, String userName);

    public List<ProcInstance> findAllProc();

    public void deleteProcInst(String procInstId);

    public ProcInstance findProcInstById(String procInstId, ProcessInstance pi);


}
