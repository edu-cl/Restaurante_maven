package com.restaurante_maven.Modelo.Principal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client extends Person implements Serializable {

    @XmlElement(name="Direccion")
    protected List<String> adress;
   @XmlElement(name="ID_Pedido")
    protected List<Integer> order;
    private int points;

    public Client(){
    this.adress=new ArrayList<>();
    this.order=new ArrayList<>();
    this.points=0;
    }
    public Client(String DNI, String name, int age, int points) {
        super(DNI, name, age);
        this.adress = new ArrayList<>();
        this.order = new ArrayList<>();
        this.points = points;
    }

    public List<String> getAdress() {
        return adress;
    }

    public void setAdress(List<String> adress) {
        this.adress = adress;
    }

    public List<Integer> getOrder() {
        return order;
    }

    public void setOrder(List<Integer> order) {
        this.order = order;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return super.toString() + "Client{" + "adress=" + adress + ", order=" + order + ", points=" + points + '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        }
        if (obj != null && obj instanceof Client) {
            Client a = (Client) obj;
            if (this.getDNI().toLowerCase().equals(a.getDNI().toLowerCase())) {
                result = true;
            }
        }
        return result;
    }

}
