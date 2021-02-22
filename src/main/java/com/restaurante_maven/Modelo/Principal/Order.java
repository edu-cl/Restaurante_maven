/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Principal;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author migue
 */
public class Order {
    private Client client;
    private List<Product> products;
    private int total;
    private LocalDate date;
    private String address;
    private boolean delivered;
    private boolean payed;

    public Order(Client client, int total, String address, boolean delivered, boolean payed) {
        this.client = client;
        this.products = products;
        this.total = total;
        this.date = LocalDate.now();
        this.address = address;
        this.delivered = delivered;
        this.payed = payed;
    }
    
    
    
    public Client getClient() {
        return client;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    
    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    @Override
    public String toString() {
        return "Order{" + "client=" + client + ", products=" + products + ", total=" + total + ", date=" + date + ", address=" + address + ", delivered=" + delivered + ", payed=" + payed + '}';
    }
    
}
