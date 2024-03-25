package com.bicycles.view;

import com.bicycles.controller.InventoryGenerator;
import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.base.Accessory;
import com.bicycles.model.sub.GoldFrameOption;
import com.bicycles.model.sub.LeatherSeatOption;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        Order myOrder = new Order();
        myOrder.welcomeMessage();
    }



    /* Test method used for visual output of the Receipt */
    public static void testReceipt() {
        ArrayList<AbstractBike> bikeList = new ArrayList<>();
        ArrayList<AbstractBike> customUpgradesList = new ArrayList<>();
        InventoryGenerator generator = new InventoryGenerator();

        bikeList.add(generator.getCrossCountryBikeList().get(0));
        bikeList.add(generator.getDownHillBikeList().get(0));
        AbstractBike custom = generator.getVintageBikeList().get(1);
        custom = new LeatherSeatOption(custom);
        custom = new GoldFrameOption(custom);
        bikeList.add(custom);
        customUpgradesList.add(custom);


        ArrayList<Accessory> accessories = new ArrayList<>();
        accessories.add(0, new Accessory("Helmet", BigDecimal.valueOf(29.99)));
        new Receipt(bikeList, customUpgradesList, accessories);
    }

}
