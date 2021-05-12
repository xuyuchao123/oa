package com.xyc.service;


import com.xyc.entity.SysUser;
import com.xyc.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Administrator on 2018-09-27.
 */
public interface UserService extends UserDetailsService
{
    public SysUser login(String username, String password);

    public void regist( UserVo userVo);

    public void updateUser(String userName, String password);
}
