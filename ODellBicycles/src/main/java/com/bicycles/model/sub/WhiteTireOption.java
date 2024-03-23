package com.bicycles.model.sub;

import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.base.AbstractBikeOption;

import java.math.BigDecimal;

public class WhiteTireOption extends AbstractBikeOption {

    public WhiteTireOption(AbstractBike bike) {
        super(bike);
    }

    @Override
    public BigDecimal getOptionalAmount() {
        return BigDecimal.valueOf(29.99);
    }

    @Override
    public String getOptionName() {
        return "White Tire option";
    }

}
