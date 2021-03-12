package com.restaurante_maven.Modelo.Repositorios;

import com.restaurante_maven.Modelo.Principal.Client;
import com.restaurante_maven.Modelo.Principal.Drink;
import com.restaurante_maven.Modelo.Principal.Food;
import com.restaurante_maven.Modelo.Principal.Product;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProduct {

    private List<Product> productos;

    Drink d1 = new Drink("Coca Cola", 1.5, false, false);
    int[] i1 = {3, 4};
    Drink d2 = new Drink("Nestea", 1, true, false);
    Drink d3 = new Drink("Larios", 1.5, true, true);
    int[] i3 = {0};
    Food f1 = new Food("Kebab", 3.5, false, true);
    int[] c1 = {1};
    Food f2 = new Food("Patatas", 1.5, true, true);
    Food f3 = new Food("Pizza", 5, true, true);

    public RepositoryProduct() {
        productos = new ArrayList<>();
        d1.setBudlePack(i1);
        d3.setBudlePack(i3);
        f1.setBudlePack(c1);
        productos.add(d1);
        productos.add(d2);
        productos.add(d3);
        productos.add(f1);
        productos.add(f2);
        productos.add(f3);
    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

    //Modificar para que devuelva el array de entero.
    public int[] getBundleProduct(Product p) {
        // int[] result;

        /*
        for (int i = 0; i < p.getBudlePack().length; i++) {

            result = searchProduct(p.getBudlePack()[i]);
            System.out.println(result);
        }
         */
        return p.getBudlePack();
    }

    public List<Product> getAllDrink() {
        List<Product> p1 = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Drink) {
                p1.add(productos.get(i));
            }
        }
        return p1;
    }

    public List<Product> getAllFood() {
        List<Product> p1 = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Food) {
                p1.add(productos.get(i));
            }
        }
        return p1;
    }

    public List<Product> getAllProducts() {
        List<Product> p1 = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Product) {
                p1.add(productos.get(i));
            }
        }
        return p1;
    }

    public List<Drink> getAllNoAlcoholicDrink() {
        List<Drink> result = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Drink) {
                Drink aux = (Drink) productos.get(i);
                if (aux.isAlcoholic() == false) {
                    result.add(aux);
                }
            }
        }
        return result;
    }

    public List<Drink> getAllAlcoholicDrink() {
        List<Drink> result = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Drink) {
                Drink aux = (Drink) productos.get(i);
                if (aux.isAlcoholic() != false) {
                    result.add(aux);
                }
            }
        }
        return result;
    }

    public List<Food> getAllForVegansFood() {
        List<Food> result = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Food) {
                Food aux = (Food) productos.get(i);
                if (aux.isForVegans() != false) {
                    result.add(aux);
                }
            }
        }
        return result;
    }

    public Product searchProduct(String name) throws Exception {
        Product result = null;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getName() != null && !name.equals("")) {
                if (productos.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                    result = productos.get(i);
                }
            }

        }
        return result;
    }

    public Product searchProduct(int id){
        Product result = null;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getName() != null) {
                if (productos.get(i).getId() == id) {
                    result = productos.get(i);
                }
            }

        }
        return result;
    }
    
        public boolean ValidateIdProduct(int id) {
        boolean result = false;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getName() != null) {
                if (productos.get(i).getId() == id) {
                    result = true;
                }
            }

        }
        return result;
    }
    

    public Product searchDrinks(String name) {
        Product result = new Drink("Desconocido");

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getName() != null && !name.equals("")) {
                if (productos.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                    if (productos.get(i) instanceof Drink) {
                        result = productos.get(i);
                    }
                }
            }

        }
        return result;
    }

    public Product searchFood(String name) {
        Product result = new Food("Desconocido");

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getName() != null && !name.equals("")) {
                if (productos.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                    if (productos.get(i) instanceof Food) {
                        result = productos.get(i);
                    }
                }
            }

        }
        return result;
    }        

}
