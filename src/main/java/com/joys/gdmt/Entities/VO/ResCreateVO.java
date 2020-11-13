package com.joys.gdmt.Entities.VO;

public class ResCreateVO {
    private String name;
    private Integer pid;

    public ResCreateVO() {
    }

    public ResCreateVO(String name, Integer pid) {
        this.name = name;
        this.pid = pid;
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
}
