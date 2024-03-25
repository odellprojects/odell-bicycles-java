package com.bicycles.view;

import com.bicycles.model.base.AbstractBike;
import com.bicycles.model.base.Accessory;

import java.util.ArrayList;

public class Receipt {
    private ArrayList<AbstractBike> bikeCart;
    private ArrayList<AbstractBike> upgradeCart;
    private ArrayList<Accessory> accessoryCart;
    private double total = 0.0;


    public Receipt(ArrayList<AbstractBike> bikeList, ArrayList<AbstractBike> upgradeList,
                   ArrayList<Accessory> accessoryList) {
        bikeCart = bikeList;
        upgradeCart = upgradeList;
        accessoryCart = accessoryList;
        showTitle();
        showTotal();
    }

    private void showTitle() {
        String company = String.format("%27s", "O'Dell Bicycles");
        System.out.println(company.toUpperCase());
        String address = String.format("%38s", "123 Main St, Kansas City, MO, 64129");
        System.out.println(address);
        String phone = String.format("%27s", "(000) 000 - 0000");
        System.out.println(phone);
        showStars();
        String cash = String.format("%25s", "MONEY RECEIPT");
        System.out.println(cash);
        showStars();
        showColumnHeader();
    }

    private void showColumnHeader() {
        String price = String.format("%28s", "Price");
        System.out.print("Description");
        System.out.println(price);
        showStars();
        showBikeCart();
    }

    private void showBikeCart() {
        if(!bikeCart.isEmpty()) {
            for (AbstractBike bike : bikeCart) {
                System.out.println(bike);
                System.out.println("  Frame Color: " + bike.getFrameColor());
                System.out.println("  Serial #: " + bike.getSerialNumber());
                total += bike.getSaleValue().doubleValue();
                String bikePrice = String.format("%25s", "$" + bike.getSaleValue());
                System.out.println("  Bike Price: " + bikePrice);
                if (!upgradeCart.isEmpty()) {
                    showUpgradeCart(bike);
                }
                System.out.println();
            }
        }
        showAccessoryCart();
    }

    private void showUpgradeCart(AbstractBike bike) {
        for(AbstractBike upgrade : upgradeCart) {
            if(upgrade.toString().equals(bike.toString())) {
                String customPrice = String.format("%20s", "$" + upgrade.getOptionalAmount());
                System.out.print("  " + upgrade.getOptionName());
                System.out.println(customPrice);
                total += upgrade.getOptionalAmount().doubleValue();
            }
        }
    }

    private void showAccessoryCart() {
        if(!accessoryCart.isEmpty()) {
            System.out.println("Accessories");
            for(Accessory item: accessoryCart) {
                System.out.print("  "+item.getItemName());
                String price = String.format("%31s", "$"+item.getSaleValue());
                System.out.println(price);
                System.out.println();
                total += item.getSaleValue().doubleValue();
            }
        }
    }

    private void showTotal() {
        double tax = 1.07;
        double totalWithTax = total * tax;
        double taxAmount = totalWithTax - total;
        showStars();
        System.out.print("Sub Total");
        System.out.printf("%22s %.2f%n", "$", total);
        System.out.print("Sales Tax");
        System.out.printf("%23s %.2f%n", "$", taxAmount);
        System.out.print("Total");

        System.out.printf("%26s %.2f%n", "$",totalWithTax);

        showThanks();
    }

    private void showThanks() {
        System.out.println('\n');
        System.out.println("Thank You for Shopping at O'Dell Bicycles");
        String back = String.format("%28s", "Come back again soon");
        System.out.println(back);
    }

    private void showStars(){
        for(int i = 0; i < 40; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
