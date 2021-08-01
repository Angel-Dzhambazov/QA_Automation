package com.estafet.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Order {

    // the variable is not inherited in extended classes and cannot be changed it can be only read
    private static final String orderName = "*Shop Order*";

    private int orderNumber;
    private String clientDetails;
    // Changing listWithArticles from array of doubles to list of doubles, by Angel
    private List<String> listWithArticles;
    private Double totalAmount;
    private String accountName;
    private String dateOfActivation;
    private String billingCity;
    private int zipCode;
    private boolean paymentMethod;
    private String orderAuthorizedBy;
    private String dateOfAuthorization;

    // Changing itemPrice from array of doubles to list of doubles, by Angel
    private List<Double> itemPrice;

    public Order() {

    }


    public Order(int orderNumber, int zipCode, String clientDetails, String accountName, String dateOfActivation,
                 String billingCity, String orderAuthorizedBy, String dateOfAuthorization) {
        this.orderNumber = orderNumber;
        this.zipCode = zipCode;
        this.clientDetails = clientDetails;
        this.accountName = accountName;
        this.dateOfActivation = dateOfActivation;
        this.billingCity = billingCity;
        this.orderAuthorizedBy = orderAuthorizedBy;
        this.dateOfAuthorization = dateOfAuthorization;

    }

    public Order(int orderNumber, String clientDetails, List<String> listWithArticles,
                 String accountName, String dateOfActivation, String billingCity, int zipCode, boolean paymentMethod,
                 String orderAuthorizedBy, String dateOfAuthorization, List<Double> itemPrice) {
        this.orderNumber = orderNumber;
        this.clientDetails = clientDetails;
        this.listWithArticles = new ArrayList<String>(listWithArticles);
        this.accountName = accountName;
        this.dateOfActivation = dateOfActivation;
        this.billingCity = billingCity;
        this.zipCode = zipCode;
        this.paymentMethod = paymentMethod;
        this.orderAuthorizedBy = orderAuthorizedBy;
        this.dateOfAuthorization = dateOfAuthorization;
        this.itemPrice = new ArrayList<Double>(itemPrice);
        this.totalAmount = 0.0;
    }

    public List<Double> getItemPrice() {
        return Collections.unmodifiableList(this.itemPrice);
    }

    public void setItemPrice(List<Double> itemPrice) {
        this.itemPrice = new ArrayList<Double>(itemPrice);
    }

    public void addItemPrice(Double itemPrice) {
        this.itemPrice.add(itemPrice);
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

    public Double getTotalAmount() {
        this.calculateTotalAmountOfAllItems();
        return totalAmount;
    }

    protected void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public abstract void articles();

    public List<String> getListWithArticles() {
        return Collections.unmodifiableList(this.listWithArticles);

    }

    public void setListWithArticles(List<String> listWithArticles) {
        this.listWithArticles = new ArrayList<String>(listWithArticles);
    }

    public void addArticleToListWithArticles(String article){
        this.listWithArticles.add(article);
    }

    protected abstract void methodOfPayment(boolean paymentMethod);


    @Override
    public String toString() {

    StringBuilder sb = new StringBuilder();
    sb.append("{" + orderName).append(System.lineSeparator());
    sb.append("Order Number: " + orderNumber).append(System.lineSeparator());
    sb.append("Client details: " + clientDetails).append(System.lineSeparator());
    sb.append("Account: " + accountName).append(System.lineSeparator());
    sb.append("List With Articles: " + listWithArticles.toString()).append(System.lineSeparator());
    sb.append("Order date: " + dateOfActivation).append(System.lineSeparator());
    sb.append("zipCode: " + zipCode).append(System.lineSeparator());
    sb.append("Total amount: " + this.getTotalAmount()).append("}");

    return sb.toString();
    }

    public void calculateTotalAmountOfAllItems() {

        Double zeroValue = 0.0;
        for (Double amount : this.itemPrice) {
            zeroValue += amount;
        }
        totalAmount = zeroValue;
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
                getAccountName().hashCode() + getDateOfActivation().hashCode() +
                getBillingCity().hashCode() + getZipCode() + getOrderAuthorizedBy().hashCode()
                + getDateOfAuthorization().hashCode();
    }
}
