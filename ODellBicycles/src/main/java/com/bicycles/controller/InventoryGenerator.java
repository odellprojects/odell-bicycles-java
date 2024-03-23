package com.bicycles.controller;

import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.sub.TouringBike;
import com.bicycles.model.sub.VintageBike;

import java.util.ArrayList;
import java.util.function.Supplier;

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

        for(int i = 0; i < 10; i++) {
            AbstractBike bike = bikeSupply.get();
            bike.setSerialNumber(generator.getNextSerial());
            bikeList.add(i, bike);
        }
    }
}
