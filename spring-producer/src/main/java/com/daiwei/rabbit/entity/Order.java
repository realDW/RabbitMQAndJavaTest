package com.daiwei.rabbit.entity;

import java.io.Serializable;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/10/17 18:42
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1999137072134825083L;

    private Long id;

    private String name;

    private String msgId;

    public Order() {}

    public Order(Long id, String name, String msgId) {
        this.id = id;
        this.name = name;
        this.msgId = msgId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
