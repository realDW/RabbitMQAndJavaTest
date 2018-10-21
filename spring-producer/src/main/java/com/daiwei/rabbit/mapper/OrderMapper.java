package com.daiwei.rabbit.mapper;

import com.daiwei.rabbit.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/20 11:12
 */
@Mapper
@Repository
public interface OrderMapper {

    Order getOrderById(Long id);

    Long insert(Order order);
}

