package com.bicycles.model.sub;

import com.bicycles.model.base.AbstractRoadBike;
import com.bicycles.model.base.FrameColors;

import java.math.BigDecimal;

public class TouringBike extends AbstractRoadBike {

    public TouringBike() {
        super(FrameColors.BLUE);
    }

    @Override
    public BigDecimal getSaleValue() {
        return BigDecimal.valueOf(499.99);
    }

    @Override
    public String getPrefix() {
        return "TB901";
    }

    @Override
    public int getStartNumber() {
        return 951357;
    }

    @Override
    public String toString() {
        return "Touring Bike";
    }
}
