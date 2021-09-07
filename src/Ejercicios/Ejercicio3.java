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

    private static char[] array1 = new char[30];
    private static char[] array2 = new char[30];

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

}
