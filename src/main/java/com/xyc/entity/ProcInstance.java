package com.xyc.entity;

/**
 * Created by 1 on 2019/5/8.
 * 流程实例对象实体
 */
public class ProcInstance
{
    private String procInstId;
    private String procName;
    private String submitUserName;
    private String curNode;

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getSubmitUserName() {
        return submitUserName;
    }

    public void setSubmitUserName(String submitUserName) {
        this.submitUserName = submitUserName;
    }

    public String getCurNode() {
        return curNode;
    }

    public void setCurNode(String curNode) {
        this.curNode = curNode;
    }



}
