package com.xyc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 2020/3/17.
 */
public class Role implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String roleName;
    private Integer inputUserId;
    private Date inputDate;
    private Integer dataStatus;
    private Integer roleStatus;
    private Integer modifyUserId;
    private Date modifyDate;
    private Responsibility responsibility;
    private List<System> systems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getInputUserId() {
        return inputUserId;
    }

    public void setInputUserId(Integer inputUserId) {
        this.inputUserId = inputUserId;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Responsibility getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Responsibility responsibility) {
        this.responsibility = responsibility;
    }

    public List<System> getSystems() {
        return systems;
    }

    public void setSystems(List<System> systems) {
        this.systems = systems;
    }
}
