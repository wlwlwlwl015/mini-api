package com.wl.bean;

import javax.persistence.*;

/**
 * Created by wangliang on 2018/5/2.
 */
@Entity
@Table(name = "cgt_order_detail")
public class CgtOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "cgt_name")
    private String cgtName;
    @Column(name = "cgt_code")
    private String cgtCode;
    @Column(name = "cgt_code_abbr")
    private String cgtCodeAbbr;
    @Column(name = "cgt_seq")
    private Integer cgtSeq;
    @Column(name = "buy_price")
    private String buyPrice;
    @Column(name = "sale_price")
    private String salePrice;
    @Column
    private Integer count;
    @Column(name = "img_url")
    private String imgUrl;
    @Column
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getCgtCode() {
        return cgtCode;
    }

    public void setCgtCode(String cgtCode) {
        this.cgtCode = cgtCode;
    }

    public String getCgtCodeAbbr() {
        return cgtCodeAbbr;
    }

    public void setCgtCodeAbbr(String cgtCodeAbbr) {
        this.cgtCodeAbbr = cgtCodeAbbr;
    }

    public Integer getCgtSeq() {
        return cgtSeq;
    }

    public void setCgtSeq(Integer cgtSeq) {
        this.cgtSeq = cgtSeq;
    }

    public String getCgtName() {
        return cgtName;
    }

    public void setCgtName(String cgtName) {
        this.cgtName = cgtName;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CgtOrderDetail() {
    }

    public CgtOrderDetail(String orderId, String loginName, String cgtName, String cgtCode, String cgtCodeAbbr, Integer cgtSeq, String buyPrice, String salePrice, Integer count, String imgUrl, String comment) {
        this.orderId = orderId;
        this.loginName = loginName;
        this.cgtName = cgtName;
        this.cgtCode = cgtCode;
        this.cgtCodeAbbr = cgtCodeAbbr;
        this.cgtSeq = cgtSeq;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
        this.count = count;
        this.imgUrl = imgUrl;
        this.comment = comment;
    }
}
