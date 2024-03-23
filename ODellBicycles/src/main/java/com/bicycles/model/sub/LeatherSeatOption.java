package com.bicycles.model.sub;

import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.base.AbstractBikeOption;

import java.math.BigDecimal;

public class LeatherSeatOption extends AbstractBikeOption {

    public LeatherSeatOption(AbstractBike bike) {
        super(bike);
    }

    @Override
    public BigDecimal getOptionalAmount() {
        return BigDecimal.valueOf(98.99);
    }

    @Override
    public String getOptionName() {
        return "Leather Seat option";
    }

}
