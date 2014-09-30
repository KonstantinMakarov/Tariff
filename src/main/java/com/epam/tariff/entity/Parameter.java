package com.epam.tariff.entity;

/**
 * Created by Kanstantsin_Makarau on 9/25/2014.
 */
public class Parameter {
    private boolean hasFavouriteNumber;
    private double getOperatorPrice;
    private String typeTariff;

    public boolean isHasFavouriteNumber() {
        return hasFavouriteNumber;
    }

    public void setHasFavouriteNumber(boolean hasFavouriteNumber) {
        this.hasFavouriteNumber = hasFavouriteNumber;
    }

    public String getTypeTariff() {
        return typeTariff;
    }

    public void setTypeTariff(String typeTariff) {
        this.typeTariff = typeTariff;
    }

    public double getGetOperatorPrice() {
        return getOperatorPrice;
    }

    public void setGetOperatorPrice(double getOperatorPrice) {
        this.getOperatorPrice = getOperatorPrice;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "hasFavouriteNumber=" + hasFavouriteNumber +
                ", getOperatorPrice=" + getOperatorPrice +
                ", typeTariff='" + typeTariff + '\'' +
                '}';
    }
}
