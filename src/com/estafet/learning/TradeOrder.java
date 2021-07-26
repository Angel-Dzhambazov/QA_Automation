package com.estafet.learning;

import java.util.Scanner;

public class TradeOrder extends Order {
    private int userChoice;

    public TradeOrder() {
    }

    public TradeOrder(int orderNumber, int zipCode, String clientDetails, String accountName, String dateOfActivation, String billingCity, String orderAuthorizedBy, String dateOfAuthorization) {
        super(orderNumber, zipCode, clientDetails, accountName, dateOfActivation, billingCity, orderAuthorizedBy, dateOfAuthorization);
    }

    public TradeOrder(int orderNumber, String clientDetails, String[] listWithArticles, long totalAmount, String accountName, String dateOfActivation, String billingCity, int zipCode, boolean paymentMethod, String orderAuthorizedBy, String dateOfAuthorization, long[] itemPrice) {
        super(orderNumber, clientDetails, listWithArticles, totalAmount, accountName, dateOfActivation, billingCity, zipCode, paymentMethod, orderAuthorizedBy, dateOfAuthorization, itemPrice);
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
            }switch (userChoice) {
                case 1:
                    super.setListWithArticles(new String[]{"Banana", "Water"});
                    super.setItemPrice(new long[]{25, 15});
                    System.out.println();
                    break;
                case 2:
                    super.setListWithArticles(new String[]{"Socks", "Shoes"});
                    super.setItemPrice(new long[]{5, 125});
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
