package com.bicycles.model.base;

import com.bicycles.model.impl.Salable;

import java.math.BigDecimal;

public abstract class AbstractBike implements Salable {

    // variables
    private FrameColors color;
    private String serialNumber;

    // constructor
    public AbstractBike(FrameColors color) {
        this.color = color;
    }

    // Arrange Abstract Methods
    public abstract BigDecimal getSaleValue();
    public abstract String getPrefix();
    public abstract String getWheelType();
    public abstract int getStartNumber();

    // methods
    public void paintFrame(FrameColors color) {
        this.color = color;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() { return serialNumber; }

    public FrameColors getFrameColor() { return color; }

    public BigDecimal getOptionalAmount() {
        return BigDecimal.valueOf(0.0);
    }

    public String getOptionName() {
        return "";
    }

}
