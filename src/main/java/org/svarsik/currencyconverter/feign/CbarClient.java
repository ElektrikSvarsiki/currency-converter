package org.svarsik.currencyconverter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.svarsik.currencyconverter.config.FeignConfig;
import org.svarsik.currencyconverter.dto.CurrencyRatesResponse;

@FeignClient(name = "cbar", url = "${currency.api-url}", configuration = FeignConfig.class)
public interface CbarClient {

    @GetMapping("/{date}.xml")
    CurrencyRatesResponse getRatesXml(@PathVariable String date);
}
