package com.xyc.dao;

import com.xyc.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-09-27.
 */
public interface SysUserMapper
{
    public SysUser selectUserRoleByUsername(@Param("userName")String userName);

    public SysUser selectUserRoleByUsernameSelect(@Param("userName")String userName);

    public Integer insert(SysUser sysUser);

    public List<SysUser> testForeach(List<Integer> ids);

    public void updateByUserName(@Param("userName")String userName, @Param("password")String password);
}
