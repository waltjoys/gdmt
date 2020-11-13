package com.joys.gdmt.Entities.VO;

public class RoleUpdateVO {
    String resid;
    private Integer id;
    private String name;

    public RoleUpdateVO() {
    }

    public RoleUpdateVO(Integer id, String name, String resid) {
        this.id = id;
        this.name = name;
        this.resid = resid;
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

    public String getResid() {
        return resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }
}
