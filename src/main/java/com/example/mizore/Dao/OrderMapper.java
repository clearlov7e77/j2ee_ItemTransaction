package com.example.mizore.Dao;

import com.example.mizore.Bean.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into test.order(name,count,address,customer,seller) values(#{name},#{count},#{address},#{customer},#{seller})")
    int insertOrder(Order order);

    @Delete("delete from test.order where id=#{id}")
    int deleteOrder(int id);

    @Update("update test.order set count=#{cnt} where id=#{id}")
    int updateOrderCount(int id,int cnt);

    @Update("update test.order set address=#{address} where id=#{id}")
    int updateAddress(int id,String address);

    @Update("update test.order set name=#{name} where id=#{id}")
    int updateGoodName(int id,String name);

    @Update("update test.order set customer=#{name} where id=#{id}")
    int updateCustomer(int id,String name);

    @Update("update test.order set seller=#{name} where id=#{id}")
    int updateSeller(int id,String name);

    @Select("select * from test.order where customer=#{name}")
    List<Order> getOrderByCustomer(String name);

    @Select("select * from test.order where seller=#{name}")
    List<Order> getOrderBySeller(String name);
}
