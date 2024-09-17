package ru.bazan.salaryCalculator.Controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bazan.salaryCalculator.Services.CalculatorServiceImpl;

import java.time.LocalDate;

public class CalculatorControllerTest {

    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    void setUp(){
        calculatorService = new CalculatorServiceImpl();
    }
    @Test
    void testCalculateWithHolidays(){
        String actual = calculatorService.calculatePayWithHolidays(700000.00,
                30, LocalDate.of(2024, 2, 1));
        String expected = "41808.87372013652";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCalculate(){
        String actual = calculatorService.calculatePay(700000.00, 30);
        String expected = "59726.96245733789";
        Assertions.assertEquals(expected, actual);
    }
}
