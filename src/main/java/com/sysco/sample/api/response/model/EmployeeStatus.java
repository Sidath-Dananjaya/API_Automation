package com.sysco.sample.api.response.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "data"
})


public class EmployeeStatus {
    @JsonProperty("status")
    public String status;
    @JsonProperty("data")
    public ArrayList<DataModel> data = new ArrayList<DataModel>();



    public EmployeeStatus(String status, ArrayList<DataModel> data) {
        super();
        this.status = status;
        this.data = data;
    }











}
