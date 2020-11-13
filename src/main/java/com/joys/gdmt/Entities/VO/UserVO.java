package com.joys.gdmt.Entities.VO;

public class UserVO {
    private Integer id;
    private Integer organid;
    private String organname;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String dutyid;

    public UserVO() {
    }

    public UserVO(Integer id, Integer organid, String organname, String name, String password, String email, String phone) {
        this.id = id;
        this.organid = organid;
        this.organname = organname;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getDutyid() {
        return dutyid;
    }

    public void setDutyid(String dutyid) {
        this.dutyid = dutyid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganid() {
        return organid;
    }

    public void setOrganid(Integer organid) {
        this.organid = organid;
    }

    public String getOrganname() {
        return organname;
    }

    public void setOrganname(String organname) {
        this.organname = organname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
