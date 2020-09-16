package com.example.mizore.DBUtils;

import com.example.mizore.Bean.User;
public interface UserMapper {
    public User getUser(String name);

    public int insertUser(User user);

    public int deleteUser(String name);
}
