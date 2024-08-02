package com.bicycles.controller;

import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.sub.TouringBike;
import com.bicycles.model.sub.VintageBike;

import java.util.ArrayList;
import java.util.function.Supplier;

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

public class InventoryGenerator {
    private final ArrayList<AbstractBike> touringBikeList = new ArrayList<>();
    private final ArrayList<AbstractBike> vintageBikeList = new ArrayList<>();
    private final ArrayList<AbstractBike> crossCountryBikeList = new ArrayList<>();
    private final ArrayList<AbstractBike> downHillBikeList = new ArrayList<>();
    private final SerialNumberGenerator generator;


    public InventoryGenerator() {
        generator = SerialNumberGenerator.getInstance();
        buildBikeInventory(touringBikeList, () -> new TouringBike());
        buildBikeInventory(vintageBikeList, () -> new VintageBike());
        buildBikeInventory(crossCountryBikeList, () -> new TouringBike());
        buildBikeInventory(downHillBikeList, () -> new VintageBike());
    }

    public ArrayList<AbstractBike> getTouringBikeList() {
        return touringBikeList;
    }

    public ArrayList<AbstractBike> getVintageBikeList() {
        return vintageBikeList;
    }

    public ArrayList<AbstractBike> getCrossCountryBikeList() {
        return crossCountryBikeList;
    }

    public ArrayList<AbstractBike> getDownHillBikeList() {
        return downHillBikeList;
    }

    private void buildBikeInventory(ArrayList<AbstractBike> bikeList, Supplier<AbstractBike> bikeSupply) {
        generator.startGeneration(bikeSupply.get().getPrefix(), bikeSupply.get().getStartNumber());

        for(int i = 0; i < 100; i++) {
            AbstractBike bike = bikeSupply.get();
            bike.setSerialNumber(generator.getNextSerial());
            bikeList.add(i, bike);
        }
    }
}
