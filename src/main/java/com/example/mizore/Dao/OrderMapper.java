package com.example.mizore.Dao;

import com.example.mizore.Bean.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {
    @Insert("insert into order(name,count,address,customer,seller) values(#{name},#{count},#{address},#{customer},#{seller})")
    int insertOrder(Order order);

    @Delete("delete from order where id=#{id}")
    int deleteOrder(int id);

    @Update("update order set count=#{cnt} where id=#{id}")
    int updateOrderCount(int id,int cnt);

    @Update("update order set address=#{address} where id=#{id}")
    int updateAddress(int id,String address);

    @Update("update order set name=#{name} where id=#{id}")
    int updateName(int id,String name);

    @Update("update order set customer=#{name} where id=#{id}")
    int updateCustomer(int id,String name);

    @Update("update order set seller=#{name} where id=#{id}")
    int updateSeller(int id,String name);

    @Select("select * from order where customer=#{name}")
    Order getOrderByCustomer(String name);

    @Select("select * from order where seller=#{name}")
    Order getOrderBySeller(String name);
}
