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
    public static void numbersHigherThanTheAverage(boolean option, int average) {

        

        var amount = 0;

        if (!option) {

            // en caso de que el arreglo no este ordenado: Usamos la busqueda lineal
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] >= average) {
                    amount++;
                }
            }

        } else {
            //en caso de que el arreglo este ordenado: Contamos desde la ultima posicion hasta la primera:
            for (int i = numbers.length - 1; i > -1; i--) {

                if (numbers[i] < average) {
                    break;
                }
                amount++;
            }

        }

        System.out.println("Cantidad de elementos mayores al promedio: " + amount);
    }

    public static void menu() {
        System.out.println("1. Llenar arreglo de manera aleatoria.");
        System.out.println("2. Ordenar arreglo (ASC).");
        System.out.println("3. Calcular promedio.");
        System.out.println("4. Cantidad de numeros mayores al promedio.");
        System.out.println("5. Sumar numeros pares e impares.");
        System.out.println("6. Mostrar arreglo");
        System.out.println("7. Salir.");
        System.out.print("Opción: ");
    }

    public static void run() {
        var mainLoop = true;
        var option = 0;
        var full = false;
        var order = false;
        var prom = false;
        var average = 0;
        var sc = new Scanner(System.in);

        while (mainLoop) {
            menu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Cantidad de números que desea generar: ");
                    valueOf_N(sc.nextInt());
                    numbers = Arrays.fillArrayRandom(numbers);
                    full = true;
                    System.out.println("Se lleno el arreglo de forma éxitosa.");
                    break;

                case 2:
                    if (full) {
                        numbers = Arrays.orderArray_Bubble(numbers);
                        order = true;
                        System.out.println("Se ordeno el arreglo de manera éxitosa.");
                    } else {
                        System.out.println("No ha llenado el arreglo.");
                    }
                    break;

                case 3:
                    if ((full)) {
                        average = average();
                        System.out.println("El promedio es: " + average);
                        prom = true;
                    } else {
                        System.out.println("NO ha llenado el arreglo.");
                    }
                    break;
                    
                case 4:
                    if (prom){
                        numbersHigherThanTheAverage(order,average);
                    } else {
                        System.out.println("Tienes que calcular el promedio primero.");
                    }
                    break;

                case 5:
                    if (full) {
                        sumOdd_And_Even();
                    } else {
                        System.out.println("NO ha llenado el arreglo.");
                    }
                    break;

                case 6:
                    if (full) {
                        Arrays.showArray(numbers);
                    } else {
                        System.out.println("NO ha llenado el arreglo.");
                    }
                    break;
                    
                case 7:
                    mainLoop = false;
                    break;
                    
                default:
                    System.out.println("Seleccione una opción valida.");
                    break;
            }
            
            System.out.println("");

        }
    }

}
