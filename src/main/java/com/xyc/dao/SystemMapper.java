package com.xyc.dao;

import com.xyc.entity.System;
import java.util.List;

public interface SystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    System selectByPrimaryKey(Integer id);

    List<System> selectAll();

    int updateByPrimaryKey(System record);

    List<System> selectSystemByRoleId(Integer roleId);
}