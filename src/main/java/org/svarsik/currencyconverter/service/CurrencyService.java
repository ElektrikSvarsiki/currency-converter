package org.svarsik.currencyconverter.service;

import org.springframework.stereotype.Service;
import org.svarsik.currencyconverter.dto.CurrencyRatesResponse;
import org.svarsik.currencyconverter.dto.ValType;
import org.svarsik.currencyconverter.dto.Valute;
import org.svarsik.currencyconverter.feign.CbarClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    private final CbarClient cbarClient;

    public CurrencyService(CbarClient cbarClient) {
        this.cbarClient = cbarClient;
    }

    public Map<String, Double> getRates(String date) {
        CurrencyRatesResponse response = cbarClient.getRatesXml(date);


        Map<String, Double> rates = new HashMap<>();

        for (ValType valType : response.getValTypes()) {
            for (Valute valute : valType.getValutes()) {
                rates.put(valute.getCode(), valute.getValue() / Integer.parseInt(valute.getNominal().replaceAll("[^0-9]", "")) );
            }
        }

        rates.put("AZN", 1.0);

        return rates;
    }

    public double convert(String from, String to, double amount, String date) {
        Map<String, Double> rates = getRates(date);

        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            throw new IllegalArgumentException("Unknown currency code: " + from + " or " + to);
        }

        double fromRate = rates.get(from);
        double toRate = rates.get(to);

        return amount * fromRate / toRate;
    }
}
