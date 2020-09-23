package com.example.mizore;

import com.example.mizore.DBUtils.DBUtils;
import com.example.mizore.DBUtils.UserMapper;
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
}
