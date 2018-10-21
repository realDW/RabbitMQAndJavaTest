package com.daiwei.rabbit.service.impl;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.daiwei.rabbit.constant.Constants;
import com.daiwei.rabbit.entity.BrokerMessageLog;
import com.daiwei.rabbit.entity.Order;
import com.daiwei.rabbit.mapper.BrokerMessageLogMapper;
import com.daiwei.rabbit.mapper.OrderMapper;
import com.daiwei.rabbit.producer.OrderSender;
import com.daiwei.rabbit.service.OrderService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/20 14:40
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private BrokerMessageLogMapper logMapper;

    @Autowired
    private OrderSender orderSender;

    @Override
    public Order getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public void createOrder(Order order) {
        Date orderDate = new Date();
        BrokerMessageLog log = new BrokerMessageLog();
        log.setMessage(JSON.toJSONString(order));
        log.setNextRetry(DateUtils.addMinutes(orderDate, 1));
        log.setTryCount(0);
        log.setStatus(Constants.ORDER_SENDING);
        log.setCreateTime(orderDate);
        log.setUpdateTime(orderDate);
        logMapper.insert(log);
        order.setMsgId(log.getId());
        orderMapper.insert(order);
        try {
            orderSender.send(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
