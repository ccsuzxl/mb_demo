package com.example.mb_demo.service;

import com.example.mb_demo.bean.User;

import java.util.List;

public interface UserService {
    List<User> selectUserByName(String name,String orderByColumn);
    int insert(User user);
    int delUserById(int id);
    int updateUser(User user);
    User selectUserById(int id);
}
