package com.wl.bean;

import javax.persistence.*;

@Entity
@Table(name = "cgt")
public class Cgt{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="cgt_code")
    private String cgtCode;
    @Column(name="cgt_code_abbr")
    private String cgtCodeAbbr;
    @Column(name="cgt_name")
    private String cgtName;
    @Column(name="mfr_name")
    private String mfrName;
    @Column(name="buy_price")
    private String buyPrice;
    @Column(name="sale_price")
    private String salePrice;
    @Column(name="is_new")
    private Integer isNew;
    @Column(name="is_alien")
    private Integer isAlien;
    @Column(name="is_top")
    private Integer isTop;
    @Column(name="gas_notice")
    private String gasNotice;
    @Column(name="img_url")
    private String imgUrl;
    private String comment;

    public Cgt(Integer id, String cgtCode, String cgtCodeAbbr, String cgtName, String mfrName, String buyPrice, String salePrice, Integer isNew, Integer isAlien, Integer isTop, String gasNotice, String imgUrl, String comment) {
        this.id = id;
        this.cgtCode = cgtCode;
        this.cgtCodeAbbr = cgtCodeAbbr;
        this.cgtName = cgtName;
        this.mfrName = mfrName;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
        this.isNew = isNew;
        this.isAlien = isAlien;
        this.isTop = isTop;
        this.gasNotice = gasNotice;
        this.imgUrl = imgUrl;
        this.comment = comment;
    }

    public Cgt() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCgtCode() {
        return cgtCode;
    }

    public void setCgtCode(String cgtCode) {
        this.cgtCode = cgtCode == null ? null : cgtCode.trim();
    }

    public String getCgtCodeAbbr() {
        return cgtCodeAbbr;
    }

    public void setCgtCodeAbbr(String cgtCodeAbbr) {
        this.cgtCodeAbbr = cgtCodeAbbr == null ? null : cgtCodeAbbr.trim();
    }

    public String getCgtName() {
        return cgtName;
    }

    public void setCgtName(String cgtName) {
        this.cgtName = cgtName == null ? null : cgtName.trim();
    }

    public String getMfrName() {
        return mfrName;
    }

    public void setMfrName(String mfrName) {
        this.mfrName = mfrName == null ? null : mfrName.trim();
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice == null ? null : buyPrice.trim();
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice == null ? null : salePrice.trim();
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIsAlien() {
        return isAlien;
    }

    public void setIsAlien(Integer isAlien) {
        this.isAlien = isAlien;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop ;
    }

    public String getGasNotice() {
        return gasNotice;
    }

    public void setGasNotice(String gasNotice) {
        this.gasNotice = gasNotice == null ? null : gasNotice.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}