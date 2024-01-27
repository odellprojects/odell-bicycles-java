package com.bicycles.model.sub;

import com.bicycles.model.base.AbstractMountainBike;
import com.bicycles.model.base.FrameColors;

import java.math.BigDecimal;

public class CrossCountry extends AbstractMountainBike {

    public CrossCountry() {
        super(FrameColors.GREEN);
    }

    @Override
    public BigDecimal getSaleValue() {
        return BigDecimal.valueOf(599.99);
    }

    @Override
    public String getPrefix() {
        return "MB605";
    }

    @Override
    public int getStartNumber() {
        return 258456;
    }

    @Override
    public String toString() {
        return "Cross Country Bike";
    }
}
