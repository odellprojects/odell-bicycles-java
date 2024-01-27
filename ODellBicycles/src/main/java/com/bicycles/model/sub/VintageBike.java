package com.bicycles.model.sub;

import com.bicycles.model.base.AbstractRoadBike;
import com.bicycles.model.base.FrameColors;

import java.math.BigDecimal;

public class VintageBike extends AbstractRoadBike {

    public VintageBike() {
        super(FrameColors.RED);
    }

    @Override
    public BigDecimal getSaleValue() {
        return BigDecimal.valueOf(299.99);
    }

    @Override
    public String getPrefix() {
        return "VB801";
    }

    @Override
    public int getStartNumber() {
        return 753159;
    }

    @Override
    public String toString() {
        return "Vintage Bike";
    }
}
