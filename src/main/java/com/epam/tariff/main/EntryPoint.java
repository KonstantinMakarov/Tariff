package com.epam.tariff.main;

import com.epam.tariff.logic.TariffDB;
import com.epam.tariff.logic.TariffXMLParser;

/**
 * Created by Kanstantsin_Makarau on 9/25/2014.
 */
public class EntryPoint {
    public static void main(String[] args){
        TariffXMLParser tariffXMLParser = new TariffXMLParser("tariff.xml");
        new TariffDB(tariffXMLParser.getData());
    }
}
