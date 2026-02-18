package org.svarsik.currencyconverter.service;

import org.junit.jupiter.api.Test;
import org.svarsik.currencyconverter.dto.CurrencyRatesResponse;
import org.svarsik.currencyconverter.dto.ValType;
import org.svarsik.currencyconverter.dto.Valute;
import org.svarsik.currencyconverter.feign.CbarClient;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CurrencyServiceTest {

    private CbarClient cbarClient = mock(CbarClient.class);
    private CurrencyService service = new CurrencyService(cbarClient);


    @Test
    void convert_shouldWork() {

        Map<String, Double> fakeRates = Map.of(
                "USD", 1.7,
                "EUR", 1.9,
                "AZN", 1.0
        );

        CurrencyService spy = spy(service);
        doReturn(fakeRates).when(spy).getRates(any());

        double result = spy.convert("USD", "EUR", 10, "18.02.2026");

        assertEquals(10 * 1.7 / 1.9, result);
    }

    @Test
    void convert_shouldThrowForUnknownCurrency() {
        CurrencyService spy = spy(service);
        doReturn(Map.of("AZN", 1.0)).when(spy).getRates(any());

        assertThrows(IllegalArgumentException.class,
                () -> spy.convert("USD", "AZN", 10, "18.02.2026"));
    }
}
