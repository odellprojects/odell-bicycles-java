package com.bicycles.model.base;

import java.math.BigDecimal;

public abstract class AbstractBikeOption extends AbstractBike{

    protected AbstractBike decoratedBike;

    public AbstractBikeOption(AbstractBike bike) {
        super(bike.getFrameColor());
        decoratedBike = bike;
    }

    /* Methods below are not needed, but are required.
     Pass values back using variable decoratedBike. */
    @Override
    public BigDecimal getSaleValue() {
        return decoratedBike.getSaleValue();
    }

    @Override
    public String getPrefix() {
        return decoratedBike.getPrefix();
    }

    @Override
    public String getWheelType() {
        return decoratedBike.getWheelType();
    }

    @Override
    public int getStartNumber() {
        return decoratedBike.getStartNumber();
    }

}
