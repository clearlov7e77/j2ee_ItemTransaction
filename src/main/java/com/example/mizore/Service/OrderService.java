package com.example.mizore.Service;

import com.example.mizore.Bean.Order;

import java.util.List;

public interface OrderService {
    List<Order> getmyorder(String name);
    int insertorder(Order order);
    List<Order> getorderi(String name);
}
