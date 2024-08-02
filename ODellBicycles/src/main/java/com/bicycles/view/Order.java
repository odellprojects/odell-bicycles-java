package com.bicycles.view;

import com.bicycles.controller.InventoryGenerator;
import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.base.Accessory;
import com.bicycles.model.base.FrameColors;
import com.bicycles.model.sub.GoldFrameOption;
import com.bicycles.model.sub.LeatherGripOption;
import com.bicycles.model.sub.LeatherSeatOption;
import com.bicycles.model.sub.WhiteTireOption;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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

public class Order {
    private final ArrayList<AbstractBike> bikeOrder;
    private final ArrayList<AbstractBike> customOptionsList;
    private final ArrayList<Accessory>  accessoryOrder;
    private  Scanner userIn;
    private final InventoryGenerator inventory;
    private AbstractBike bikeChoice;
    private AbstractBike optionsChoice;
    private Accessory bikeExtra;

    public Order() {
        bikeOrder = new ArrayList<>();
        customOptionsList = new ArrayList<>();
        accessoryOrder = new ArrayList<>();
        inventory = new InventoryGenerator();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to ACME Bicycle Company");
        System.out.println("Your one stop shop for Bicycles and Accessories.");
        orderSession();
    }

    private void orderSession() {
        String value = buySomething();
        if(value.isBlank() || value.isEmpty()) {
            value = buySomething();
        }
        if(value.equals("1")) {
            buyAccessories();
        } else {
            buyBikes();
        }
    }

    private String buySomething() {
        System.out.println("Are you here to buy accessories or a bike or both?");
        System.out.println("Your options are:\n1 for Accessories\n2 for a Bike");
        String pattern = "[1-2]+";
        return verifyResult(pattern);
    }
    private void buyBikes() {
        System.out.println("What kind of bike would you like?");
        System.out.println("Your options are:\n1 - Cross Country\n" +
                "2 - DownHill\n3 - Touring\n4 - Vintage");
        String pattern = "[1-4]+";
        String answer = verifyResult(pattern);
        switch (answer) {
            case "1":
                bikeChoice = inventory.getCrossCountryBikeList().get(0);
                inventory.getCrossCountryBikeList().remove(0);
                break;
            case "2":
                bikeChoice = inventory.getDownHillBikeList().get(0);
                inventory.getDownHillBikeList().remove(0);
                break;
            case "3":
                bikeChoice = inventory.getTouringBikeList().get(0);
                inventory.getTouringBikeList().remove(0);
                break;
            case "4":
                bikeChoice = inventory.getVintageBikeList().get(0);
                inventory.getVintageBikeList().remove(0);
                break;
            default:
                buyBikes();
        }

        frameColorOffer(bikeChoice);
        upgradeOffer();
        bikeOrder.add(bikeChoice);
        anotherBike();
        orderDone();
    }

    private void buyAccessories() {
        System.out.println("What Accessories are you interested in?");
        System.out.println("Your options are:\n1 - Helmet\n2 - Gloves\n" +
                "3 - bell\n4 - basket\n5 - tire pump\n6 - bottle + holder\n" +
                "7 - lights");
        String pattern = "[1-7]+";
        String item = userIn.next(pattern);
        accessoryChoice(item);
        accessoryOrder.add(bikeExtra);
        moreAccessories();
    }

    private void accessoryChoice(String item) {
        switch (item) {
            case "1":
                bikeExtra = new Accessory("Helmet", BigDecimal.valueOf(29.99));
                break;
            case "2":
                bikeExtra = new Accessory("Gloves", BigDecimal.valueOf(19.99));
                break;
            case "3":
                bikeExtra = new Accessory("Bell", BigDecimal.valueOf(9.99));
                break;
            case "4":
                bikeExtra = new Accessory("Basket", BigDecimal.valueOf(29.99));
                break;
            case "5":
                bikeExtra = new Accessory("Pump", BigDecimal.valueOf(39.99));
                break;
            case "6":
                bikeExtra = new Accessory("Holder", BigDecimal.valueOf(34.99));
                break;
            case "7":
                bikeExtra = new Accessory("Lights", BigDecimal.valueOf(36.99));
                break;
            default:
                System.out.println("You have entered an incorrect answer.");
                buyAccessories();
        }
    }

