/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Repositorios;

import java.util.List;
import com.restaurante_maven.Modelo.Principal.Client;
import com.restaurante_maven.Modelo.Principal.Product;
import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;
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
@XmlRootElement(name = "repositoryClients")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepositoryClients {

    @XmlElement(name = "Clientes")
    private List<Client> Clients;

    private static RepositoryClients repositoryClients = null;

    public static RepositoryClients instanceRepositoryClients() {

        if (repositoryClients == null) {
            repositoryClients = new RepositoryClients();

        }
        return repositoryClients;

    }

    private RepositoryClients() {
        Clients = new ArrayList<>();

    }

    public List<Client> getClients() {
        return Clients;
    }

    public void setClients(List<Client> Clients) {
        this.Clients = Clients;
    }

    public List<Client> getAllClients() {
        /*
        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i) instanceof Client) {
                System.out.println(Clients.get(i));
            }
        }
         */
        return Clients;
    }

    public Client searchClientByName(String name) {
        Client result = null;

        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getName() != null && !name.equals("")) {
                if (Clients.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                    result = Clients.get(i);
                }

            }
        }

        return result;
    }

    //Para los menus
    public boolean searchClientByDNI2(String DNI) {
        boolean result = false;

        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getDNI() != null) {
                if (Clients.get(i).getDNI().toLowerCase().equals(DNI.toLowerCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean searchClientByNAME2(String name) {
        boolean result = false;

        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getName() != null) {
                if (Clients.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    public Client searchClientByDNI(String DNI) {
        Client result = null;

        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getDNI() != null) {
                if (Clients.get(i).getDNI().toLowerCase().equals(DNI.toLowerCase())) {
                    result = Clients.get(i);
                }
            }
        }
        return result;
    }

    public Client updateClient(Client c) {
        Scanner teclado = new Scanner(System.in);
        int posicion = Clients.indexOf(c);
        System.out.println("Introduce el DNI nuevo");
        String newDNI = teclado.nextLine();
        c.setDNI(newDNI);
        System.out.println("Introduce el nuevo nombre");
        String nombre = teclado.nextLine();
        c.setName(nombre);
        System.out.println("Introduce la edad nueva");
        int newEdad = teclado.nextInt();
        c.setAge(newEdad);
        Clients.set(posicion, c);
        return c;
    }

    public boolean addClient(Client c) {
        boolean result = false;
        if (c != null) {
            Clients.add(c);
            result = true;

        }
        return result;
    }

    public boolean deleteClient(String dni) {
        boolean result = false;

        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getDNI().equals(dni)) {
                Clients.remove(i);
                result = true;
            }
        }
        return result;
    }

    public boolean deleteClient(Client c) {
        boolean result = false;

        if (Clients.contains(c) == true) {
            Clients.remove(c);
            result = true;

        }
        return result;
    }

    public boolean loadClients(String url) {
        boolean result = false;
        File f = new File(url);
        if (f.exists() && f.isFile()) {
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(RepositoryClients.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                //We had written this file in marshalling example
                RepositoryClients newR = (RepositoryClients) jaxbUnmarshaller.unmarshal(new File(url));
                Clients = newR.Clients;
                result = true;
            } catch (JAXBException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }

    public boolean saveClients(String url) {
        boolean result = false;
        //marshaling
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(RepositoryClients.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the list in console
            //jaxbMarshaller.marshal(_instance, System.out);
            //Marshal the employees list in file
            jaxbMarshaller.marshal(repositoryClients, new File(url));
            result = true;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        return "RepositoryClients{" + "Clients=" + Clients + '}';
    }

}
