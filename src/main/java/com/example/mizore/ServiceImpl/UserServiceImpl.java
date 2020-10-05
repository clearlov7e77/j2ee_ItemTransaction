package com.example.mizore.ServiceImpl;

import com.example.mizore.Bean.User;
import com.example.mizore.Dao.UserMapper;
import com.example.mizore.Service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        if(userMapper.getUser(user.getName())==null)return false;
        if(user.getPassword().equals(userMapper.getUser(user.getName()).getPassword()))return true;
        return false;
    }
    @Override
    public int insert(User user){
        System.out.println(user);
        if(userMapper.getUser(user.getName())!=null){
            return -1;
        }
        else{
            userMapper.insertUser(user);
            return 1;
        }
    }
}
