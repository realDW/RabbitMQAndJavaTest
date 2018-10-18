package com.daiwei.rabbit.receiver;

import java.io.IOException;
import java.util.Map;

import com.daiwei.rabbit.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 消息消费端
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/10/18 23:33
 */
@Component
public class OrderReceiver {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "test-order", durable = "true"),
            exchange = @Exchange(value = "test-exchange", type = "topic"),
            key = "test.*"
        )
    )
    @RabbitHandler
    public void onOrderReceiver(@Payload Order order, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println("------------------消息签收！--------------------");

        System.out.println(order);

        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);

        channel.basicAck(deliveryTag, true);
    }
}
