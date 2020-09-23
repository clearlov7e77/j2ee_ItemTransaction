package com.example.mizore.DBUtils;

import com.example.mizore.Bean.Good;

public interface GoodMapper {
    int insertGood(Good good);
    int deleteGood(int id);
    int updateCount(int id,int cnt);
    int updateDes(int id,String des);
    int updateType(int id,String type);
    Good getGood(String name);
}
