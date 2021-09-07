/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

/**
 *
 * @author USUARIO
 */
public class Arrays {

    public static double generateNumbers() {
        return (Math.random() * 100);
    }

    public static int[] fillArray(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) generateNumbers();
        }
        return numbers;
    }

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
    
    
    
    public static int binarySearch(int [] array, int element){
        
        
        int firstIndex = 0, lastIndex = array.length-1;
        int centralIndex = 0;
        
        
        
        while(firstIndex <= lastIndex){
            
            centralIndex = (firstIndex + lastIndex)/2;
            
            if(array[centralIndex] == element){
                return centralIndex;
            }
            
            if(array[centralIndex] < element){
                firstIndex = centralIndex +1;                 
            }
            
            if(array[centralIndex] > element){
                lastIndex = centralIndex-1;
            }
            
        }
        
        return -1;
    } 


    public static void showArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");;
        }
        System.out.println("");
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");;
        }
        System.out.println("");
    }

}
