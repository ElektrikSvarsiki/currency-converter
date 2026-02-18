package org.svarsik.currencyconverter.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@JacksonXmlRootElement(localName = "ValCurs")
@Data
public class CurrencyRatesResponse {
    @JacksonXmlProperty(isAttribute = true, localName = "Date")
    private String date;

    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "Description")
    private String description;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ValType")
    private List<ValType> valTypes;

    public CurrencyRatesResponse(List<ValType> type) {
    }


    public List<ValType> getValTypes(){
        return this.valTypes;
    }

}

