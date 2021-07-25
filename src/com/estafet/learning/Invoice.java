package com.estafet.learning;

import java.util.Arrays;

public abstract class Invoice {

    private static final String invoiceName = "*Shop Invoice*";// the variable is not inherited in extended classes and cannot be changed it can be only read
    private String clientDetailsInvoice;
    private String[] listWithArticlesInvoice;
    private long[] itemPrice;
    private long totalAmountInvoice;
    private int invoiceNumber;
    private String bankAccountIndexInvoice;
    private int dateOfReleaseInvoice;
    private long businessDiscountInvoice;
    private long amountAfterVat;

    public static String getInvoiceName() {
        return invoiceName;
    }

    private int vaTInvoice;

    public Invoice() {

    }

    public Invoice(String clientDetailsInvoice, int invoiceNumber, String bankAccountIndexInvoice, int dateOfReleaseInvoice, long businessDiscountInvoice) {
        this.clientDetailsInvoice = clientDetailsInvoice;
        this.invoiceNumber = invoiceNumber;
        this.bankAccountIndexInvoice = bankAccountIndexInvoice;
        this.dateOfReleaseInvoice = dateOfReleaseInvoice;
        this.businessDiscountInvoice = businessDiscountInvoice;
    }

    public Invoice(String clientDetailsInvoice, String[] listWithArticlesInvoice, long totalAmountInvoice, int invoiceNumber, String bankAccountIndexInvoice, int dateOfReleaseInvoice, long businessDiscountInvoice, int vaTInvoice) {
        this.clientDetailsInvoice = clientDetailsInvoice;
        this.listWithArticlesInvoice = listWithArticlesInvoice;
        this.totalAmountInvoice = totalAmountInvoice;
        this.invoiceNumber = invoiceNumber;
        this.bankAccountIndexInvoice = bankAccountIndexInvoice;
        this.dateOfReleaseInvoice = dateOfReleaseInvoice;
        this.businessDiscountInvoice = businessDiscountInvoice;
        this.vaTInvoice = vaTInvoice;
    }

    public String getClientDetailsInvoice() {
        return clientDetailsInvoice;
    }

    public void setClientDetailsInvoice(String clientDetailsInvoice) {
        this.clientDetailsInvoice = clientDetailsInvoice;
    }

    public String[] getListWithArticlesInvoice() {
        return listWithArticlesInvoice;
    }

    public void setListWithArticlesInvoice(String[] listWithArticlesInvoice) {
        this.listWithArticlesInvoice = listWithArticlesInvoice;
    }

    public long getTotalAmountInvoice() {
        return totalAmountInvoice;
    }

    public void setTotalAmountInvoice(long totalAmountInvoice) {
        this.totalAmountInvoice = totalAmountInvoice;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getBankAccountIndexInvoice() {
        return bankAccountIndexInvoice;
    }

    public void setBankAccountIndexInvoice(String bankAccountIndexInvoice) {
        this.bankAccountIndexInvoice = bankAccountIndexInvoice;
    }

    public int getDateOfReleaseInvoice() {
        return dateOfReleaseInvoice;
    }

    public void setDateOfReleaseInvoice(int dateOfReleaseInvoice) {
        this.dateOfReleaseInvoice = dateOfReleaseInvoice;
    }

    public long getBusinessDiscountInvoice() {
        return businessDiscountInvoice;
    }

    public void setBusinessDiscountInvoice(long businessDiscountInvoice) {
        this.businessDiscountInvoice = businessDiscountInvoice;
    }

    public int getVaTInvoice() {
        return vaTInvoice;
    }

    public void setVaTInvoice(int vaTInvoice) {
        this.vaTInvoice = vaTInvoice;
    }

    public abstract void vatCalculation();

    public abstract void discountCalculation();

    public abstract void articles();

    public long[] getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(long[] itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "{" + invoiceName + " " +
                "\nInvoice Number: " + invoiceNumber + "\nDate of Release: " + dateOfReleaseInvoice + "\nClient details: " + clientDetailsInvoice +
                "\nList With Articles: " + Arrays.toString(listWithArticlesInvoice) +
                "\nDiscount:" + businessDiscountInvoice + "%" + "\nTotal amount: " + amountAfterVat +
                '}';
    }

    public long getAmountAfterVat() {
        return amountAfterVat;
    }

    public void setAmountAfterVat(long amountAfterVat) {
        this.amountAfterVat = amountAfterVat;
    }

    public long itemAmountCalculation() {
        long amountInvoice = itemPrice[0] + itemPrice[1];
        return amountInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return dateOfReleaseInvoice == invoice.dateOfReleaseInvoice &&
                clientDetailsInvoice.equals(invoice.clientDetailsInvoice) &&// equals is used for object comparison
                bankAccountIndexInvoice.equals(invoice.bankAccountIndexInvoice);
    }

    @Override
    public int hashCode() {//generates integer value that represents the fields and there values
        return clientDetailsInvoice.hashCode()
                + bankAccountIndexInvoice.hashCode() + dateOfReleaseInvoice;
    }
}
