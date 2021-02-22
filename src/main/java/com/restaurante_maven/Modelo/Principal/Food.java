/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Principal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class Food extends Product {

    private boolean ForVegans;
    private  int[] BudlePack={};

    public Food(String name, double price, boolean forCeliac, boolean veg ) {
        super(name, price, forCeliac);   
        this.BudlePack=BudlePack;
        this.ForVegans = veg;
    }
        public Food(String name) {
        super(name);   
        this.BudlePack=BudlePack;
        this.ForVegans = false;
    }

    public boolean isForVegans() {
        return ForVegans;
    }

    public void setForVegans(boolean ForVegans) {
        this.ForVegans = ForVegans;
    }

    public int[] getBudlePack() {
        return BudlePack;
    }

    public void setBudlePack(int[] lista) {
        this.BudlePack = lista;
    }
  
    

    @Override
    public String toString() {
        return "\n" + super.toString() + "Food{" + "forVegans=" + ForVegans + '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        }
        if (obj != null && obj instanceof Food) {
            Product a = (Food) obj;
            if (this.getId() == a.getId()) {
                result = true;
            }
        }
        return result;
    }



}
