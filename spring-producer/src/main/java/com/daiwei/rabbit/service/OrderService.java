package com.daiwei.rabbit.service;

import com.daiwei.rabbit.entity.Order;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/20 14:39
 */
public interface OrderService {

    Order getOrderById(Long id);

    void createOrder(Order order);
}
