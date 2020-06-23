package com.example.mb_demo.mapper;

import com.example.mb_demo.bean.User;
import com.example.mb_demo.jdbctypehandler.MyVarCharHandler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @SelectProvider(type=UserSqlBuild.class,method = "buildSelectAllUser")
    @Results(
            @Result(column = "name", property = "name", typeHandler = MyVarCharHandler.class)
    )
    List<User> selectUserByName(final String name,final String orderByColumn);
    int insert(User user);
    int delUserById(int id);
    int updateUser(User user);
    User selectUserById(int id);

    class UserSqlBuild{
        public String buildSelectAllUser(final String name,final String orderByColumn){
            return new SQL(){{
                SELECT("*");
                FROM("user");
                WHERE("name like '%'||#{name}||'%'");
                ORDER_BY(orderByColumn);
            }}.toString();
        }
    }
}
