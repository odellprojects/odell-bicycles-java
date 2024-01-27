package com.bicycles.model.base;

import java.math.BigDecimal;

public abstract class AbstractRoadBike extends AbstractBike{

    public AbstractRoadBike(FrameColors color) {
        super(color);
    }

    // Override methods
    @Override
    public String getWheelType() {
        return "Normal Wheel and Tire";
    }

}
