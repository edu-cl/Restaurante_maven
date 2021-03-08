package com.restaurante_maven.Modelo.Repositorios;

import com.restaurante_maven.Modelo.Principal.Order;


public class RepositoryChart {
   private Order order;
    
    public static  RepositoryChart GetInstance=null;
    
    public static RepositoryChart instanceReposirotyChart() {
    
    if(GetInstance==null){
        GetInstance=new RepositoryChart();
    }
    
    return GetInstance;
}

    public RepositoryChart() {
        order=new Order();
    }

    
    public RepositoryChart(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static RepositoryChart getGetInstance() {
        return GetInstance;
    }


    @Override
    public String toString() {
        return "Chart{" + "order=" + order + '}';
    }
    
    
    
}
