package com.jtf.springboot.aws.sns.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserPayloadRequest {

    private int id;
    private String firstName;
    private String lastName;
    private String designation;
    private double salary;
    private Date dob;
    private Address address;

}
