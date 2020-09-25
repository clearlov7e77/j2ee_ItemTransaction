package com.example.mizore.ServiceImpl;

import com.example.mizore.Bean.User;
import com.example.mizore.Dao.SellerMapper;
import com.example.mizore.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public boolean sellerlogin(User user) {
        if(user.getPassword().equals(sellerMapper.getUser(user.getName()).getPassword()))return true;
        return false;
    }
}
