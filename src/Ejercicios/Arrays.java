/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Arrays {
    
    
    /**
     * Genera numeros aleatorios entre 0 y 100;
     * @return un numero comprendido entre 1 y 100;
     */
    public static double generateNumbers() {
        return (Math.random() * 100);
    }

    /**
     * Llena un arreglo de manera automatica, con datos numericos aleatorios comprendidos entre 0 y 100;
     * @param numbers arreglo de tipo int a llenar 
     * @return Un arreglo de tipo int llenado con números aleatorios.
     */
    public static int[] fillArrayRandom(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) generateNumbers();
        }
        return numbers;
    }

    /**
     * Ordena un arreglo en forma ascendente haciendo uso del método burbuja.
     * @param numbers arreglo de tipo int a ordenar
     * @return Un arreglo ordenado en forma ascendente.
     */
    public static int[] orderArray_Bubble(int[] numbers) {
        //Metodo de burbuja: forma ascendente 
        int aux;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {

                if (numbers[j + 1] < numbers[j]) {
                    aux = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = aux;
                }
            }
        }
        return numbers;
    }

    /**
     * Ordena un arreglo en forma ascendente haciendo uso del método burbuja.
     * @param numbers arreglo de tipo double a ordenar
     * @return Un arreglo ordenado en forma ascendente.
     */
    public static double[] orderArray_Bubble(double[] numbers) {
        //Metodo de burbuja: forma ascendente 
        double aux;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {

                if (numbers[j + 1] < numbers[j]) {
                    aux = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = aux;
                }
            }
        }
        return numbers;
    }

    /**
     * Busca un elemento en el arreglo.
     * @param array Arreglo en el que se va a buscar el elemento
     * @param element dato a buscar en el arreglo
     * @return la posicion del elemento. -1 si no encuentra el elemento.
     */
    public static int binarySearch(int[] array, int element) {

        int firstIndex = 0, lastIndex = array.length - 1;
        int centralIndex = 0;

        while (firstIndex <= lastIndex) {

            centralIndex = (firstIndex + lastIndex) / 2;

            if (array[centralIndex] == element) {
                return centralIndex;
            }

            if (array[centralIndex] < element) {
                firstIndex = centralIndex + 1;
            }

            if (array[centralIndex] > element) {
                lastIndex = centralIndex - 1;
            }

        }

        return -1;
    }

    /**
     * Imprime los elementos de un arreglo
     * @param array arreglo a mostrar los elementos 
     */
    public static void showArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");;
        }
        System.out.println("");
    }

    /**
     * Imprime los elementos de un arreglo
     * @param array arreglo a mostrar los elementos 
     */
    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");;
        }
        System.out.println("");
    }

}
