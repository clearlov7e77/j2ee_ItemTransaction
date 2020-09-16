package com.example.demo;

import com.example.demo.bean.User;
import com.example.demo.db.DBUtils;
import com.example.demo.db.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class test1 {
    @Test
    public void test2(){
        SqlSession sqlsession =null;
        try{
            sqlsession= DBUtils.open();
            UserMapper map1=sqlsession.getMapper(UserMapper.class);
            User user= map1.getUser("张三");
            System.out.println(user);
            sqlsession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlsession.rollback();
        }finally {
            if(sqlsession!=null){

                sqlsession.close();
            }
        }
    }
}
