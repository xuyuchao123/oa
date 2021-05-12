package com.xyc.dao;

import com.xyc.entity.Role;

import java.util.List;

/**
 * Created by 1 on 2020/3/17.
 */
public interface RoleMapper
{
    Role selectByPrimaryKey(Integer id);

    List<Role> selectRoleByUserId(Integer userId);
}
