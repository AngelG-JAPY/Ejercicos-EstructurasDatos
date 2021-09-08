/*
    * Se han registrado las notas definitivas
   de 58 estudiantes de Programación Digital en
   un arreglo unidimensional llamado NOTAS. Cada
   calificación es un número entero entre 1 y
   20.Construya un algoritmo que le permita al profesor de
   esta asignatura obtener la siguiente información:
   – La nota promedio de la clase.
   – Las notas ordenadas de menor a mayor.
   – Nota más alta y más baja obtenida en esta sección de Programación Digital,
    e indicar los nombres de los estudiantes que las obtuvieron.

   – Cuántos estudiantes obtuvieron notas de 18, 19 ó 20.
   – Las notas que fueron mayores al promedio.
   – El porcentaje de estudiantes aprobados y el porcentaje de los reprobados.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Ejercicio7 {

    private static final Scanner sc = new Scanner(System.in);
    private static int[] grades = new int[20];
    private static int average = 0;

    /**
     * Pide los datos al usuario de manera manual.
     */
    public static void fillGrades() {
        for (int i = 0; i < grades.length; i++) {
            grades[i] = sc.nextInt();
        }
    }

    /**
     * Calcula el promedio de los datos del arreglo
     *
     * @return promedio de tipo entero.
     */
    public static int gradesAverage() {

        for (int i = 0; i < grades.length; i++) {
            average += grades[i];
        }

        average /= grades.length;

        return average;
    }

    /**
     * Ordena los elementos del arreglo de manera ascendente
     */
    public static void orderGrades() {
        grades = Arrays.orderArray_Bubble(grades);
    }

    /**
     * Se necesita tener el arreglo ordenado primero.
     *
     * @return El menor elemento del arreglo si esta ordenado en fomra ASC. El
     * primer elemento del arreglo si este esta desordenado.
     */
    public static int lowestGrade() {
        return grades[0];
    }

    /**
     * Calcula el mayor elemento que se encuentra en el arreglo.
     *
     * @return El mayor elemento del arreglo si esta ordenado de forma ASC. El
     * último elemento si esta desordenado.
     */
    public static int highestGrade() {
        return grades[grades.length - 1];
    }

    /**
     * Calcula de manera generar cuantos elementos están en un rango, incluyendo
     * los extremos;
     *
     * @param order indica si el arreglo esta ordenado y en forma asc. True si
     * lo esta, false sino.
     * @return -1 si el arreglo no esta ordenado. El total de elementos entre 18
     * y 20;
     */
    public static int searchInRange(boolean order) {

        int total = 0;

        //Si el arreglo esta ordenado:
        if (order) {

            for (int i = grades.length - 1; i > -1; i--) {
                if (!(grades[i] >= 18 && grades[i] <= 20)) {
                    break;
                }
                total++;
            }
            return total;

        } else {
            return -1;
        }

    }

    /**
     * Determina cuantos elementos son mayores al promedio
     *
     * @param order indica si el arreglo ya esta ordenado en forma asc.
     * @return El total de datos mayores al promedio si el arreglo esta ordenado. 
     *  -1 Si el arreglo no esta ordenado.
     *  -2 Si el promedio es igual 0.
     */
    public static int higherThanAverage(boolean order) {
        int total = 0;
        int average = gradesAverage();
        if (order && average != 0) {
            for (int i = grades.length - 1; i > -1; i--) {
                if (grades[i] < average) {
                    break;
                }
                total++;
            }
        }

        if (!order) {
            return -1;
        }

        if (average == 0) {
            return -2;
        }
        
        return total;
    }

}
