package com.example.mizore.ServiceImpl;

import com.example.mizore.Bean.User;
import com.example.mizore.Dao.CustomerMapper;
import com.example.mizore.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public boolean customerlogin(User user){
        if(user.getPassword().equals(customerMapper.getUser(user.getName()).getPassword()))return true;
        return false;
    }
}
