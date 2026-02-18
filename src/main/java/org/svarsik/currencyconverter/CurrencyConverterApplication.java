package org.svarsik.currencyconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.svarsik.currencyconverter.feign.CbarClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@EnableFeignClients
@SpringBootApplication
public class CurrencyConverterApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext ctx =  SpringApplication.run(CurrencyConverterApplication.class, args);

        System.out.println(ctx.getBean(CbarClient.class).getRatesXml(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
    }

}
