package com.xyc.service.impl;


import com.xyc.dao.ResponsibilityMapper;
import com.xyc.dao.RoleMapper;
import com.xyc.dao.SysUserMapper;
import com.xyc.entity.Responsibility;
import com.xyc.entity.Role;
import com.xyc.entity.SysUser;
import com.xyc.service.UserService;
import com.xyc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018-09-27.
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService
{
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @Autowired
//    private ResponsibilityMapper responsibilityMapper;
//
//    @Autowired
//    private RoleMapper roleMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public SysUser login(String username, String password)
    {
//        List ids = new ArrayList<Integer>();
//        ids.add(1);
//        ids.add(2);
//        sysUserMapper.testForeach(ids);

        SysUser sysUser = sysUserMapper.selectUserRoleByUsername(username);
        if(sysUser != null)
        {
            if(sysUser.getPassword().equals(password))
            {
                return sysUser;
            }
            //throw new PasswordException("密码错误");
        }
       // throw new UserNotExistException("密码错误");
        return null;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor =
//        Exception.class,timeout = 5000)
    public void regist(UserVo userVo)
    {
        SysUser sysUser = new SysUser();
        sysUser.setPassword(passwordEncoder.encode(userVo.getPassword()));  //对密码进行加密再入库
        sysUser.setUserName(userVo.getUserName());
        sysUser.setUserNum(userVo.getUserNum());
        Integer id = sysUserMapper.insert(sysUser);
        System.out.println(id);
    }

    //自定义springsecurity用户认证实现类,重写认证方法，从数据库中获取用户名密码权限信息，返回springsecurity的
    //UserDetails对象
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
//        Role role2 = roleMapper.selectByPrimaryKey(1);
//        Responsibility responsibility = responsibilityMapper.selectResponsibilityByRoleId(1);
//        List<Role> role3 = roleMapper.selectRoleByUserId(3);
//        SysUser sysUser = sysUserMapper.selectUserRoleByUsername(username);
        SysUser sysUser = sysUserMapper.selectUserRoleByUsernameSelect(username);
        if(sysUser == null)
        {
            return null;
        }
        List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();

        List<Role> roles = sysUser.getRoles();
        if(roles != null && roles.size() > 0)
        {
            for(Role role : roles)
            {
                authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            }
        }
        return new User(sysUser.getUserName(),sysUser.getPassword(), authorityList);

    }

    @Override
    public void updateUser(String userName,String password)
    {
         password = passwordEncoder.encode(password);
        sysUserMapper.updateByUserName(userName,password);
    }
}
