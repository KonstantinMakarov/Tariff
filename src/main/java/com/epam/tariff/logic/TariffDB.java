package com.epam.tariff.logic;

import com.epam.tariff.entity.Tariff;

import java.util.List;

/**
 * Created by Kanstantsin_Makarau on 9/25/2014.
 */
public class TariffDB {
    List<Tariff> data;
    public TariffDB(List<Tariff> data) {
        this.data = data;
        System.out.println(data);
    }
}
