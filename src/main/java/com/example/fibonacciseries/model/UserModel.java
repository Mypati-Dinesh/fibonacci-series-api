package com.example.fibonacciseries.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    private String userName;

    private String userPassword;

    private String email;

    private String address;

    private long userPhoneNo;

}
