/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Repositorios;

import com.restaurante_maven.Modelo.Principal.Order;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@XmlRootElement(name = "repositoryOrders")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepositoryOrders {

    @XmlElement(name = "Pedidos")
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

    public Order getOrdersById(int id){
        Order result=new Order(id);
        
        for(int i =0;i<orders.size();i++){
            if(orders.get(i).getId()==id){
                result=orders.get(i);
            }
        }
        return result;
    }
    public List<Order> getOrdersByClient(String dni) {
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getClient().getDNI().equals(dni)) {
                result.add((orders.get(i)));
            }
        }
        return result;
    }

    public List<Order> getOrdersByDate(LocalDate ini, LocalDate end) {
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (ini.isBefore(orders.get(i).getDate()) || ini.equals(orders.get(i).getDate())
                    && end.isAfter(orders.get(i).getDate()) || end.equals(orders.get(i).getDate())) {
                result.add((orders.get(i)));
            }
        }
        return result;
    }

    public List<Order> getOrdersNoDelivered() {
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).isDelivered() == false) {
                result.add((orders.get(i)));
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

    public boolean loadOrders(String url) {
        boolean result=false;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(RepositoryOrders.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            //We had written this file in marshalling example
            RepositoryOrders newR = (RepositoryOrders) jaxbUnmarshaller.unmarshal(new File(url));
            System.out.println(newR);
            orders = newR.orders;
            result = true;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public boolean saveOrders(String url) {
        boolean result = false;
        //marshaling
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(RepositoryOrders.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the list in console
            //jaxbMarshaller.marshal(_instance, System.out);
            //Marshal the employees list in file
            jaxbMarshaller.marshal(SingleRepositoryOrders, new File(url));
            result=true;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String toString() {
        return "RepositoryOrders{" + "orders=" + orders + '}';
    }
    
    

}
