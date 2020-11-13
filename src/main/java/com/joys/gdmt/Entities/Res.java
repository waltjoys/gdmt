package com.joys.gdmt.Entities;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.util.List;

@TableName(value = "res")
public class Res {
    @TableField(exist = false, select = false)
    List<Res> children;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer pid;
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    public Res(String name, Integer pid) {
        this.name = name;
        this.pid = pid;
    }

    public Res() {
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Res> getChildren() {
        return children;
    }

    public void setChildren(List<Res> children) {
        this.children = children;
    }
}
