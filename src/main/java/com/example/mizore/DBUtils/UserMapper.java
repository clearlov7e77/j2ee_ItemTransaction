package com.example.mizore.DBUtils;

import com.example.mizore.Bean.User;
public interface UserMapper {
     User getUser(String name);
     int insertUser(User user);
     int deleteUser(String name);
     int updataPassword(String name,String password);
     int updataMoney(String name,int money);
}
