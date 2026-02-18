package org.svarsik.currencyconverter.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class ValType {
    @JacksonXmlProperty(isAttribute = true, localName = "Type")
    private String type;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Valute")
    private List<Valute> valutes;

    public ValType(List<Valute> usd) {
    }

    public List<Valute> getValutes(){
        return this.valutes;
    }

}
