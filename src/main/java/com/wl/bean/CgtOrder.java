package com.wl.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangliang on 2018/4/28.
 */
@Entity
@Table(name = "cgt_order")
public class CgtOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "xsm_order_id")
    private String xsmOrderId;
    private String money;
    private Integer count;
    @Column(name = "order_time")
    @Temporal(TemporalType.DATE)
    private Date orderTime;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getXsmOrderId() {
        return xsmOrderId;
    }

    public void setXsmOrderId(String xsmOrderId) {
        this.xsmOrderId = xsmOrderId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CgtOrder() {
    }

    public CgtOrder(String loginName, String orderId, String xsmOrderId, String money, Integer count, Date orderTime, String comment) {
        this.loginName = loginName;
        this.orderId = orderId;
        this.xsmOrderId = xsmOrderId;
        this.money = money;
        this.count = count;
        this.orderTime = orderTime;
        this.comment = comment;
    }
}
