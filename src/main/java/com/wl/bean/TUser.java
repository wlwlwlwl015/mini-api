package com.wl.bean;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class TUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid_")
    private Integer uid;
    @Column(name = "loginid_")
    private String loginid;
    @Column(name = "password_")
    private String password;
    @Column(name = "realname_")
    private String realname;
    @Column(name = "status_")
    private Integer status;
    @Column(name = "comment_")
    private String comment;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid == null ? null : loginid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public TUser() {
    }

    public TUser(String loginid, String password, String realname, Integer status, String comment) {
        this.loginid = loginid;
        this.password = password;
        this.realname = realname;
        this.status = status;
        this.comment = comment;
    }
}