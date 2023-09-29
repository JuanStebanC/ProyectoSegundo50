package edu.uptc.view;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    static Scanner sc = new Scanner(System.in);
    private static int option;
    private static boolean exit = false;
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        System.out.println("Bienvenido a la gestión de ventas de Juan y Daniela");
        exit = false;
        do{
            System.out.println("Selecciones una opción:" +
                    "\n 1. Agregar una venta/factura" +
                    "\n 2. Actualizar existencia productos" +
                    "\n 3. Consultar detalles de una factura" +
                    "\n 4. Salir");
            option = sc.nextInt();
            switch (option) {
                case 1://:)
                    AddProduct.addProduct();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    exit = exit();
                    break;
                default:
                    System.out.println(printErrorMessage());
            }
        } while (!exit);

    }

    public static String printErrorMessage(){
        String message = "Ingrese una opción válida";
        return message;
    }

    public static boolean exit(){
        boolean shutDown = false;
        exit = false;
        do {
            System.out.println("¿Quieres salir?" +
                    "\n 1. Si" +
                    "\n 2. No");
            option = sc.nextInt();
            if (option == 1 || option == 2){
                exit = true;
            }
        } while (!exit); exit = false;
        if (option == 1){
            shutDown = true;
        } else {
            shutDown = false;
        }
        return shutDown;
    }
}
