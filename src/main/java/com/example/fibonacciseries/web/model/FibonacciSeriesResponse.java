package com.example.fibonacciseries.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FibonacciSeriesResponse {
    private List<Integer> fibonacciSeries;
}
