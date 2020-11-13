package com.joys.gdmt.Entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer organid;
    private String name;
    private String password;
    private String email;
    private String phone;

    @TableField(exist = false, select = false)
    private String dutyid;

    public User(Integer organid, String name, String password, String email, String phone, String dutyid) {
        this.organid = organid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.dutyid = dutyid;
    }

    public String getDutyid() {
        return dutyid;
    }

    public User() {
    }

    public void setDutyid(String dutyid) {
        this.dutyid = dutyid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOrganid() {
        return organid;
    }

    public void setOrganid(Integer organid) {
        this.organid = organid;
    }
}
