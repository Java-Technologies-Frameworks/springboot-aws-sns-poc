package com.jtf.springboot.aws.sns.model;

import lombok.Data;

@Data
public class Address {
    private String buildingNo;
    private String street;
    private String landMark;
    private String city;
    private  String state;
    private String country;

}
