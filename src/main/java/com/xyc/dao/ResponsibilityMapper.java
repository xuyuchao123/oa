package com.xyc.dao;

import com.xyc.entity.Responsibility;
import java.util.List;

public interface ResponsibilityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Responsibility record);

    Responsibility selectByPrimaryKey(Integer id);

    Responsibility selectResponsibilityByRoleId(Integer roleId);

    List<Responsibility> selectAll();

    int updateByPrimaryKey(Responsibility record);
}