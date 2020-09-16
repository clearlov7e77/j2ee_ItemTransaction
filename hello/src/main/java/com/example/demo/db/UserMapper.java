package com.example.demo.db;
import com.example.demo.bean.User;
public interface UserMapper{
    public User getUser(String name);
    public int  insertUser(User usr);
    public int  deleteUser(String name);

}
