package com.example.mizore.DBUtils;

import com.example.mizore.Bean.Order;

public interface OrderMapper {
    int insertOrder(Order order);
    int deleteOrder(int id);
    int updateOrderCount(int id,int cnt);
    int updateAddress(int id,String address);
    int updateName(int id,String name);
    int updateCustomer(int id,String name);
    int updateSeller(int id,String name);
    Order getOrderByCustomer(String name);
    Order getOrderBySeller(String name);
}
