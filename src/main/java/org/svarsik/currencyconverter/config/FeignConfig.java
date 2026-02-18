package org.svarsik.currencyconverter.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.xml.JacksonXmlDecoder;

@Configuration
public class FeignConfig {
    @Bean
    public Decoder feignDecoder() {
        XmlMapper xmlMapper = new XmlMapper();
        return new JacksonDecoder(xmlMapper);
    }
}
