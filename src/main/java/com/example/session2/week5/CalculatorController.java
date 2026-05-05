package com.example.session2.week5;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public int addTwoNumbers(@RequestBody CalculatorRequest request){
        return calculatorService.add(request.getNumber1(), request.getNumber2());
    }

    @PostMapping("/subtract")
    public int subtractTwoNumbers(
            @RequestBody CalculatorRequest request){
        return calculatorService.subtract(request.getNumber1(), request.getNumber2());
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(
            @RequestBody CalculatorRequest request){
        return calculatorService.multiply(request.getNumber1(), request.getNumber2());
    }

    @PostMapping("/divide")
    public int divideTwoNumbers(
            @RequestBody CalculatorRequest request){
        return calculatorService.divide(request.getNumber1(), request.getNumber2());
    }
}
