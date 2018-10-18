package com.daiwei.rabbit;

import java.util.UUID;

import com.daiwei.rabbit.entity.Order;
import com.daiwei.rabbit.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringProducerApplicationTests {

    @Autowired
    private OrderSender sender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendTest() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setName("test rabbitMQ");
        order.setMsgId(System.currentTimeMillis()+"$"+UUID.randomUUID());
        sender.send(order);
    }



}

