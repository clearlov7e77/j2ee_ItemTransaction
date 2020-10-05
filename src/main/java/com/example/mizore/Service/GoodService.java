package com.example.mizore.Service;

import com.example.mizore.Bean.Good;

import java.util.List;

public interface GoodService {
    int insertGood(Good good);
    int deleteGood(String name);
    Good findGood(String name);
    Good findGood(int id);
    int updateGood(String name,int price);
    List<Good> getgoodbytype(String type);
    List<Good> getallgood();
    List<Good> getgoodbyname(String name);
}
