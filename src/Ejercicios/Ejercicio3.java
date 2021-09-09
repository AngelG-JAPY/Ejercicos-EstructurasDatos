/*
 *  Escriba un algoritmo que determine si
    dos vectores de treinta caracteres son
    iguales.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author Angel Garcia
 */
public class Ejercicio3 {

    private static char[] array1 = new char[10];
    private static char[] array2 = new char[10];

    //en caso de que se quiera llenar el arrego de forma manual
    public static void manuallyFillArray(Scanner sc, char[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.next().charAt(0);
        }
    }

    //Determinar si son iguales
    public static void compareArrays() {
        //Los arreglos serán iguales si tienen los mismo elementos en la misma posición
        //por tanto solo debemos comparar componente a componente (recorrido linel)

        var controller = true;
        for (int i = 0; i < array1.length; i++) {

            if (array1[i] != array2[i]) {
                System.out.println("Los arreglos no son iguales");
                controller = !controller;
                break;
            }
        }

        if (controller) {
            System.out.println("Los arreglos son iguales.");
        }
    }

    public static void menu() {
        System.out.println("1. Llenar arreglo");
        System.out.println("2. Comparar arreglos");
        System.out.println("3. Salir");
        System.out.print("Opción: ");
    }

    public static void run() {
        var mainLoop = true;
        var option = 0;
        var full = false;
        var sc = new Scanner(System.in);

        while (mainLoop) {
            menu();
            option = sc.nextInt();
            
            switch (option){
                case 1:
                    System.out.println("Primer arreglo: ");
                    manuallyFillArray(sc, array1);
                    System.out.println("Segundo arreglo: ");
                    manuallyFillArray(sc, array2);
                    System.out.println("Se llenaron los arreglos.");
                    full = true;
                    break;
                    
                case 2:
                    if(full){
                        compareArrays();
                    } else {
                        System.out.println("NO ha llenado los arreglos.");
                    }
                    break;
                    
                case 3:
                    mainLoop = false;
                    break;
                
                default:
                    System.out.println("Seleccione una opción valida");
                    break;
            }
            
            System.out.println("");
            
        }
    }

}
