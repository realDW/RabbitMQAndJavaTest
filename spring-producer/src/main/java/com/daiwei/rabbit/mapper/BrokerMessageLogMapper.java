package com.daiwei.rabbit.mapper;

import java.util.List;

import com.daiwei.rabbit.entity.BrokerMessageLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/20 17:29
 */
@Mapper
@Repository
public interface BrokerMessageLogMapper {

    Long insert(BrokerMessageLog log);

    void updateSuccessStatus(Long msgId);

    List<BrokerMessageLog> getMsgList4Resend();

    void updateFailedStatus(Long msgId);

    void update4Resend(Long msgId);

}
