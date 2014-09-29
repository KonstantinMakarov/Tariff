package com.epam.tariff.entity;

/**
 * Created by Kanstantsin_Makarau on 9/25/2014.
 */
public class Tariff {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    private String operatorName;
    private double payroll;
    private double smsPrice;

    private CallPrice callPrice;
    private Parameter parameter;


}
