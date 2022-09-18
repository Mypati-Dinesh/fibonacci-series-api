package com.example.fibonacciseries.service.impl;

import com.example.fibonacciseries.model.UserModel;
import com.example.fibonacciseries.repository.FibonacciSeriesRepository;
import com.example.fibonacciseries.service.FibonacciSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciSeriesServiceImpl implements FibonacciSeriesService {

    @Autowired
    FibonacciSeriesRepository fibonacciSeriesRepositoryImpl;

    @Override
    public String userRegistration(UserModel userModel) {
        String status = "USER REGISTRATION FAILED";
        int output = fibonacciSeriesRepositoryImpl.userRegistration(userModel);
        if (output == 1) {
            status = "USER REGISTRATION SUCCEED";
        }
        return status;
    }

    @Override
    public String loginUser(String userName, String userPassword) throws Exception {
        String status = "User Logged in Successfully";
        UserModel userModel = fibonacciSeriesRepositoryImpl.checkUser(userName);
        if(userModel == null){
            //status = "User Name Invalid";
            throw new Exception("User Name Invalid");
        } else {
            if(!userModel.getUserPassword().equals(userPassword)){
                //status = "User Password Incorrect";
                throw new Exception("User Password Incorrect");
            }
        }
        return status;
    }

    @Override
    public List<Integer> fibonacciSeries(int number1, int number2) {
        List<Integer> fibonacciSeriesList = new ArrayList<>();
        fibonacciSeriesList.add(number1);
        fibonacciSeriesList.add(number2);
        int number3;
        for (int i = 0; i < 10; i++) {
            number3 = number1 + number2;
            fibonacciSeriesList.add(number3);
            number1 = number2;
            number2 = number3;
        }
        return fibonacciSeriesList;
    }
}
