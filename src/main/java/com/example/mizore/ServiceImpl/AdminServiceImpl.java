package com.example.mizore.ServiceImpl;

import com.example.mizore.Bean.Admin;
import com.example.mizore.Dao.AdminMapper;
import com.example.mizore.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public boolean adminlogin(Admin admin) {
        if(admin.getPassword().equals(adminMapper.getAdmin(admin.getName()).getPassword()));
        return false;
    }
}
