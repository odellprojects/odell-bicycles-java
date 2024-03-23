package com.bicycles.model.base;

import com.bicycles.model.impl.Salable;

import java.math.BigDecimal;

public class Accessory implements Salable {

    private final BigDecimal price;
    private final String name;

    public Accessory(String itemName, BigDecimal price) {
        name = itemName;
        this.price = price;
    }

    @Override
    public BigDecimal getSaleValue() {
        return price;
    }

    public String getItemName() { return name; }


}
