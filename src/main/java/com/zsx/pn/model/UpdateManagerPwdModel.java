package com.zsx.pn.model;

public class UpdateManagerPwdModel {
    private Integer managerId;
    private String password;
    private String rePassword;
    private String token;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UpdateManagerPwdModel{" +
                "managerId=" + managerId +
                ", password='" + password + '\'' +
                ", rePassword='" + rePassword + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
