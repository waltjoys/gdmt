package com.joys.gdmt.Entities;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

@TableName("role")
public class Role {
    @TableField(exist = false, select = false)
    String resid;
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    public Role(String resid, Integer id, String name) {
        this.resid = resid;
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    public String getResid() {
        return resid;
    }

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;

    public void setResid(String resid) {
        this.resid = resid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    public Role() {
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


}
