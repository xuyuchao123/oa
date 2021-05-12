package com.xyc.vo;

/**
 * Created by Administrator on 2018-10-04.
 *  value object  用来封装值对象
 */
public class UserVo
{
    String userName;
    String password;
    String userNum;

    public UserVo(String userName, String password, String userNum) {
        this.userName = userName;
        this.password = password;
        this.userNum = userNum;
    }

    public UserVo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }
}
