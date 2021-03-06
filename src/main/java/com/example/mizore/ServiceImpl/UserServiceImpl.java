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
     //   System.out.println(user);
        if(userMapper.getUser(user.getName())!=null){
            return -1;
        }
        else{
            user.setMoney(1000);
            userMapper.insertUser(user);
            return 1;
        }
    }

    @Override
    public int updatemoney(int id, int money) {
            userMapper.updateMoney(id,money);
            return 1;
    }

    @Override
    public int updatepassword(int id, String password) {
        userMapper.updatePassword(id,password);
        return 1;
    }

    @Override
    public int updateaddress(int id, String address) {
      //  System.out.println(address);
      //  System.out.println(id);
        userMapper.updateuseraddress(id,address);
        return 1;
    }

    @Override
    public User getuser(String name) {
        return userMapper.getUser(name);
    }
    public User   getuserbyid(int id){ return  userMapper.getUserbyid(id);}
}
