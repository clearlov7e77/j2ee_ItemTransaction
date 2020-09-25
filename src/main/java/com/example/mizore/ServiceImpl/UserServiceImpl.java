package com.example.mizore.ServiceImpl;

import com.example.mizore.Bean.User;
import com.example.mizore.Dao.UserMapper;
import com.example.mizore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        if(user.getPassword().equals(userMapper.getUser(user.getName()).getPassword()))return true;
        return false;
    }
}
