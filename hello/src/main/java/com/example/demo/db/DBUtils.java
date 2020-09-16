package com.example.demo.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class DBUtils {
    private static SqlSessionFactory sqlSessionFactory=null;
    private static final Class CLASS_LOCK =DBUtils.class;

    public static SqlSessionFactory init(){
        InputStream in=null;
        try{
            in= Resources.getResourceAsStream("mybatis-conf.xml");
        }catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            }
        }
        return sqlSessionFactory;
    }
    public static SqlSession open(){
        if(sqlSessionFactory==null){
            init();
        }
        return sqlSessionFactory.openSession();
    }
}
