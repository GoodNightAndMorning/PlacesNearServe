package com.zsx.pn.model;

public class QueryPlacesModel {
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "QueryPlacesModel{" +
                "state=" + state +
                '}';
    }
}
