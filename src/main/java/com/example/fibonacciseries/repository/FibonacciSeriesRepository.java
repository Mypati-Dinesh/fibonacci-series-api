package com.example.fibonacciseries.repository;

import com.example.fibonacciseries.model.UserModel;

public interface FibonacciSeriesRepository {

    int userRegistration(UserModel userModel);

    UserModel checkUser(String userName);
}
