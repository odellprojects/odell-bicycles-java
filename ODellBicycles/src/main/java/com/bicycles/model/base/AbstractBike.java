package com.bicycles.model.base;

import com.bicycles.model.impl.Salable;

import java.math.BigDecimal;

/*Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

public abstract class AbstractBike implements Salable {

    // variables
    private FrameColors color;
    private String serialNumber;

    // constructor
    public AbstractBike(FrameColors color) {
        this.color = color;
    }

    // Arrange Abstract Methods
    public abstract BigDecimal getSaleValue();
    public abstract String getPrefix();
    public abstract String getWheelType();
    public abstract int getStartNumber();

    // methods
    public void paintFrame(FrameColors color) {
        this.color = color;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() { return serialNumber; }

    public FrameColors getFrameColor() { return color; }

    public BigDecimal getOptionalAmount() {
        return BigDecimal.valueOf(0.0);
    }

    public String getOptionName() {
        return "";
    }

}
