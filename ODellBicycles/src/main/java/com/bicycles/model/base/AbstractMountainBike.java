package com.bicycles.model.base;

public abstract class AbstractMountainBike extends AbstractBike{

    public AbstractMountainBike(FrameColors color) {
        super(color);
    }

    @Override
    public String getWheelType() {
        return "Wide Wheel and Tire";
    }
}
