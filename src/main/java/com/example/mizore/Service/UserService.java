package com.example.mizore.Service;

import com.example.mizore.Bean.User;

public interface UserService {
    boolean login(User user);
    int    insert(User user);
}
