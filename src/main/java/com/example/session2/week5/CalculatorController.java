package com.example.session2.week5;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

//    @GetMapping("/add")
//    public int addTwoNumbers(@RequestParam int number1,
//                             @RequestParam int number2)
//    {return number1 + number2;}

    @GetMapping("/add")
    public int addTwoNumbers (@RequestBody CalculatorAddRequest request){
        return calculatorService.add(request.getNumber1(), request.getNumber2());

    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(
            @RequestBody CalculatorMultiplyRequest request){
        return calculatorService.multiply(request.getNumber1(), request.getNumber2());
    }
}
