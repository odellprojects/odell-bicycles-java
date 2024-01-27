package com.bicycles.model.base;

import com.bicycles.model.impl.Prepared;
import com.bicycles.model.impl.Salable;

import java.math.BigDecimal;

public abstract class AbstractBike implements Prepared,Salable {

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

    // override methods
    @Override
    public String airTires() {
        String airMessage = "We air our bike tires to a consistent 32 psi";
        String testTire = "We test each tire prior to sale for proper tire pressure";
        return airMessage + "\n" + testTire;
    }

    @Override
    public String assembleBike() {
        return "We assemble our bikes using proper torque ratings for your safety.";
    }

    @Override
    public String cleanFrame() {
        String washMessage = "We wash our bike frames with non-abrasive detergent.";
        String rinseMessage ="We rinse and dry our bike frames for a sparkling shine.";
        return washMessage + "\n" + rinseMessage;
    }

    @Override
    public String testRide() {
        return "We test ride our bikes to ensure a proper ride.";
    }
}
