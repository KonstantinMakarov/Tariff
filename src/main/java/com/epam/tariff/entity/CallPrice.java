package com.epam.tariff.entity;

/**
 * Created by Kanstantsin_Makarau on 9/25/2014.
 */
public class CallPrice {
    private double intraCallPrice;
    private double externalCallPrice;
    private double landLineCallPrice;

    public double getIntraCallPrice() {
        return intraCallPrice;
    }

    public void setIntraCallPrice(double intraCallPrice) {
        this.intraCallPrice = intraCallPrice;
    }

    public double getExternalCallPrice() {
        return externalCallPrice;
    }

    public void setExternalCallPrice(double externalCallPrice) {
        this.externalCallPrice = externalCallPrice;
    }

    public double getLandLineCallPrice() {
        return landLineCallPrice;
    }

    public void setLandLineCallPrice(double landLineCallPrice) {
        this.landLineCallPrice = landLineCallPrice;
    }

    @Override
    public String toString() {
        return "CallPrice{" +
                "intraCallPrice=" + intraCallPrice +
                ", externalCallPrice=" + externalCallPrice +
                ", landLineCallPrice=" + landLineCallPrice +
                '}';
    }
}
