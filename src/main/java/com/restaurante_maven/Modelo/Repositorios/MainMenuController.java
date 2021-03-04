/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Repositorios;
import com.restaurante_maven.Modelo.Intefaces.IMMController;
import com.restaurante_maven.Modelo.Principal.Client;
import com.restaurante_maven.Modelo.Principal.Order;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
/**
 *
 * @author migue
 */
public class MainMenuController implements IMMController{

    @Override
    public Order newOrder(Client c, LocalDateTime d) {
        Order result = new Order(c, "Default");
        if(c!=null&&d!=null){
            RepositoryOrders r=RepositoryOrders.getMiRepOrder();
            r.getOrders().add(result);
            
        }
        return result;
    }


    @Override
    public Order changeOrder(Client c, int id) {
        RepositoryOrders ordener=RepositoryOrders.getMiRepOrder();
        Order result = null;
        Order Abuscar=new Order(id);
        if(c!=null){
            for(int i=0;i<c.getOrder().size();i++){
                if(c.getOrder().contains(Abuscar)){
                    result=ordener.getOrdersById(id);
                }
            }
        }
        return result;
    }

    @Override
    public boolean deleteOrder(Client c, int id) {
        boolean result =false;
        Order aborrar=new Order(id);
        if(c!=null){
            for(int i=0;i<c.getOrder().size()&&result!=false;i++){
                if(c.getOrder().contains(aborrar)){
                    c.getOrder().remove(c.getOrder().indexOf(aborrar));
                    result=true;
                }
            }
        }
        
        return result;
    }



    @Override
    public int cashToday() {
        RepositoryOrders r=RepositoryOrders.getMiRepOrder();
        return r.getInputByDate(LocalDate.now(), LocalDate.now());
    }

    @Override
    public int cashThisMonth() {
        RepositoryOrders r=RepositoryOrders.getMiRepOrder();
        return r.getInputByDate(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()), LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
    }
    

    @Override
    public int cashTotal() {
        int result=0;
        RepositoryOrders r=RepositoryOrders.getMiRepOrder();
        result=r.getAllInput();
        return result;
    }

    @Override
    public void viewOrdersNotPayed() {
        RepositoryOrders r=RepositoryOrders.getMiRepOrder();
        System.out.println(r.getOrdersNoPayed());
    }

    @Override
    public void viewOrdersPendingDelivered() {
        RepositoryOrders r=RepositoryOrders.getMiRepOrder();
        System.out.println(r.getOrdersNoDelivered());
    }
}
