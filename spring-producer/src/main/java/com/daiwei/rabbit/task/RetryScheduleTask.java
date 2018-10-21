package com.daiwei.rabbit.task;


import java.util.List;

import com.alibaba.fastjson.JSON;
import com.daiwei.rabbit.entity.BrokerMessageLog;
import com.daiwei.rabbit.entity.Order;
import com.daiwei.rabbit.mapper.BrokerMessageLogMapper;
import com.daiwei.rabbit.producer.OrderSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/20 17:11
 */
@Component
public class RetryScheduleTask {

    private static Logger logger = LoggerFactory.getLogger(RetryScheduleTask.class);

    @Autowired
    private BrokerMessageLogMapper logMapper;

    @Autowired
    private OrderSender orderSender;

    //项目启动 3秒之后 每隔十秒执行一次
    @Scheduled(initialDelay = 3000, fixedDelay = 10000)
    public void reSend() {
        logger.info("message resending start");
        List<BrokerMessageLog> msgList4Resend = logMapper.getMsgList4Resend();
        msgList4Resend.forEach(resendRecord -> {
            if (resendRecord.getTryCount() >= 3) {
                logMapper.updateFailedStatus(resendRecord.getId());
            } else {
                logMapper.update4Resend(resendRecord.getId());
                Order order = JSON.parseObject(resendRecord.getMessage(), Order.class);
                try {
                    orderSender.send(order);
                } catch (Exception e) {
                    logger.error("sender failed!");
                    e.printStackTrace();
                }
            }
        });
    }
}
