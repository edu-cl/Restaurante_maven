package com.restaurante_maven.Modelo.GUI;

import AppController.AppController;
import com.restaurante_maven.Modelo.Principal.Client;
import com.restaurante_maven.Modelo.Principal.Order;
import com.restaurante_maven.Modelo.Principal.Product;
import com.restaurante_maven.Modelo.Repositorios.RepositoryChart;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI {

    public static AppController controller = new AppController();
    public static Client c = null;

    public static void opciones_principales(int opcion) {
        if (opcion > -1 && opcion <= 2) {
            switch (opcion) {
                case 1:
                    IniciarSesion();
                    break;

                case 2:
                    Registro();
                    break;
            }

        } else {
            System.out.println("Opcion no valida, por favor introduce una opcion correcta");
        }
    }

    public static boolean IniciarSesion() {
        boolean result = false;

        System.out.println("\n+-------------------+");
        System.out.println("|   Iniciar Sesion  |");
        System.out.println("+-------------------+");
        String dni = patronDni();
        String nombre = devolverString("Introduce tu nombre: ");
        if (dni != null && nombre != null && controller.clients.searchClientByDNI2(dni)) {
            if (controller.clients.searchClientByDNI(dni).getName().equals(nombre)) {
                c = controller.clients.searchClientByDNI(dni);

                result = true;
                if (c != null) {
                    sub_menu(c);
                } else {
                    System.out.println("El DNI que has introducido esta repetido");
                }
            } else {
                System.out.println("El cliente no existe o (DNI o nombre invalidos)");
            }

        } else {
            System.out.println("El cliente no existe o (DNI o nombre invalidos)");
        }
        return result;
    }

    public static boolean Registro() {
        boolean result = false;

        String dni = patronDni();
        if (dni != null && !controller.clients.searchClientByDNI2(dni)) {

            String name = devolverString("Introduce el nombre: ");
            int age = -1;
            while (age < 0) {
                age = devolverInt("Introduce la edad: ");
                if (age >= 0 && age <= 130) {

                } else {
                    System.out.println("Introduce un numero entre el 0 y el 130");
                    age = -1;
                }
            }

            int points = -1;
            while (points < 0) {
                points = devolverInt("Introduce los puntos: ");
                if (points >= 0 && points <= 999) {

                } else {
                    System.out.println("Introduce un numero entre el 0 y el 999");
                    points = -1;
                }
            }

            Client c1 = new Client(dni, name, age, points);
            controller.clients.addClient(c1);
            result = true;
            System.out.println("El cliente ha sido creado con exito");

        } else {
            System.out.println("El DNI introducido ya esta en la lista");
        }

        return result;

    }

    public static void sub_menu(Client c) {
        int numero;

        do {
            System.out.println("\n+-------------------------------------+");
            System.out.println("|Cliente: " + c.getName() + " | DNI: " + c.getDNI());
            System.out.println("+-------------------------------------+");
            System.out.println("| 1) Productos                        |");
            System.out.println("| 2) Ordenes                          |");
            System.out.println("| 3) Perfil          	              |");
            System.out.println("| 4) Carrito          	              |");
            System.out.println("| 0) Salir                            |");
            System.out.println("+-------------------------------------+");

            numero = devolverInt("Introduce una opción: ");
            switch (numero) {
                case 1:
                    menu_productos(c);
                    break;
                case 2:
                    menu_ordenes(c);
                    break;
                case 3:
                    menu_perfil(c);
                    break;
                case 4:
                    menu_carrito(c);
                    break;
                case 0:
                    controller.orders.saveOrders("orders.xml");
                    controller.clients.saveClients("clients.xml");
                    break;
            }
        } while (numero != 0);
    }

    public static void menu_principal() {
        controller.orders.loadOrders("orders.xml");
        controller.clients.loadClients("clients.xml");
        logo();
        int numero;
        System.out.println("Bienvenido al restaurante");
        do {
            System.out.println("\n+--------------------+");
            System.out.println("|        Menu        |");
            System.out.println("+--------------------+");
            System.out.println("| 1) Iniciar Sesion  |");
            System.out.println("| 2) Registrarse     |");
            System.out.println("| 0) Salir           |");
            System.out.println("+--------------------+");

            numero = devolverInt("Introduce una opción: ");
            opciones_principales(numero);
        } while (numero != 0);
    }

    public static void menu_productos(Client c) {
        int numero;
        do {
            System.out.println("\n+-------------------------------------+");
            System.out.println("|Cliente: " + c.getName() + " | DNI: " + c.getDNI());
            System.out.println("+-------------------------------------+");
            System.out.println("| 1) Ver todos los productos          |");
            System.out.println("| 2) Ver comida                       |");
            System.out.println("| 3) Ver bebida                       |");
            System.out.println("| 4) Ver bebida alcoholica            |");
            System.out.println("| 5) Ver comida vegana                |");
            System.out.println("| 0) Salir                            |");
            System.out.println("+-------------------------------------+");

            numero = devolverInt("Introduce una opción: ");
            switch (numero) {
                case 1:
                    System.out.println(controller.product.getAllProducts());
                    pulsaEnter();
                    break;
                case 2:
                    System.out.println(controller.product.getAllFood());
                    pulsaEnter();
                    break;

                case 3:
                    System.out.println(controller.product.getAllDrink());
                    pulsaEnter();
                    break;
                case 4:
                    System.out.println(controller.product.getAllAlcoholicDrink());
                    pulsaEnter();
                    break;
                case 5:
                    System.out.println(controller.product.getAllForVegansFood());
                    pulsaEnter();
                    break;
            }
        } while (numero != 0);
    }

    public static void menu_carrito(Client c) {
        int numero;
        do {
            System.out.println("\n+-------------------------------------+");
            System.out.println("|Cliente: " + c.getName() + " | DNI: " + c.getDNI());
            System.out.println("| 1) Crear nueva orden                |");
            System.out.println("| 2) Añadir un producto               |");
            System.out.println("| 3) Eliminar un producto             |");
            System.out.println("| 0) Salir                            |");
            System.out.println("+-------------------------------------+");

            numero = devolverInt("Introduce una opción: ");
            switch (numero) {
                case 1:
                    Order c1;

                    String direccion = devolverString("Introduce tu direccion: ");

                    c1 = new Order(c, direccion);
                    controller.orders.getOrders().add(c1);
                    c.getOrder().add(c1.getId());
                    controller.carrito.setOrder(c1);
                    pulsaEnter();
                    break;
                case 2:
                    System.out.println(controller.product.getAllProducts());
                    try {
                        int id = devolverInt("Introduce el id del producto: ");
                        if (controller.product.getAllProducts().size() > id) {
                            controller.carrito.getOrder().getProducts().add(id);
                            System.out.println("Se ha añadido al carrito con exito el siguiente producto: " + controller.product.searchProduct(id).getName());
                            controller.carrito.getOrder().setTotal(controller.carrito.getOrder().getTotal() + controller.product.searchProduct(id).getPrice());
                        } else {
                            System.out.println("Introduce un id valido (entre el 0 y el 5)");
                        }
                    } catch (Exception ex) {
                        System.out.println("Error al añadir");
                    }

                    pulsaEnter();
                    break;

                case 3:
                    try {
                    System.out.println(controller.carrito.getOrder().getProducts());

                    Integer pos = devolverInt("Introduce el ID del producto a borrar ");

                    if (controller.carrito.getOrder().getProducts().contains(pos) == true) {
                        System.out.println("Se ha borrado de tu orden el siguiente producto: " + controller.product.searchProduct(pos).getName());

                        controller.carrito.getOrder().getProducts().remove(pos);
                        if (controller.carrito.getOrder().getTotal() > 0) {
                            controller.carrito.getOrder().setTotal(controller.carrito.getOrder().getTotal() - controller.product.searchProduct(pos).getPrice());
                        }

                        System.out.println("Ese producto no esta en la orden");
                        pulsaEnter();
                    } else {
                        System.out.println("No existe ese Producto en el pedido");
                    }
                } catch (Exception e) {
                    System.out.println("Error al eliminar");

                }

                break;
            }
        } while (numero != 0);
    }

    public static void menu_perfil(Client c) {
        int numero;
        do {
            System.out.println("\n+-------------------------------------+");
            System.out.println("|Cliente: " + c.getName() + " | DNI: " + c.getDNI());
            System.out.println("+-------------------------------------+");
            System.out.println("| 1) Cambiar nombre del cliente       |");
            System.out.println("| 2) Cambiar la edad del cliente      |");
            System.out.println("| 3) Añadir dirección a la cuenta     |");
            System.out.println("| 0) Salir                            |");
            System.out.println("+-------------------------------------+");

            numero = devolverInt("Introduce una opción: ");
            switch (numero) {
                case 1:

                    c = controller.clients.searchClientByDNI(c.getDNI());
                    c.setName(devolverString("Introduce el nuevo nombre"));
                    System.out.println(c.toString());
                    pulsaEnter();
                    break;
                case 2:

                    c = controller.clients.searchClientByDNI(c.getDNI());
                    c.setAge(devolverInt("Introduce tu nueva edad"));
                    ;
                    System.out.println(c.toString());
                    pulsaEnter();
                    break;

                case 3:
                    String direccion = devolverString("Introduce la dirección para añadir: ");
                    c.getAdress().add(direccion);
                    break;
            }
        } while (numero != 0);
    }

    public static void menu_ordenes(Client c) {
        int numero;
        do {
            System.out.println("\n+-------------------------------------+");
            System.out.println("|Cliente: " + c.getName() + " | DNI: " + c.getDNI());
            System.out.println("+-------------------------------------+");
            System.out.println("| 1) Eliminar orden por id            |");
            System.out.println("| 2) Ver todas mis ordenes            |");
            System.out.println("| 3) Cambiar de orden                 |");
            System.out.println("| 4) Pagar orden                      |");
            System.out.println("| 0) Salir                            |");
            System.out.println("+-------------------------------------+");

            numero = devolverInt("Introduce una opción: ");
            switch (numero) {
                case 1:
                    System.out.println(controller.orders.getOrdersByClient(c.getDNI()));
                    pulsaEnter();
                    int numId = devolverInt("Introduce el id de la orden que quieres borras");
                    Integer c4 = (Integer) numId;

                    c.getOrder().remove(c4);

                    pulsaEnter();
                    break;
                case 2:
                    for (int i = 0; i < c.getOrder().size(); i++) {
                        System.out.println(controller.orders.getOrdersById(c.getOrder().get(i)));
                    }
                    pulsaEnter();
                    break;
                case 3:
                    System.out.println("Los identificadores de las ordenes son: " + c.getOrder());
                    int id = devolverInt("Introduce el id de la orden");
                    controller.carrito.setOrder(controller.orders.getOrdersById(id));
                    System.out.println("Carrito Cambiado correctamente");
                    pulsaEnter();
                    break;
                case 4:
                    controller.carrito.getOrder().setPayed(true);
                    System.out.println("Orden pagada correctamente");
                    break;
            }
        } while (numero != 0);
    }

    public static String devolverString(String texto) {
        String resultado;
        Scanner teclado = new Scanner(System.in);

        System.out.print(texto);
        resultado = teclado.nextLine();

        return resultado;
    }

    public static int devolverInt(String texto) {
        int resultado = 0;
        boolean valid = false;
        Scanner teclado = new Scanner(System.in);
        do {
            try {
                System.out.print(texto);
                resultado = teclado.nextInt();
                valid = true;
            } catch (Exception e) {
                valid = false;
                System.out.println("\nIntroduce un numero correcto");
                teclado = new Scanner(System.in);
            }
        } while (!valid);
        return resultado;
    }

    public static void pulsaEnter() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Pulsa Enter para continuar");
        String desechable = keyboard.nextLine();

    }

    public static String patronDni() {
        boolean aux = false;
        String dni = "";

        Pattern p = Pattern.compile("[0-9]{7,8}[A-Za-z]");
        Matcher m = p.matcher(dni);

        while (!m.matches()) {

            if (aux == false) {
                dni = devolverString("Introduce el DNI: ");
                m = p.matcher(dni);
                if (!m.matches()) {
                    System.out.println("Introduce un dni valido ");
                }
            }

        }
        return dni;
    }

    public static void logo() {
        System.out.println("| |  | |     | |     | |      | |      |  _ \\ ");
        System.out.println("| |  | |_ __ | |_ ___| | _____| | ___  | |_) | __ _ _ __ ");
        System.out.println("| |  | | '_ \\| __/ _ \\ |/ / _ \\ |/ _ \\ |  _ < / _` | '__|");
        System.out.println("| |__| | | | | ||  __/   <  __/ |  __/ | |_) | (_| | |   ");
        System.out.println(" \\____/|_| |_|\\__\\___|_|\\_\\___|_|\\___| |____/ \\__,_|_|   ");
    }

}
