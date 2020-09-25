package com.example.mizore.Dao;

import com.example.mizore.Bean.Good;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GoodMapper {
    @Insert("insert into good(name,count,description,type) values(#{name},#{count},#{description},#{type})")
    int insertGood(Good good);

    @Delete("delete from good where id=#{id}")
    int deleteGood(int id);

    @Update("update good set count=#{cnt} where id=#{id}")
    int updateCount(int id,int cnt);

    @Update("update good set description=#{des} where id=#{id}")
    int updateDes(int id,String des);

    @Update("update good set type=#{type} where id=#{id}")
    int updateType(int id,String type);

    @Select("select * from good where name=#{name}")
    Good getGood(String name);
}
