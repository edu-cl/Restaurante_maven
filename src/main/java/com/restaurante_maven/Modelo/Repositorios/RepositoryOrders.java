/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Repositorios;

import com.restaurante_maven.Modelo.Principal.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class RepositoryOrders {

    private List<Order> orders;

    private static RepositoryOrders SingleRepositoryOrders;

    private RepositoryOrders() {
        this.orders = new ArrayList<>();
    }

    public static RepositoryOrders getMiRepOrder() {
        if (SingleRepositoryOrders == null) {
            SingleRepositoryOrders = new RepositoryOrders();
        }
        return SingleRepositoryOrders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void getAllOrders() {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i) instanceof Order) {
                System.out.println(orders.get(i));
            }
        }
        System.out.println(orders);
    }

    public List<Order> getOrdersByClient(String dni) {
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getClient().getDNI().equals(dni)) {
                result.add((Order) orders.get(i));
            }
        }
        return result;
    }

    public List<Order> getOrdersByDate(LocalDate ini, LocalDate end) {
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (ini.isBefore(orders.get(i).getDate()) || ini.equals(orders.get(i).getDate())
                    && end.isAfter(orders.get(i).getDate()) || end.equals(orders.get(i).getDate())) {
                result.add((Order) orders.get(i));
            }
        }
        return result;
    }

    public List<Order> getOrdersNoDelivered() {
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).isDelivered() == false) {
                result.add((Order) orders.get(i));
            }
        }
        return result;
    }

    public List<Order> getOrdersNoPayed() {
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).isPayed() == false) {
                result.add((Order) orders.get(i));
            }
        }
        return result;
    }

    public int getAllInput() {
        int result = 0;
        for (int i = 0; i < orders.size(); i++) {
            result += orders.get(i).getTotal();
        }
        return result;
    }

    public int getInputByDate(LocalDate ini, LocalDate end) {
        int result = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (ini.isBefore(orders.get(i).getDate()) || ini.equals(orders.get(i).getDate())
                    && end.isAfter(orders.get(i).getDate()) || end.equals(orders.get(i).getDate())) {
                result += orders.get(i).getTotal();
            }
        }
        return result;
    }

}
