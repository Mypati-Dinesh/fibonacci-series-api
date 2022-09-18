package com.example.fibonacciseries.web.controller;

import com.example.fibonacciseries.model.UserModel;
import com.example.fibonacciseries.service.FibonacciSeriesService;
import com.example.fibonacciseries.web.model.FibonacciSeriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/FibonacciSeries")
public class FibonacciSeriesController {

    @Autowired
    FibonacciSeriesService fibonacciSeriesServiceImpl;

    @PostMapping("registration")
    public ResponseEntity<Object> userRegistration(@RequestBody UserModel userModel){
        String status = fibonacciSeriesServiceImpl.userRegistration(userModel);
        return ResponseEntity.ok().body(status);
    }
    @GetMapping("login")
    public ResponseEntity<Object> loginUser(String userName,String userPassword) throws Exception {
        String status=fibonacciSeriesServiceImpl.loginUser(userName,userPassword);
        return ResponseEntity.ok().body(status);
    }
    @GetMapping("fibonacci")
    public ResponseEntity<Object> fibonacciSeries(int number1,int number2){
        List<Integer> fibonacciSeriesOutput = fibonacciSeriesServiceImpl.fibonacciSeries(number1,number2);
        FibonacciSeriesResponse fibonacciSeriesResponse = FibonacciSeriesResponse.builder()
                .fibonacciSeries(fibonacciSeriesOutput)
                .build();
        return ResponseEntity.ok().body(fibonacciSeriesResponse);
    }
}
