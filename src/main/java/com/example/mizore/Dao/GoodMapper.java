package com.example.mizore.Dao;

import com.example.mizore.Bean.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodMapper {
    @Insert("insert into good(name,count,description,type,price) values(#{name},#{count},#{description},#{type},#{price})")
    int insertGood(Good good);

    @Delete("delete from good where id=#{id}")
    int deleteGood(int id);

    @Update("update good set count=#{cnt} where id=#{id}")
    int updateCount(int id,int cnt);

    @Update("update good set description=#{des} where id=#{id}")
    int updateDes(int id,String des);

    @Update("update good set type=#{type} where id=#{id}")
    int updateType(int id,String type);

    @Update("update good set price=#{price} where id=#{id}")
    int updatePrice(int id,int price);

    @Select("select * from good where name=#{name}")
    Good getGood(String name);

    @Select("select * from good where id=#{id}")
    Good getGoodbyid(int id);

    @Select("select * from good where type=#{type}")
    List<Good> getGoodbyType(String type);

    @Select("select * from good")
    List<Good> getallGood();

    @Select("select * from good where name=#{name}")
    List<Good> getGoodbyName(String name);
}
