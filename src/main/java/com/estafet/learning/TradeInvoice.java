package com.estafet.learning;


import java.util.Scanner;

public class TradeInvoice extends Invoice implements TradeInvoiceCalculation {
    private int userChoice;

    public TradeInvoice() {
    }

    public TradeInvoice(String clientDetailsInvoice, int invoiceNumber, String bankAccountIndexInvoice,
                        int dateOfReleaseInvoice, long businessDiscountInvoice) {

        super(clientDetailsInvoice, invoiceNumber, bankAccountIndexInvoice, dateOfReleaseInvoice,
                businessDiscountInvoice);
    }

    public TradeInvoice(String clientDetailsInvoice, String[] listWithArticlesInvoice, long totalAmountInvoice,
                        int invoiceNumber, String bankAccountIndexInvoice, int dateOfReleaseInvoice,
                        long businessDiscountInvoice, int vaTInvoice) {

        super(clientDetailsInvoice, listWithArticlesInvoice, totalAmountInvoice, invoiceNumber, bankAccountIndexInvoice,
                dateOfReleaseInvoice, businessDiscountInvoice, vaTInvoice);
    }


    @Override
    public void articles() {
        while (userChoice <= 0 || userChoice > 2) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" \nOrder Number: " + getInvoiceNumber());
            System.out.println("Please select option 1 or option 2");
            System.out.println("1 for: " + "Banana 10kg, Water 10L \n" + "price 25$, price 15$ ");
            System.out.println();
            System.out.println("2 for: " + "Socks, Shoes \n " + "price 5$, price 125$ ");
            if (sc.hasNextInt()) {
                userChoice = sc.nextInt();
            }
            switch (userChoice) {
                case 1:
                    super.setListWithArticlesInvoice(new String[]{"Banana", "Water"});
                    super.setItemPrice(new long[]{25, 15});
                    System.out.println();
                    break;
                case 2:
                    super.setListWithArticlesInvoice(new String[]{"Socks", "Shoes"});
                    super.setItemPrice(new long[]{5, 125});
                    break;
            }

        }

    }

    //   20/100*variable
    public void discountCalculation() {
        double c;
        long a = super.itemAmountCalculation();
        double b = super.getBusinessDiscountInvoice();
        c = a * (b / 100);

        super.setTotalAmountInvoice((long) (a - c));

    }

    public void vatCalculation() {

        //TODO this is always 0 and needs to be fixed!
        long b;
        long a = super.getTotalAmountInvoice();
        b = a * (20 / 100);
        super.setAmountAfterVat(a - b);

    }

    public void priceCalc() {

    }

    public void articlesList() {

    }

    public void discountCalc() {

    }

    public void vatArticles() {

    }
}
