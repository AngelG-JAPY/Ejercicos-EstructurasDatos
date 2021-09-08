package Ejercicios;

/*
 *  Enunciado: 
        Escribir un algoritmo que determine el
        mayor valor de una lista de 50 números
        reales e indique la posición que ocupa
 */
/**
 *
 * @author Angel Garcia
 */
public class Ejercicio1 {

    private static int[] numbers = new int[10];


    public static int lenghtNumber() {
        //como ya tenemos ordenado el arreglo, solo retornamos el ultimo elemento 
        return numbers[numbers.length - 1];
    }

    public static void showNumber() {

        numbers = Arrays.fillArrayRandom(numbers);
        numbers = Arrays.orderArray_Bubble(numbers);

        System.out.println(lenghtNumber());

    }

}
