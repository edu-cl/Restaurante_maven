/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Main;

import com.restaurante_maven.Modelo.Principal.Client;
import com.restaurante_maven.Modelo.Principal.Food;
import com.restaurante_maven.Modelo.Principal.Order;
import com.restaurante_maven.Modelo.Principal.Product;
import com.restaurante_maven.Modelo.Repositorios.RepositoryClients;
import com.restaurante_maven.Modelo.Repositorios.RepositoryOrders;
import com.restaurante_maven.Modelo.Repositorios.RepositoryProduct;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class Ejecutable {
    public static void main(String[] args) {
        RepositoryClients rc=RepositoryClients.instanceRepositoryClients();
        RepositoryOrders ro=RepositoryOrders.getMiRepOrder();
        RepositoryProduct rp=new RepositoryProduct();
        
        /*
        Food f1=new Food("Kebab", 20, true, true);
        List<Integer> productos=new ArrayList<>();
        productos.add(f1.getId());
        
       // System.out.println(productos);
        
        Client c1=new Client("123X", "Eduardo", 20, 0);
        Client c2=new Client("12443X", "fran", 20, 0);
        c1.getAdress().add("Antonrico");
        c1.getAdress().add("Fernan nuñez");
        Order o1=new Order(c1, 20, "Anton rico", true, true, productos);
        Order o2=new Order(c2, 20, "Anton rico", true, true, productos);
        
        ro.getOrders().add(o2);
        ro.getOrders().add(o1);

        c1.getOrder().add(o1.getId());
        c1.getOrder().add(o2.getId());
       
        rc.addClient(c1);
        rc.addClient(c2);
       // System.out.println(rc);
        rc.saveClients("Clients.xml");
        ro.saveOrders("Orders.xml");
        
        */
        //System.out.println(ro.getOrdersByClient("123X"));
        
        
       rc.loadClients("Clients.xml");
       System.out.println(rc);
       
        ro.loadOrders("Orders.xml");
        System.out.println(ro);

       
    }
    
}
