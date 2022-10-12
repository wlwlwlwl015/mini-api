package com.wl.bean;

import com.wl.enumm.UserStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangliang on 2018/4/19.
 */
@Entity
@Table(name = "sys_user_info")
public class SysUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "login_name")
    private String loginName;
    private String pwd;
    @Column(name = "af_pwd")
    private String afPwd;
    private String salt;
    @Column(name = "real_name")
    private String realName;
    @Column(name = "phone_num")
    private String phoneNumber;
    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "area_info")
    private String areaInfo;
    private String address;
    private String longitude;
    private String latitude;
    @Column(name = "licence_img")
    private String licenceImg;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private UserStatus status = UserStatus.DISABLE;
    @Column(name = "create_time")
    private Date createTime;
    private String comment;
    @Transient
    private String sessionId;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAfPwd() {
        return afPwd;
    }

    public void setAfPwd(String afPwd) {
        this.afPwd = afPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLicenceImg() {
        return licenceImg;
    }

    public void setLicenceImg(String licenceImg) {
        this.licenceImg = licenceImg;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public SysUserInfo() {
    }

    public SysUserInfo(String loginName, String pwd, String afPwd, String salt, String realName, String phoneNumber, String shopName, String areaInfo, String address, String longitude, String latitude, String licenceImg, UserStatus status, Date createTime, String comment) {
        this.loginName = loginName;
        this.pwd = pwd;
        this.afPwd = afPwd;
        this.salt = salt;
        this.realName = realName;
        this.phoneNumber = phoneNumber;
        this.shopName = shopName;
        this.areaInfo = areaInfo;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.licenceImg = licenceImg;
        this.status = status;
        this.createTime = createTime;
        this.comment = comment;
    }
}
