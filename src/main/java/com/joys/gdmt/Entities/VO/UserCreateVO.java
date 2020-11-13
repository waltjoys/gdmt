package com.joys.gdmt.Entities.VO;

public class UserCreateVO {
    private String name;
    private String password;
    private String email;
    private String phone;
    private Integer organid;
    private String duty;

    public UserCreateVO(String name, String password, String email, String phone, Integer organid, String duty) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.organid = organid;
        this.duty = duty;
    }

    public UserCreateVO() {
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
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
