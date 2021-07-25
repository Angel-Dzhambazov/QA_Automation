package com.estafet.learning;

import java.util.Arrays;

public abstract class Order {
    private static final String orderName = "*Shop Order*";// the variable is not inherited in extended classes and cannot be changed it can be only read
    private int orderNumber;
    private String clientDetails;
    private String[] listWithArticles;
    private long totalAmount;
    private String accountName;
    private String dateOfActivation;
    private String billingCity;
    private int zipCode;
    private boolean paymentMethod;
    private String orderAuthorizedBy;
    private String dateOfAuthorization;
    private long[] itemPrice;

    public long[] getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(long[] itemPrice) {
        this.itemPrice = itemPrice;
    }

    protected boolean isPaymentMethod() {
        return paymentMethod;
    }

    protected void setPaymentMethod(boolean paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    protected String getOrderAuthorizedBy() {
        return orderAuthorizedBy;
    }

    protected void setOrderAuthorization(String orderAuthorizedBy) {
        this.orderAuthorizedBy = orderAuthorizedBy;
    }

    protected String getDateOfAuthorization() {
        return dateOfAuthorization;
    }

    protected void setDateOfAuthorization(String dateOfAuthorization) {
        this.dateOfAuthorization = dateOfAuthorization;
    }

    protected String getAccountName() {
        return accountName;
    }

    protected void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    protected String getDateOfActivation() {
        return dateOfActivation;
    }

    protected void setDateOfActivation(String dateOfActivation) {
        this.dateOfActivation = dateOfActivation;
    }

    protected String getBillingCity() {
        return billingCity;
    }

    protected void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    protected int getZipCode() {
        return zipCode;
    }

    protected void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    protected int getOrderNumber() {
        return orderNumber;
    }

    protected void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    protected String getClientDetails() {
        return clientDetails;
    }

    protected void setClientDetails(String clientDetails) {
        this.clientDetails = clientDetails;
    }

    public void setOrderAuthorizedBy(String orderAuthorizedBy) {
        this.orderAuthorizedBy = orderAuthorizedBy;
    }

    protected long getTotalAmount() {
        return totalAmount;
    }

    protected void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public abstract void articles();

    public String[] getListWithArticles() {
        return listWithArticles;
    }

    public void setListWithArticles(String[] listWithArticles) {
        this.listWithArticles = listWithArticles;
    }

    protected abstract void methodOfPayment(boolean paymentMethod);


    public Order() {

    }


    public Order(int orderNumber, int zipCode, String clientDetails, String accountName, String dateOfActivation, String billingCity, String orderAuthorizedBy, String dateOfAuthorization) {
        this.orderNumber = orderNumber;
        this.zipCode = zipCode;
        this.clientDetails = clientDetails;
        this.accountName = accountName;
        this.dateOfActivation = dateOfActivation;
        this.billingCity = billingCity;
        this.orderAuthorizedBy = orderAuthorizedBy;
        this.dateOfAuthorization = dateOfAuthorization;

    }

    public Order(int orderNumber, String clientDetails, String[] listWithArticles,long totalAmount, String accountName, String dateOfActivation, String billingCity, int zipCode, boolean paymentMethod, String orderAuthorizedBy, String dateOfAuthorization, long[] itemPrice) {
        this.orderNumber = orderNumber;
        this.clientDetails = clientDetails;
        this.listWithArticles = listWithArticles;
        this.totalAmount = totalAmount;
        this.accountName = accountName;
        this.dateOfActivation = dateOfActivation;
        this.billingCity = billingCity;
        this.zipCode = zipCode;
        this.paymentMethod = paymentMethod;
        this.orderAuthorizedBy = orderAuthorizedBy;
        this.dateOfAuthorization = dateOfAuthorization;
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "{" + orderName + " " +
                " \n Order Number: " + orderNumber + "\n Client details: " + clientDetails + "\n Account: " + accountName +
                "\n List With Articles: " + Arrays.toString(listWithArticles) + "\n Order date: " + dateOfActivation +
                "\n zipCode:" + zipCode + "\n Total amount: " + totalAmount +
                '}';
    }

    public void amount() {
        totalAmount = itemPrice[0] + itemPrice[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return
                getZipCode() == order.getZipCode() &&
                getClientDetails().equals(order.getClientDetails()) &&
                getAccountName().equals(order.getAccountName()) &&
                getDateOfActivation().equals(order.getDateOfActivation()) &&
                getBillingCity().equals(order.getBillingCity()) &&
                getOrderAuthorizedBy().equals(order.getOrderAuthorizedBy()) &&
                getDateOfAuthorization().equals(order.getDateOfAuthorization());
    }

    @Override
    public int hashCode() {

        return getClientDetails().hashCode() +
                getAccountName().hashCode()+ getDateOfActivation().hashCode()+
                getBillingCity().hashCode()+ getZipCode()+ getOrderAuthorizedBy().hashCode()
                + getDateOfAuthorization().hashCode();
    }
}
