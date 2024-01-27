package com.bicycles.model.base;

public abstract class AbstractBikeOption extends AbstractBike{

    protected AbstractBike decoratedBike;

    public AbstractBikeOption(AbstractBike bike) {
        super(bike.getFrameColor());
        decoratedBike = bike;
    }


}
