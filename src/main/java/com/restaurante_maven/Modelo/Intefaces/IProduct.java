/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Intefaces;

import com.restaurante_maven.Modelo.Principal.Product;

/**
 *
 * @author migue
 */
public interface IProduct {
    int[] getBudlePack();
    String getName();
    double getPrice();
    boolean getisForCeliac();
}
