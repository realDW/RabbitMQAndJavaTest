package com.daiwei.rabbit;

import com.daiwei.rabbit.entity.Order;
import com.daiwei.rabbit.mapper.OrderMapper;
import com.daiwei.rabbit.producer.OrderSender;
import com.daiwei.rabbit.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringProducerApplicationTests {

    private static Logger logger = LoggerFactory.getLogger(SpringProducerApplicationTests.class);

    @Autowired
    private OrderSender sender;

    @Autowired
    private OrderMapper mapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendTest() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setName("test rabbitMQ");
//        order.setMsgId(System.currentTimeMillis()+"$"+UUID.randomUUID());
        sender.send(order);
    }

    @Test
    public void daoTest() {
        Order order = mapper.getOrderById(1L);
        logger.info("{}", order);
    }

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreate() {
        Order order = new Order();
        order.setName("test");
        orderService.createOrder(order);
    }



}

