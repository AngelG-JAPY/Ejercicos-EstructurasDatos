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
    private static boolean order = false;

    /**
     * Pide los datos al usuario de manera manual.
     */
    public static void fillGrades() {
        for (int i = 0; i < grades.length; i++) {
            grades[i] = sc.nextInt();
        }
    }

    /**
     * Llena los datos de forma aleatoria
     */
    public static void fillGradesRandom() {
        for (int i = 0; i < grades.length; i++) {
            grades[i] = (int) (Math.random() * 20) + 1;
        }
    }

    /**
     * Calcula el promedio de los datos del arreglo
     *
     * @return promedio de tipo entero.
     */
    public static int gradesAverage() {
        int average = 0;

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
        order = true;
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
    public static int searchInRange() {

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
     * @return El total de datos mayores al promedio si el arreglo esta
     * ordenado. -1 Si el arreglo no esta ordenado. -2 Si el promedio es igual
     * 0.
     */
    public static int higherThanAverage() {
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

    /**
     * Determina cuantos estudiantes aprobaron. Para esto, el arreglo debe de
     * andar ordenado.
     *
     * @return 100 si el primer elemento del arreglo es mayor a la nota minima.
     * 0 si la ultima nota es menor a la nota minima. % de estudiantes aprovados
     * en caso de no cumplirse ninguna. -1 si el arreglo no esta ordenado.
     */
    public static int approvedStudents() {

        int approved = 0;

        if (order) {
            if (grades[0] >= 10) {
                return 100;
            } else if (grades[grades.length - 1] < 10) {
                return 0;
            } else {
                for (int i = grades.length - 1; i > -1; i--) {
                    if (grades[i] < 10) {
                        break;
                    }
                    approved++;
                }

                return (approved * 100) / grades.length;

            }
        } else {
            return -1;
        }

    }

    /**
     * Determina cuantos estudiantes reprovaron.
     *
     * @return 100 si el ulitmo elemento del arreglo es menor a la nota minima.
     * 0 si la primera nota es mayor a la nota minima. % de estudiantes
     * reprovados en caso de no cumplirse ninguna. -1 si el arreglo no esta
     * ordenado.
     */
    public static int failingStudents() {

        int failing = 0;

        if (order) {
            if (grades[grades.length - 1] < 10) {
                return 100;
            } else if (grades[0] >= 10) {
                return 0;
            } else {
                for (int i = grades.length - 1; i > -1; i--) {
                    if (grades[i] < 10) {
                        break;
                    }
                    failing++;
                }

                return (failing * 100) / grades.length;

            }
        } else {
            return -1;
        }

    }

    public static void menu() {
        System.out.println("1. Registrar las notas de los estudiantes");
        System.out.println("2. Generar notas de forma aleatoria");
        System.out.println("3. Calcular promedio de la clase.");
        System.out.println("4. Ordenar notas (solo en forma asc)");
        System.out.println("5. Nota mas alta y baja obtenida.");
        System.out.println("6. Calcular cuantos estudiantes obtuvieron notas de 18, 19 o 20.");
        System.out.println("7. Determinar cuantas notas fueron mayor al promedio");
        System.out.println("8. Calcular estudiantes aprobados y reprobados.");
        System.out.println("9. Mostrar arreglo.");
        System.out.println("10. Salir.");
        System.out.print("Opción: ");
    }

    public static void run() {
        var mainLoop = true;
        var option = 0;
        int result, approved, fail;

        while (mainLoop) {

            menu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Rellene las notas. Puede hacerlo separados por espacio (1 2 3...) o dando enter");
                    fillGrades();
                    System.out.println("");
                    break;

                case 2:
                    fillGradesRandom();
                    System.out.println("Se generaron las notas de forma éxitosa.");
                    break;

                case 3:
                    System.out.println("El promedio de la clase es: " + gradesAverage());
                    break;

                case 4:
                    orderGrades();
                    System.out.println("Se ordenaron las notas de forma éxitosa.");
                    break;

                case 5:
                    if (order) {
                        System.out.println("La mayor nota obtenida en el curso fue: " + highestGrade());
                        System.out.println("La menor nota obtenida en el curso fue: " + lowestGrade());
                    } else {
                        System.out.println("Falta ordernar el registro de notas.");
                    }
                    break;

                case 6:
                    result = searchInRange();
                    System.out.println(result == -1 ? "Falta ordenar el registro de notas" : result + " estudiantes obtuvieron notas de 18,19 o 20.");
                    break;

                case 7:
                    result = higherThanAverage();
                    if (result == -1) {
                        System.out.println("Falta ordenar el registro de notas");
                    } else if (result == -2) {
                        System.out.println("¡Tiene que calcular primero el promedio!");
                    } else {
                        System.out.println(result + "estudiantes obtuvieron notas mayores al promedio");
                    }
                    break;

                case 8:
                    approved = approvedStudents();
                    fail = failingStudents();

                    if (approved == -1 || fail == -1) {
                        System.out.println("Falta ordenar el registro de notas");
                    } else {
                        System.out.println(approved + "% estudiantes aprovaron el curso.");
                        System.out.println(fail + "% estudiantes reprovaron el curso.");
                    }
                    break;
                    
                case 9:
                    Arrays.showArray(grades);
                    break;
                case 10:
                    mainLoop = false;
                    break;
                    
                default:
                    System.out.println("Ingrese una opción valida.");

            }       
                    
            System.out.println("");

        }

    }

}
