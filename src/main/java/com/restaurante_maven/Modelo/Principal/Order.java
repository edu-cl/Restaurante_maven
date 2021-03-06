/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Principal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    
    public static int contador = 0;
    @XmlElement(name="ID")
    private int id;
    @XmlElement(name="Cliente")
    private Client client;
    @XmlElement(name="Productos")
    private List<Integer> products;
    private int total;
    @XmlElement(name="Fecha")
    private LocalDate date;
    private String address;
    private boolean delivered;
    private boolean payed;

    public Order() {
        this.id = contador++;
        this.client = new Client();
        this.products = new ArrayList<>();
        this.date = LocalDate.now();
        this.address = "";
        this.delivered = false;
        this.payed = false;
    }

    public Order(Client client, int total, String address, boolean delivered, boolean payed, List<Integer> p) {
        this.id = contador++;
        this.client = client;
        this.products = p;
        this.total = total;
        this.date = LocalDate.now();
        this.address = address;
        this.delivered = delivered;
        this.payed = payed;
    }

    public Order(int id) {
        this.id = id;
    }

    public Order(Client c, String direccion) {
        this.id = contador++;
        this.client = c;
        this.products = new ArrayList<>();
        this.total = 0;
        this.date = LocalDate.now();
        this.address = direccion;
        this.delivered = false;
        this.payed = false;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public List<Integer> getProducts() {
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
        String result = "";

        if (products == null) {
            result = "Order{" + "client=" + client + ", products=" + "Vacio" + ", total=" + total + ", date=" + date + ", address=" + address + ", delivered=" + delivered + ", payed=" + payed + '}';

        } else {
            result = "Order{" + "client=" + client + ", products=" + products + ", total=" + total + ", date=" + date + ", address=" + address + ", delivered=" + delivered + ", payed=" + payed + '}';

        }
        return result;
    }
    
        @Override
        public boolean equals(Object obj) {
        boolean result=false;
        if (this == obj) {
            result=true;
        }
        if(obj!=null){
            if(obj instanceof Order){
                Order a=(Order) obj;
            if(this.client==a.getClient()){
                result=true;
            }
        }
        }
        return result;
    }
}
