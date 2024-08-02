package com.bicycles.view;

import com.bicycles.controller.InventoryGenerator;
import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.base.Accessory;
import com.bicycles.model.sub.GoldFrameOption;
import com.bicycles.model.sub.LeatherSeatOption;

import java.math.BigDecimal;
import java.util.ArrayList;

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
