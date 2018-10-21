package com.daiwei.rabbit.producer;

import com.daiwei.rabbit.entity.Order;
import com.daiwei.rabbit.mapper.BrokerMessageLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BrokerMessageLogMapper logMapper;


    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {

        @Override
        public void confirm(CorrelationData correlationData, boolean b, String s) {

            Long msgId = Long.valueOf(correlationData.getId());
            if (b) {
                logMapper.updateSuccessStatus(msgId);
            } else {
                logger.error("message missed!!");
            }
        }
    };

    public void send(Order order) throws Exception {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.convertAndSend("test-exchange",
                "test.key", order, new CorrelationData(order.getMsgId().toString()));
    }

}
