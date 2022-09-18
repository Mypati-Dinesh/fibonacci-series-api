package com.example.fibonacciseries.service;

import com.example.fibonacciseries.model.UserModel;

import java.util.List;

public interface FibonacciSeriesService {

     String userRegistration(UserModel userModel);

     String loginUser(String userName,String userPassword) throws Exception;

    List<Integer> fibonacciSeries(int number1,int number2);
}
