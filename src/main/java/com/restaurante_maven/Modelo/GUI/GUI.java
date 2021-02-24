package com.restaurante_maven.Modelo.GUI;

import AppController.AppController;
import com.restaurante_maven.Modelo.Principal.Client;
import java.util.Scanner;

public class GUI {

    static AppController controller = new AppController();

    public static void main(String[] args) {
        int numero;
        System.out.println("Bienvenido al restaurante");
        do {
            System.out.println("\n+-------------------------+");
            System.out.println("|        Menu          	  |");
            System.out.println("+-------------------------+");
            System.out.println("| 1) Iniciar Sesion       |");
            System.out.println("| 2) Registrarse          |");
            System.out.println("| 0) Salir                |");
            System.out.println("+-------------------------+");

            numero = devolverInt("Introduce una opción: ");
            opciones_principales(numero);
        } while (numero != 0);
    }

    public static void opciones_principales(int opcion) {
        if (opcion > 0 && opcion <= 4) {
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
        Client c = null;

        System.out.println("\n+-------------------+");
        System.out.println("|   Iniciar Sesion  |");
        System.out.println("+-------------------+");
        String dni = devolverString("Introduce tu DNI");
        String nomnbre = devolverString("Introduce tu nombre");
        if (dni != null && nomnbre != null) {
            c = controller.clients.searchClientByDNI(dni);
            menu_principal(c);
            result = true;
        }
        return result;
    }

    public static boolean Registro() {
        boolean result = false;
        String dni = devolverString("Introduce el dni");

        String name = devolverString("Introduce el nombre");
        int age;
        age = devolverInt("Introduce la edad");
        int points;
        points = devolverInt("Introduce los puntos");
        Client c1 = new Client(dni, name, age, points);
        controller.clients.addClient(c1);
        return result;
    }

    public static void menu_principal(Client c) {
        int numero;
        System.out.println("Bienvenido al restaurante");
        do {
            System.out.println("\n+-------------------------+");
            System.out.println("|        Menu          	  |");
            System.out.println("+-------------------------+");
            System.out.println("| 1) hola     |");
            System.out.println("| 2) adios          |");
            System.out.println("| 0) Salir                |");
            System.out.println("+-------------------------+");

            numero = devolverInt("Introduce una opción: ");
            switch (numero) {
                case 1:
                    System.out.println("Hola");
                    break;
                case 2:
                    System.out.println("adios");
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
}
