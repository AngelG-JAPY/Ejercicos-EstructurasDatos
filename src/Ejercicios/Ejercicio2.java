/*
    Escribir un algoritmo que determine:
        a) el promedio de N números enteros e indique
           cuáles elementos son mayores a dicho
           promedio.

        b) la suma de los números pares e impares.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author Angel Garcia
 */
public class Ejercicio2 {

    private static int[] numbers;

    public static void valueOf_N(int n) {
        numbers = new int[n];
    }

    //en caso de que se quiera llenar el arrego de forma manual
    public static void manuallyFillArray(Scanner sc) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    //Calculamos le promedio
    public static int average() {
        var average = 0;

        for (int i = 0; i < numbers.length; i++) {
            average += numbers[i];
        }

        return average / numbers.length;
    }

    //Suma de los números pares e impares
    public static void sumOdd_And_Even() {
        var odd = 0;
        var even = 0;

        for (int i = 0; i < numbers.length; i++) {
            
            if (numbers[i] % 2 == 0) {
                odd += numbers[i];
            } else {
                even += numbers[i];
            }
        }

        System.out.println("Suma de los números pares: " + even);
        System.out.println("Suma de los números impares: " + odd);
    }

    //calculamos la cantidad de elementos mayores al promedio
    public static void numbersHigherThanTheAverage(int option) {

        numbers = Arrays.fillArray(numbers);

        var amount = 0;
        var average = average();

        if (option == 0) {

            // en caso de que el arreglo no este ordenado: Usamos la busqueda lineal
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] >= average) {
                    amount++;
                }
            }

        } else {
            //en caso de que el arreglo este ordenado: Contamos desde la ultima posicion hasta la primera:
            //numbers = Arrays.orderArray(numbers);
            //Arrays.showArray(numbers);
            //System.out.println("promedio = "+average);

            for (int i = numbers.length - 1; i > -1; i--) {

                if (numbers[i] < average) {
                    break;
                }
                amount++;
            }

        }

        System.out.println("Cantidad de elementos mayores al promedio: " + amount);
    }

}
