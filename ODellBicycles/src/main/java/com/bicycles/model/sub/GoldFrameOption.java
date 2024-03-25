package com.bicycles.model.sub;

import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.base.AbstractBikeOption;
import com.bicycles.model.base.FrameColors;

import java.math.BigDecimal;

public class GoldFrameOption extends AbstractBikeOption {

    public GoldFrameOption(AbstractBike bike) {
        super(bike);
    }

    @Override
    public BigDecimal getOptionalAmount() {
        return BigDecimal.valueOf(299.99);
    }

    @Override
    public String getOptionName() {
        return "Gold Frame option";
    }

    @Override
    public FrameColors getFrameColor() {
        return FrameColors.GOLD;
    }

    @Override
    public String toString() { return decoratedBike.toString(); }
}
