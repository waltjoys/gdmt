package com.joys.gdmt.Entities.VO;

public class DutyVO {
    private Integer id;
    private String name;

    private Integer organid;
    private Integer roleid;

    public DutyVO(Integer id, String name, Integer organid, String organname, Integer roleid, String rolename) {
        this.id = id;
        this.name = name;
        this.organid = organid;
        this.organname = organname;
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public Integer getOrganid() {
        return organid;
    }

    public void setOrganid(Integer organid) {
        this.organid = organid;
    }

    private String organname;

    public Integer getRoleid() {
        return roleid;
    }

    private String rolename;

    public DutyVO() {
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
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

    public String getOrganname() {
        return organname;
    }

    public void setOrganname(String organname) {
        this.organname = organname;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
