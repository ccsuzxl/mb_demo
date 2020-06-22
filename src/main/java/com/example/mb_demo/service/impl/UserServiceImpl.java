package com.example.mb_demo.service.impl;

import com.example.mb_demo.bean.User;
import com.example.mb_demo.mapper.UserMapper;
import com.example.mb_demo.service.UserService;
import org.apache.ibatis.type.StringTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserByName(String name, String orderByColumn) {
        return userMapper.selectUserByName(name,orderByColumn);
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int delUserById(int id) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public User selectUserById(int id) {
        return null;
    }

    public static void main(String[] args) {

    }
}
