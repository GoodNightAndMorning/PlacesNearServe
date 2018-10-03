package com.zsx.pn.dto;

public class ManagerLoginDto {
    private Integer managerId;
    private String managerName;
    private String token;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ManagerLoginDto{" +
                "managerId=" + managerId +
                ", managerName='" + managerName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
