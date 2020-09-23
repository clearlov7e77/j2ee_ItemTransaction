package com.example.mizore.DBUtils;

import com.example.mizore.Bean.Admin;

public interface AdminMapper {
    Admin getAdmin(String name);
    int insertAdmin(Admin admin);
   // int deleteAdmin(String name);
    int updataPassword(String name);
}
