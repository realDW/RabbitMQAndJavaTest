package com.daiwei.rabbit.producer;

import com.daiwei.rabbit.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/17 18:44
 */
@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) throws Exception {
        rabbitTemplate.convertAndSend("test-exchange",
                "test.key", order, new CorrelationData(order.getMsgId()));
    }


}