    private void frameColorOffer(AbstractBike bike) {
        System.out.println("Our bikes come with a default paint color.");
        System.out.println("Your current frame color is " +
                bike.getFrameColor().toString().toLowerCase());
        System.out.println("Would you like this bike with a different frame color? yes or no");
        String choice = userIn.next();
        switch (choice.toLowerCase()) {
            case "yes":
                changeFrameColor(bike);
                break;
            case "no":
                break;
            default:
                System.out.println("You have entered an incorrect answer.");
                frameColorOffer(bike);
        }
    }

    private void changeFrameColor(AbstractBike bike) {
        System.out.println("What color frame would you like?");
        System.out.println("Your choices are:\n1 - black\n2 - blue\n" +
                "3 - chrome\n4 - green\n5 - red\n6 - gold (extra charge)");
        String pattern = "[1-6]+";
        String answer = verifyResult(pattern);
        switch (answer) {
            case "1":
                bikeChoice.paintFrame(FrameColors.BLACK);
                break;
            case "2":
                bikeChoice.paintFrame(FrameColors.BLUE);
                break;
            case "3":
                bikeChoice.paintFrame(FrameColors.CHROME);
                break;
            case "4":
                bikeChoice.paintFrame(FrameColors.GREEN);
                break;
            case "5":
                bikeChoice.paintFrame(FrameColors.RED);
                break;
            case "6":
                bikeChoice.paintFrame(FrameColors.GOLD);
                optionsChoice = new GoldFrameOption(bikeChoice);
                customOptionsList.add(optionsChoice);
                break;
            default:
                changeFrameColor(bikeChoice);
        }
    }

    private void upgradeOffer() {
        System.out.println("We offer upgrades for your bicycle besides the gold frame color");
        System.out.println("We offer the following:\n1 - leather seat\n2 - leather grips\n" +
                "3 - white tires\n0 - no upgrades");
        String pattern = "[0-3]+";
        String answer = verifyResult(pattern);
        switch (answer) {
            case "0":
                optionsChoice = null;
                break;
            case "1":
                optionsChoice = new LeatherSeatOption(bikeChoice);
                break;
            case "2":
                optionsChoice = new LeatherGripOption(bikeChoice);
                break;
            case "3":
                optionsChoice = new WhiteTireOption(bikeChoice);
                break;
            default:
                upgradeOffer();
        }
        if(optionsChoice != null) {
            customOptionsList.add(optionsChoice);
            moreUpgrades();
        }
    }

    private void moreUpgrades() {
        System.out.println("Do you want to add more Upgrades? yes or no");
        String val = userIn.next();
        switch (val) {
            case "yes":
                upgradeOffer();
                break;
            case "no":
                break;
            default:
                System.out.println("You have entered an incorrect answer.");
                moreUpgrades();
        }
    }

    private void anotherBike() {
        System.out.println("Do you want to add another bike? yes or no");
        String answer = userIn.next();
        switch (answer.toLowerCase()) {
            case "yes":
                bikeChoice = null;
                buyBikes();
                break;
            case "no":
                buyAccessories();
                break;
            default:
                System.out.println("You have entered an incorrect answer.");
                anotherBike();
        }
    }

    private void moreAccessories() {
        System.out.println("Do you want to add more Accessories? yes or no");
        String val = userIn.next();
        switch (val) {
            case "yes":
                bikeExtra = null;
                buyAccessories();
                break;
            case "no":
                break;
            default:
                System.out.println("You have entered an invalid choice");
                moreAccessories();
        }
    }


    private void orderDone() {
        new Receipt(bikeOrder, customOptionsList, accessoryOrder);
    }

    private String verifyResult(String pattern) {
        String answer = "";
        try {
            userIn = new Scanner(System.in);
            answer = userIn.next(pattern);
        } catch (InputMismatchException ex) {
            System.out.println("You have entered an incorrect answer.");
        }
        return answer;
    }
}
