/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Principal;

import com.restaurante_maven.Modelo.Intefaces.IProduct;
import java.io.Serializable;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@XmlRootElement(name="Productos")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Product implements IProduct, Serializable {

    public static int contador = 0;
    private int id;
    private String name;
    private double price;
    private boolean forCeliac;

    public Product(){}
    public Product(String name, double price, boolean forCeliac) {

        this.id = contador++;
        this.name = name;
        this.price = price;
        this.forCeliac = forCeliac;

    }

    public Product(String name) {
        this.id = contador++;
        this.name = name;
        this.price = 0;
        this.forCeliac = false;
    }

  

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean getisForCeliac() {
        return forCeliac;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", forCeliac=" + forCeliac + '}';
    }

    @Override
    public int[] getBudlePack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
