package com.example.mizore;

import com.example.mizore.Bean.Admin;
import com.example.mizore.DBUtils.DBUtils;
import com.example.mizore.Dao.AdminMapper;
import com.example.mizore.Dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import com.example.mizore.Bean.User;

public class test1 {
    @Test
    public void test2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser("xiaoran");
            System.out.println(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public  void testAdmin(){
        SqlSession sqlSession=null;
        try {
            sqlSession = DBUtils.openSqlSession();
            AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
            Admin admin1=new Admin(0,"hzy","123456");
            adminMapper.insertAdmin(admin1);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
