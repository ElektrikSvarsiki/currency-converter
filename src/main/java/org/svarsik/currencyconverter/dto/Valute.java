package org.svarsik.currencyconverter.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
public class Valute {
    @JacksonXmlProperty(isAttribute = true, localName = "Code")
    private String code;

    @JacksonXmlProperty(isAttribute = true, localName = "Nominal")
    private String nominal;

    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private double value;

    public Valute(String usd, String s, double v) {
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getNominal() {
        return nominal;
    }

    public String getCode() {
        return code;
    }
}
