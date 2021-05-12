package com.xyc.entity;

import java.io.Serializable;

public class Menu implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 菜单名称
     * menu_name
     */
    private String menuName;

    /**
     * 菜单请求url
     * url
     */
    private String url;

    /**
     * 菜单位置索引
     * menu_index
     */
    private Integer menuIndex;

    /**
     * 父菜单id
     * parent_id
     */
    private Integer parentId;

    /**
     * 是否显示 0：不显示 1：显示
     * display
     */
    private Integer display;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(Integer menuIndex) {
        this.menuIndex = menuIndex;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}