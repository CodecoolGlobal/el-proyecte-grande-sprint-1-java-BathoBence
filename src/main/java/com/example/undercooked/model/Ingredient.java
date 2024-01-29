package com.example.undercooked.model;

import org.springframework.jmx.support.MetricType;

public class Ingredient{
    private String name;

    private MetricType metricType;
    private int amount;

    public Ingredient(String name, MetricType metricType) {
        this.name = name;
        this.metricType = metricType;
    }

    public String getName() {
        return name;
    }

    public MetricType getMetricType() {
        return metricType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
