/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Repositorios;

import com.restaurante_maven.Modelo.Intefaces.IOMController;
import com.restaurante_maven.Modelo.Principal.Order;
import com.restaurante_maven.Modelo.Principal.Product;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class OrderMenuController implements IOMController {

    RepositoryProduct product = new RepositoryProduct();
    RepositoryChart carrito = RepositoryChart.getGetInstance();

    public OrderMenuController() {
    }
    
    

    @Override
    public Product addProduct(int id) {
        Product result = null;
        try {
            if (product.ValidateIdProduct(id) == true) {
                result = product.searchProduct(id);
            }
        } catch (Exception ex) {
            System.out.println("Error al cargar el archivo");
        }
        return result;

    }

    @Override
    public boolean removeProductTheOrder(int id) {
        boolean result = false;

        Product Eliminar = product.searchProduct(id);

        if (carrito.order.getProducts().remove(Eliminar) == true) {
            result = true;
        }

        return result;
    }

    public void setAdress(String a, Order order) {
        if (a != null) {
            order.setAddress(a);
        }
    }

    @Override
    public void savePaid(Order order) {
        if (order != null) {
            order.setPayed(true);
        }
    }

    @Override
    public void saveNoPaid(Order order) {
        if (order != null) {
            order.setPayed(false);
        }
    }

}
