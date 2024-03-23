package com.bicycles.model.sub;

import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.base.AbstractBikeOption;

import java.math.BigDecimal;

public class LeatherGripOption extends AbstractBikeOption {

    public LeatherGripOption(AbstractBike bike) {
        super(bike);
    }

    @Override
    public BigDecimal getOptionalAmount() {
        return BigDecimal.valueOf(49.99);
    }

    @Override
    public String getOptionName() {
        return "Leather Grips option";
    }

}
