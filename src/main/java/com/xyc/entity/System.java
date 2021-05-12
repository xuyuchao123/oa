package com.xyc.entity;

import java.io.Serializable;

public class System implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 系统名称
     * sys_name
     */
    private String sysName;

    /**
     * 系统编码
     * sys_code
     */
    private String sysCode;

    /**
     * 数据状态
     * data_status
     */
    private String dataStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}