/*
 *  Un viajero conoce todos los gastos que hizo en
    su último viaje con la tarjeta de crédito, fueron 18 en
    total, los cuales se pueden clasificar en cuatro tipos:
    comida, hospedaje, transporte y ropa. Escriba un
    algoritmo, que haga uso de vectores, y le permita al
    viajero determinar:
        – Gastos totales discriminados por tipo.
        – Cantidad de gastos que realizó en comida.
        – Tipo de gasto en el que más invirtió dinero en el viaje.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author Angel Garcia
 */
public class Ejercicio5 {

    private static Scanner sc = new Scanner(System.in);
    
    private static double[] foodExpenses;
    private static double[] lodgingExpenses;
    private static double[] transportationExpenses;
    private static double[] clothingExpenses;

    private static double[] totalCost = new double[4];

    //Registramos (pedimos) la cantida de  gastos  correspondientes a cada tipo.
    public static boolean recordExpenses() {

        var expenses = 0;

        System.out.print("De los 18 gastos ¿Cuantos corresponden a comida?: ");
        foodExpenses = new double[sc.nextInt()];

        System.out.print("De los 18 gastos ¿Cuantos corresponden a hospedaje?: ");
        lodgingExpenses = new double[sc.nextInt()];

        System.out.print("De los 18 gastos ¿Cuantos corresponden a transporte?: ");
        transportationExpenses = new double[sc.nextInt()];

        System.out.print("De los 18 gastos ¿Cuantos corresponden a ropa?: ");
        clothingExpenses = new double[sc.nextInt()];

        expenses = foodExpenses.length + lodgingExpenses.length + transportationExpenses.length + clothingExpenses.length;

        if (expenses > 18) {
            System.out.println("La informacion registrada no coincide con los 18 gastos estipulados. Intentalo de nuevo.");
            return false;
        }
        return true;
    }

    //registramos los gastos que se hicieron en comida
    public static void recordFoodExpenses() {
        for (int i = 0; i < foodExpenses.length; i++) {
            foodExpenses[i] = sc.nextDouble();
        }
    }

    //registramos los gastos que se hicieron en hospedaje
    public static void recordLodgingExpenses() {
        for (int i = 0; i < lodgingExpenses.length; i++) {
            lodgingExpenses[i] = sc.nextDouble();
        }
    }

    //registramos los gastos que se hicieron en transporte
    public static void recordTransportationExpenses() {
        for (int i = 0; i < transportationExpenses.length; i++) {
            transportationExpenses[i] = sc.nextDouble();
        }
    }

    //registramos los gastos que se hicieron en ropa
    public static void recordClothingExpenses() {
        for (int i = 0; i < clothingExpenses.length; i++) {
            clothingExpenses[i] = sc.nextDouble();
        }
    }

    //calculamos los gastos totales por comida:
    public static double totalFoodCosts() {
        var totalCosts = 0d;

        for (int i = 0; i < foodExpenses.length; i++) {
            totalCosts += foodExpenses[i];
        }

        return totalCosts;
    }

    //calculamos los gastos totales por hospedaje:
    public static double totalLodgingCosts() {
        var totalCosts = 0d;

        for (int i = 0; i < lodgingExpenses.length; i++) {
            totalCosts += lodgingExpenses[i];
        }

        return totalCosts;
    }

    //calculamos los gastos totales por transporte:
    public static double totalTransportationCosts() {
        var totalCosts = 0d;

        for (int i = 0; i < transportationExpenses.length; i++) {
            totalCosts += transportationExpenses[i];
        }

        return totalCosts;
    }

    //calculamos los gastos totales por ropa:
    public static double totalClothingCosts() {
        var totalCosts = 0d;

        for (int i = 0; i < clothingExpenses.length; i++) {
            totalCosts += clothingExpenses[i];
        }

        return totalCosts;
    }

    //Registramos los gastos totales por tipo en un array:
    public static void totalCost() {
        totalCost[0] = totalFoodCosts();
        totalCost[1] = totalLodgingCosts();
        totalCost[2] = totalTransportationCosts();
        totalCost[3] = totalClothingCosts();
    }
    
    //Calculamos el mayor gast
    public static void highExpense(){
        var high = totalCost[0];
        var type = 0;
        
        for (int i = 0; i < totalCost.length; i++) {
            if(high <= totalCost[i]){
                high = totalCost[i];
                type = i;
            }
            
        }
        
        System.out.println("El mayor gasto en el que invirtio fue a concepto de: "+kindExpense(type));
    }
    
    public static String kindExpense(int type) {
        switch(type){
            case 0: 
                return "Comida";
            case 1:
                return "Hospedaje";
            case 2:
                return "Transporte";
            case 3:
                return "Ropa";
                
            default:
                return "";
        }
    }
    
    public static void menu(){
        System.out.println("1. Registrar la cantidad de gastos correspondientes a cada tipo.");
        System.out.println("2. Registrar gastos por cada tipo.");
        System.out.println("3. Gastos discriminados por tipo.");
        System.out.println("4. En que gasto mas dinero.");
        System.out.println("5. Salir.");
        
        System.out.print("Opción: ");
    }
    
    public static void run(){
        var mainLoop = true;
        var option = 0;
        var controller = false;
        
        while(mainLoop){
            
            menu();
            
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    controller = recordExpenses();
                    break;
                    
                case 2:
                    if(controller){
                        System.out.println("Registre los  " + foodExpenses.length + " gastos en comida separados por coma : ");
                        recordFoodExpenses();

                        System.out.println("Registre los  " + lodgingExpenses.length + " gastos en hospedaje separados por coma : ");
                        recordLodgingExpenses();

                        System.out.println("Registre los  " + transportationExpenses.length + " gastos en transporte separados por coma : ");
                        recordTransportationExpenses();

                        System.out.println("Registre los  " + clothingExpenses.length + " gastos en ropa separados por coma : ");
                        recordClothingExpenses();
                    }else {
                        System.out.println("Falta asignar la cantidad de gastos correspondientes a cada tipo");
                    }
                    
                    break;
                    
                case 3:
                    if(controller){
                        totalCost();
                        System.out.println("Total de gastos por: \n"
                                + "Comida: " + totalCost[0] + "\n"
                                + "Hospedaje: " + totalCost[1] + "\n"
                                + "Transporte: " + totalCost[2] + "\n"
                                + "Ropa: " + totalCost[3] + "\n"
                        );
                    }else {
                        System.out.println("Falta asignar la cantidad de gastos correspondientes a cada tipo");
                    }
                    
                    break;
                    
                case 4:
                    if(controller){
                        highExpense();
                    }else {
                        System.out.println("Falta asignar la cantidad de gastos correspondientes a cada tipo");
                    }
                    
                    break;
                    
                case 5:
                    mainLoop = false;
                    System.out.println("");
                default: 
                    System.out.println("Selecciono una opcion no valida. Intente de nuevo");
            }
            
            
            
        }
    }

    

}
