package com.joys.gdmt.Entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;
import java.util.List;

@TableName("organ")
public class Organ {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer pid;
    @TableField(exist = false,select = false)
    private List<Organ> children;
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    public Organ(String name, Integer pid) {
        this.name = name;
        this.pid = pid;
    }

    public Organ(Integer id, String name, Integer pid, List<Organ> children, Date createtime) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.children = children;
        this.createtime = createtime;
    }

    public Organ() {
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

    public List<Organ> getChildren() {
        return children;
    }

    public void setChildren(List<Organ> children) {
        this.children = children;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
