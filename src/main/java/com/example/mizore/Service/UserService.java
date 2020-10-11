package com.example.mizore.Service;

import com.example.mizore.Bean.User;

public interface UserService {
    boolean login(User user);
    int    insert(User user);
    int    updatemoney(int id,int money);
    int    updatepassword(int id,String password);
    int    updateaddress(int id,String address);
    User   getuser(String name);
    User   getuserbyid(int id);
}
