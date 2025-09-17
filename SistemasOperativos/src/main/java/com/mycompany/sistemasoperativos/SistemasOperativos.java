/*
 * Programa: SistemasOperativos.java
 * Descripción: Este programa implementa un menú para gestionar una lista
 *              de números enteros (agregar, eliminar, editar, mostrar).
 *              La lista tiene un tamaño fijo definido por el usuario.
 * Autor: OHM-ASTER
 */

package com.mycompany.sistemasoperativos;

import java.util.Scanner;

public class SistemasOperativos {

     // Declaré estas variables para controlar el tamaño, el número de elementos
    // y la lista donde guardé los valores.
    static int tam;        
    static int cont;       
    static int opt;        
    static String[] lista; 

    // En este constructor inicialicé la lista con el tamaño indicado por el usuario
    // y puse el contador en cero para empezar con la lista vacía.
    public SistemasOperativos (int tam) {
        this.tam = tam;
        lista = new String[tam];
        cont = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0;

        // Aquí pedí al usuario el tamaño de la lista y validé que fuera mayor a cero.
        while (true) {
            System.out.println("Ingresa el tamaño");
            String entra = sc.nextLine();
            try {
                t = Integer.parseInt(entra);
                if (t > 0) {
                    break; 
                } else {
                    System.out.println("El tamaño debió ser mayor a cero");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debiste ingresar un número válido");
            }
        }

        // Después de validar, creé el objeto con el tamaño definido por el usuario.
        SistemasOperativos so = new SistemasOperativos(t);

        String p = " ";

        // Aquí construí el menú principal que repetí hasta que el usuario eligiera salir.
        do {
            System.out.println ( "1- add\n"
                    + "2- del\n"
                    + "3- edit\n"
                    + "4- show\n"
                    + "5- exit");

            String entrada = sc.nextLine();
            try {
                opt = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debiste ingresar un número válido");
                continue;
            }

            // Usé un switch para controlar cada opción del menú.
            switch (opt ) {
                case 1: // Agregar
                    if (cont < tam) {
                        try {
                            System.out.println("valor..");
                            p = sc.nextLine();
                            int x = Integer.parseInt(p);
                            agregar(String.valueOf(x)); // Llamé al método agregar
                        } catch (NumberFormatException e) {
                            System.out.println("Debiste ingresar un número válido");
                        }
                    } else {
                        System.out.println("La lista ya estaba llena");
                    }
                    break;

                case 2: // Eliminar
                    if (cont > 0) {
                        eliminar (); // Llamé al método eliminar
                    } else {
                        System.out.println ("La lista estaba vacía");
                    }
                    break;

                case 3: // Editar
                    if (cont > 0) {
                        int pos;
                        try {
                            System.out.println ("Posicion a editar");
                            String entradaPos = sc.nextLine();
                            pos = Integer.parseInt (entrada);
                        } catch (NumberFormatException e) {
                            System.out.println("Lugar de lista vacia");
                            continue;
                        }
                        if ( pos >= 0 && pos < cont ) {
                            try {
                                System.out.println("nuevo valor");
                                p = sc.nextLine();
                                int y = Integer.parseInt (p);
                                editar (pos, String.valueOf (y)); // Llamé al método editar
                            } catch (NumberFormatException e) {
                                System.out.println("Debiste ingresar un número válido");
                            }
                        } else {
                            System.out.println ("Ingresaste una posición inválida");
                        }
                    } else {
                        System.out.println("La lista estaba vacía");
                    }
                    break;

                case 4: // Mostrar
                    if (cont == 0) {
                        System.out.println("La lista estaba vacía");
                    } else {
                        mostrar(); // Llamé al método mostrar
                    }
                    break;

                case 5: // Salir
                    System.out.println ("Saliendo...");
                    break;

                default:
                    System.out.println ("Ingresaste una opción inválida");
            }
        } while (opt != 5);
    }

    // En este método agregué un dato nuevo al final de la lista.
    public static void agregar(String p) {
        lista[cont] = p;
        System.out.println ("dato agregado: " + p + " en pos: " + cont );
        cont++;
    }

    // En este método eliminé el primer dato y recorrí los demás hacia la izquierda.
    public static void eliminar () {
        System.out.println ("dato eliminado: " + lista[0]);
        for (int i = 0; i < cont - 1; i++) {
            lista [i] = lista [i + 1];
        }
        lista[cont - 1] = null;
        cont--;
    }

    // En este método reemplacé el valor de una posición específica por un nuevo valor.
    public static void editar ( int pos, String p) {
        lista[pos] = p;
    }

    // En este método mostré todos los elementos que estaban guardados en la lista.
    public static void mostrar() {
        for (int i = 0; i < cont; i++) {
            System.out.println ( lista [i] );
        }
    }
}