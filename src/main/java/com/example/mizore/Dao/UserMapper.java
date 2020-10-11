package com.example.mizore.Dao;

import com.example.mizore.Bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

     @Select("select * from user where name=#{name}")
     User getUser(String name);

     @Select("select * from user where id=#{id}")
     User getUserbyid(int id);

     @Insert("insert into user(name,money,password) values(#{name},#{money},#{password})")
     int insertUser(User user);

     @Delete("delete from user where id=#{id}")
     int deleteUser(int id);

     @Update("update user set password=#{password} where id=#{id}")
     int updatePassword(int id,String password);

     @Update("update user set money=#{money} where id=#{id}")
     int updateMoney(int id,int money);

     @Update("update user set address=#{address} where id=#{id}")
     int updateuseraddress(int id,String address);


}
