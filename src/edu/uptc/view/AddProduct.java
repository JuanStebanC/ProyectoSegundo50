package edu.uptc.view;

import java.util.ArrayList;
import java.util.Scanner;

public class AddProduct {
    static Scanner sc = new Scanner(System.in);
    private static int option;
    private static boolean exit = false;
    private static ArrayList<String> cart = new ArrayList<>();

    public AddProduct(ArrayList<String> cart) {
        this.cart = cart;
    }

    public static void addProduct(){
        ArrayList<String> cant = new ArrayList<>();
        exit = false;
        do{
            do {
                System.out.println("Ingrese el tipo de producto que desea ingresar:" +
                        "\n 1. Viveres" +
                        "\n 2. Licores" +
                        "\n 3. Medicinas" +
                        "\n 4. Aseo");
                option = sc.nextInt();
                switch (option){
                    case 1:
                        cart.add(addViveres());
                        break;
                    case 2:
                        cart.add(addLicores());
                        break;
                    case 3:
                        cart.add(addMedicinas());
                        break;
                    case 4:
                        cart.add(addAseo());
                        break;
                    default:
                        System.out.println(Runner.printErrorMessage());
                }
                if (option == 1 ||option == 2 || option == 3 || option == 4){
                    exit = true;
                }
            } while (!exit); exit = false;
            do {
                System.out.println("¿Deseas agregar mas productos?:" +
                        "\n 1. Si" +
                        "\n 2. No");
                option = sc.nextInt();
                if (option == 2 || option == 1){
                    exit = true;
                } else {
                    System.out.println(Runner.printErrorMessage());
                }
            } while (!exit); exit = false;
            if (option==2 ){
                exit = true;
            }
        } while (!exit);
    }

    public static String addViveres(){
        exit = false;
        String viveres = "";
        do{
            System.out.println("Seleccione un producto:" +
                    "\n 1. Atún" +
                    "\n 2. Salchichas en lata" +
                    "\n 3. Coca-Cola");
            option = sc.nextInt();
            switch (option){
                case 1:
                    viveres =  "Atún";
                    break;
                case 2:
                    viveres = "Salchichas en lata";
                    break;
                case 3:
                    viveres = "Coca-Cola";
                    break;
                default:
                    System.out.println(Runner.printErrorMessage());
            }
            if (option == 1 || option == 2 || option == 3){
                cant();
                exit = true;
            }
        } while (!exit);
        return viveres;
    }

    public static String addLicores(){
        exit = false;
        String licores = "";
        do{
            System.out.println("Seleccione un producto:" +
                    "\n 1. Ron" +
                    "\n 2. Aguardiente" +
                    "\n 3. Vokda");
            option = sc.nextInt();
            switch (option){
                case 1:
                    licores =  "Ron";
                    break;
                case 2:
                    licores = "Aguardiente";
                    break;
                case 3:
                    licores = "Vokda";
                    break;
                default:
                    System.out.println(Runner.printErrorMessage());
            }
            if (option == 1 || option == 2 || option == 3){
                cant();
                exit = true;
            }
        } while (!exit);
        return licores;
    }

    public static String addMedicinas(){
        exit = false;
        String medicinas = "";
        do{
            System.out.println("Seleccione un producto:" +
                    "\n 1. Acetaminofen" +
                    "\n 2. Omeprazol" +
                    "\n 3. Ibuprofeno");
            option = sc.nextInt();
            switch (option){
                case 1:
                    medicinas =  "Acetaminofen";
                    break;
                case 2:
                    medicinas = "Omeprazol";
                    break;
                case 3:
                    medicinas = "Ibuprofeno";
                    break;
                default:
                    System.out.println(Runner.printErrorMessage());
            }
            if (option == 1 || option == 2 || option == 3){
                cant();
                exit = true;
            }
        } while (!exit);
        return medicinas;
    }

    public static String addAseo(){
        exit = false;
        String aseo = "";
        do{
            System.out.println("Seleccione un producto:" +
                    "\n 1. Papel higienico" +
                    "\n 2. Jabón Rey" +
                    "\n 3. Fabuloso");
            option = sc.nextInt();
            switch (option){
                case 1:
                    aseo =  "Papel higienico";
                    break;
                case 2:
                    aseo = "Jabón Rey";
                    break;
                case 3:
                    aseo = "Fabuloso";
                    break;
                default:
                    System.out.println(Runner.printErrorMessage());
            }
            if (option == 1 || option == 2 || option == 3){
                cant();
                exit = true;
            }
        } while (!exit);
        return aseo;
    }

    public static String cant(){
            String cant = "";
            exit = false;
            do {
                try {
                    System.out.println("Digite la cantidad que desea añadir a su carrito:");
                    cant = String.valueOf(sc.nextInt());
                    exit = true;
                    cart.add(cant);
                } catch (java.util.InputMismatchException e){
                    Runner.printErrorMessage();
                }
            } while (!exit);
            return cant;
    }
}
