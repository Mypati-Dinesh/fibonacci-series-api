package com.example.fibonacciseries.repository.impl;

import com.example.fibonacciseries.model.UserModel;
import com.example.fibonacciseries.repository.FibonacciSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FibonacciSeriesRepositoryImpl implements FibonacciSeriesRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int userRegistration(UserModel userModel) {
        String sql = "INSERT INTO FIBONACCI_USER(USER_NAME,USER_PASSWORD,EMAIL,ADDRESS,PHONE_NO) values (?,?,?,?,?)";
        Object[] userModelDetails = {
                userModel.getUserName(),
                userModel.getUserPassword(),
                userModel.getEmail(),
                userModel.getAddress(),
                userModel.getUserPhoneNo()
        };
        return jdbcTemplate.update(sql, userModelDetails);
    }

    @Override
    public UserModel checkUser(String userName) {
        String sql = " SELECT USER_NAME,USER_PASSWORD FROM FIBONACCI_USER WHERE USER_NAME = :userName ;";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("userName", userName);
        List<UserModel> userModelList = namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, (rs, rowNum) ->
                UserModel.builder()
                        .userName(rs.getString("USER_NAME"))
                        .userPassword(rs.getString("USER_PASSWORD"))
                        .build());
        return userModelList.isEmpty() ? null: userModelList.get(0);
    }
}
