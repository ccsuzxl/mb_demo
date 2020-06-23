package com.example.mb_demo.jdbctypehandler;

import com.example.mb_demo.controller.SingletonEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedJdbcTypes(JdbcType.DATE)
public class MyDateHandler implements TypeHandler {
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp d=rs.getTimestamp(columnName);
        long time = d.getTime();
        return SingletonEnum.INSTANCE.getInstance().format(new Date(time));
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getString(columnIndex);
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getString(columnIndex);
    }
}
