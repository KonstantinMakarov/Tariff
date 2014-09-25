package com.epam.tariff.logic;

import com.epam.tariff.entity.Tariff;

import java.util.ArrayList;

public class TariffXMLParser {
    private ArrayList<Tariff> tariffs = new ArrayList<Tariff>();
    private String xmlFileName;

    public TariffXMLParser(String xmlFileName) {
        this.xmlFileName = xmlFileName;
        parse();
    }

    public ArrayList<Tariff> getData() {
        return tariffs;
    }

    public void parse() {

    }
}
