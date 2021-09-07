/*
 *  Escriba un algoritmo que haciendo
    uso de un arreglo unidimensional de 100
    elementos denominado CEDULA, permita:
        – Leer los 100 elementos por teclado.

        – Ordenar los números de cédula de forma
        ascendente.

        – Buscar si el número de cédula 19144473 se
        encuentra en el arreglo CEDULA e indicar la
        posición que ocupa.

        – Determinar cuántos números de cédula son
        mayores a 19145954.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Ejercicio6 {

    //usamremos solo 10 elementos para no escribir todo a mano.
    private static int[] cedulas = new int[10];
    private static Scanner sc = new Scanner(System.in);

    //Llenamos el arreglo con las cedulas 
    public static void fillID() {

        for (int i = 0; i < cedulas.length; i++) {
            //System.out.println(i);
            cedulas[i] = sc.nextInt();
        }
    }

    public static int higherThan(int id) {
        int amount = 0;

        //si el primer elemento es mayor a la CC a comprar, la cantidad de cedulas mayores a esta
        //es la longitud del array y no es necesario hacer iteraciones;
        if (cedulas[0] > id) {
            amount = cedulas.length;
        } //Si el elemento de la ultima posicion no es mayor a la CC a comprar, por tanto, ningun elemento es mayor a este.
        else if (cedulas[cedulas.length - 1] < id) {
            amount = 0;
        } else {
            for (int i = cedulas.length - 1; i > -1; i--) {
                if (cedulas[i] < id) {
                    break;
                }
                amount++;
            }
        }

        return amount;
    }

    public static void menu() {
        System.out.println("1. Registrar cédulas");
        System.out.println("2. Ordenar las cédulas.");
        System.out.println("3. Buscar un número de cédula en el registro.");
        System.out.println("4. Cuantas cédulas son mayores a otra.");
        System.out.println("5. Imprimir registro de cédulas");
        System.out.println("6. Salir");
    }

    public static void run() {
        var mainLoop = true;
        int option;
        int idObjetive;

        while (mainLoop) {

            menu();
            System.out.print("Opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    fillID();
                    System.out.println("Se registraron con éxito las cédulas.");
                    break;

                case 2:
                    cedulas = Arrays.orderArray_Bubble(cedulas);
                    System.out.println("Se ordenaron de forma ascendente las cédulas con éxito.");
                    break;

                case 3:
                    System.out.print("Número de cédula a buscar en el registro: ");
                    idObjetive = sc.nextInt();
                    int index = Arrays.binarySearch(cedulas, idObjetive);
                    System.out.println(index == -1 ? "La cédula " + idObjetive + ", no se encuentra registrada."
                            : "La cédula se encuentra en la posición: " + index);
                    break;

                case 4:
                    System.out.print("Ingrese el número de cédula: ");
                    idObjetive = sc.nextInt();
                    int amount = higherThan(idObjetive);
                    System.out.println(amount == 0 ? "Ningún elemento es mayor a la cedula " + idObjetive
                            : amount + " cédulas son mayores a " + idObjetive);
                    break;

                case 5:
                    Arrays.showArray(cedulas);
                    break;

                case 6:
                    mainLoop = false;
                    break;
            }

        }

    }

}
