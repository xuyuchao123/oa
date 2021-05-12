package com.xyc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Responsibility implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 职责编码
     * code
     */
    private String code;

    /**
     * 职责名称
     * name
     */
    private String name;

    /**
     * 录入人ID
     * input_user_id
     */
    private Integer inputUserId;

    /**
     * 录入时间
     * input_date
     */
    private Date inputDate;

    /**
     * 职责删除状态 0：已删除，1：正常
     * data_status
     */
    private Integer dataStatus;

    /**
     * 职责状态 1：已复核 0：保存
     * check_status
     */
    private Integer checkStatus;

    /**
     * 最后修改人ID
     * last_modify_user_id
     */
    private Integer lastModifyUserId;

    /**
     * 最后修改时间
     * modify_date
     */
    private Date modifyDate;

    private List<Menu> menus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getLastModifyUserId() {
        return lastModifyUserId;
    }

    public void setLastModifyUserId(Integer lastModifyUserId) {
        this.lastModifyUserId = lastModifyUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}