package com.mycompany._ra6_pt11_4_matveinikitacazallayamila;

import java.util.Scanner;

/**
 *
 * @author Nikita i Yamila
 */
public class Principal {

    public static void main(String[] args) {
        
        /*Declaracio de variables*/
        Scanner sc = new Scanner(System.in);
        String opcio;
        Bacteris colonia;
        int tamany;
        
        System.out.println("DEMOSTRACIÓ DE LA CLASSE BACTERIS");
        System.out.println("\nAbans de començar, vols canviar el tamany de la placa "
                + "on es troben els bacteris (si no ho fas, la placa serà de 30x30)?");
        System.out.print("Escull (S/N): ");
        opcio = sc.next();
        if (opcio.equalsIgnoreCase("S")){
            System.out.println("\nQuin tamany vols per la placa?");
            System.out.print("Introdueix el valor: ");
            tamany = sc.nextInt();
            colonia = new Bacteris(tamany);
        }
        else{
            colonia = new Bacteris();
        }
        System.out.println("\nPartim des de aquest punt:");
        colonia.mostrarColonia();
        
        while(!colonia.isColoniaEstable() && !colonia.isColoniaDuesVoltes()){
            colonia.novaGeneracio();
            System.out.println("");
            if (!colonia.isColoniaEstable()) {
                colonia.mostrarColonia();
            }
        }
        
        if (!colonia.isColoniaDuesVoltes()) {
            System.out.println("La colònia és estable després de " +
                colonia.getNumIteracions() + " d'iteracions.");
        } else {
            System.out.println("La colònia mai serà estable.");
        }
        
    }
}
