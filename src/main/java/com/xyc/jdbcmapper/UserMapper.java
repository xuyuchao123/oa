package com.xyc.jdbcmapper;


import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018-09-30.
 */
public class UserMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException
    {
//        return new SysUser(resultSet.getInt("id"),resultSet.getString("userName"),
//                resultSet.getString("password"),resultSet.getString("userNum"));
        return null;
    }
}
