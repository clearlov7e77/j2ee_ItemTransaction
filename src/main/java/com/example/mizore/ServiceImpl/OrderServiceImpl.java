package com.example.mizore.ServiceImpl;

import com.example.mizore.Bean.Order;
import com.example.mizore.Dao.OrderMapper;
import com.example.mizore.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> getmyorder(String name) {
        return orderMapper.getOrderByCustomer(name);
    }
}
