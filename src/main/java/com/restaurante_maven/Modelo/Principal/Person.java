/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante_maven.Modelo.Principal;

/**
 *
 * @author migue
 */
public class Person {
    private String DNI;
    private String name;
    private int age;

    public Person(String DNI, String name, int age) {
        this.DNI = DNI;
        this.name = name;
        this.age = age;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "DNI=" + DNI + ", name=" + name + ", age=" + age + '}';
    }
    
    
}
