package org.svarsik.currencyconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.svarsik.currencyconverter.service.CurrencyService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    // Example: GET /currency/convert/USD/EUR/100
    @GetMapping("/convert/{from}/{to}/{amount}")
    public double convert(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable double amount
    ) {
        String date = LocalDate.now(ZoneId.of("Asia/Baku"))
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return service.convert(from.toUpperCase(), to.toUpperCase(), amount, date);
    }
}
