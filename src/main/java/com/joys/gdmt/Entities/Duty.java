package com.joys.gdmt.Entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("duty")
public class Duty {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer organid;
    private Integer roleid;

    public Duty(String name, Integer organid, Integer roleid) {
        this.name = name;
        this.organid = organid;
        this.roleid = roleid;
    }

    public Duty() {
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

    public Integer getOrganid() {
        return organid;
    }

    public void setOrganid(Integer organid) {
        this.organid = organid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}
