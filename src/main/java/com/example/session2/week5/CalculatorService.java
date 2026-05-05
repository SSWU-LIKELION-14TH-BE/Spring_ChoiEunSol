package com.example.session2.week5;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int number1, int number2){
        return number1 + number2;
    }

    public int subtract(int number1, int number2){
        return number1 - number2;
    }

    public int multiply(int number1, int number2){
        return number1 * number2;
    }

    public int divide(int number1, int number2){
        if(number2 == 0){
            throw new IllegalArgumentException("0으로 나눌 수 없음");
        }
        return number1 / number2;
    }
}
