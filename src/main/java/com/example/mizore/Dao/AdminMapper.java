package com.example.mizore.Dao;

import com.example.mizore.Bean.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where name=#{name}")
    Admin getAdmin(String name);

    @Insert("insert into admin(name,password) values(#{name},#{password})")
    int insertAdmin(Admin admin);
   // int deleteAdmin(String name);
    @Update("update admin set password=#{password} where id=#{id}")
    int updateAdminPassword(int id,String password);
}
