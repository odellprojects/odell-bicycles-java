package com.bicycles.model.sub;

import com.bicycles.model.base.AbstractMountainBike;
import com.bicycles.model.base.FrameColors;

import java.math.BigDecimal;

public class DownhillBike extends AbstractMountainBike {

    public DownhillBike() {
        super(FrameColors.BLACK);
    }

    @Override
    public BigDecimal getSaleValue() {
        return BigDecimal.valueOf(699.99);
    }

    @Override
    public String getPrefix() {
        return "DB505";
    }

    @Override
    public int getStartNumber() {
        return 852654;
    }

    @Override
    public String toString() {
        return "Downhill Bike";
    }
}
