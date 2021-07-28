package com.estafet.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TradeOrder extends Order {
    private int userChoice;

    public TradeOrder() {
    }

    public TradeOrder(int orderNumber, int zipCode, String clientDetails, String accountName, String dateOfActivation,
                      String billingCity, String orderAuthorizedBy, String dateOfAuthorization) {
        super(orderNumber, zipCode, clientDetails, accountName, dateOfActivation, billingCity, orderAuthorizedBy,
                dateOfAuthorization);
    }

    public TradeOrder(int orderNumber, String clientDetails, List<String> listWithArticles,
                      String accountName, String dateOfActivation, String billingCity, int zipCode,
                      boolean paymentMethod, String orderAuthorizedBy, String dateOfAuthorization,
                      List<Double> itemPrice) {
        super(orderNumber, clientDetails, listWithArticles, accountName, dateOfActivation, billingCity,
                zipCode, paymentMethod, orderAuthorizedBy, dateOfAuthorization, itemPrice);
    }

    @Override
    public void articles() {
        while (userChoice <= 0 || userChoice > 2) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" \nOrder Number: " + getOrderNumber());
            System.out.println("Please select option 1 or option 2");
            System.out.println("1 for: " + "Banana 10kg, Water 10L \n" + "price 25$, price 15$ ");
            System.out.println();
            System.out.println("2 for: " + "Socks, Shoes \n " + "price 5$, price 125$ ");
            if (sc.hasNextInt()) {
                userChoice = sc.nextInt();
            }
            switch (userChoice) {
                case 1:
                    super.setListWithArticles(new ArrayList<String>(Arrays.asList("Banana", "Water")));
                    super.setItemPrice(new ArrayList<Double>(Arrays. asList(25.0, 15.0)));
                    System.out.println();
                    break;
                case 2:
                    super.setListWithArticles(new ArrayList<String>(Arrays.asList("Socks", "Shoes")));
                    super.setItemPrice(new ArrayList<Double>(Arrays. asList(5.0, 125.0)));
                    break;
            }

        }

    }


    @Override
    public void methodOfPayment(boolean paymentMethod) {
        if (paymentMethod) {
            System.out.println("Chosen payment method is: Online Payment");
        } else {
            System.out.println("Payment method is Cash on delivery receive");
        }
    }
}
