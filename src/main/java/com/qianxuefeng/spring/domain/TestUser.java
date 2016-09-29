/*
* Copyright (c) 2016 qianxuefeng.com. All Rights Reserved.
*/
package com.qianxuefeng.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author qianxuefeng  Date: 16/9/28 上午11:40
 */
public class TestUser {
    private Integer id;
    private String account;// 帐号
    @JsonIgnore
    private String password;// 密码
    private String nickname;// 昵称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}