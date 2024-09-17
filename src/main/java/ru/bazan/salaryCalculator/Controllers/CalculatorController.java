package ru.bazan.salaryCalculator.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bazan.salaryCalculator.Services.CalculatorServiceImpl;

import java.time.LocalDate;

@RestController
@RequestMapping
public class CalculatorController {
    @Autowired
    private CalculatorServiceImpl calculatorService;

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "averageSalary", required = true) Double averageSalary,
                            @RequestParam(value="vacationDays", required = true) Integer vacationDays,
                            @RequestParam(value = "startDate", required = false)
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate){
        String vacationPayments;

        if (startDate != null) {
            vacationPayments = calculatorService.calculatePayWithHolidays(averageSalary, vacationDays, startDate);
        } else {
            vacationPayments = calculatorService.calculatePay(averageSalary, vacationDays);
        }
        return vacationPayments;
    }

}
