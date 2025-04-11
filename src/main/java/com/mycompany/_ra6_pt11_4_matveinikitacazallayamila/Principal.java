package com.mycompany._ra6_pt11_4_matveinikitacazallayamila;

import java.util.Scanner;

/**
 * Script on es prova la classe Bacteris amb els seus mètodes públics
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
        
        /*Preguntem a l'usuari si vol determinar el tamany de al placa*/
        System.out.println("\nAbans de començar, vols canviar el tamany de la placa "
                + "on es troben els bacteris? (si no ho fas, la placa serà de 30x30)");
        System.out.print("Escull (S/N): ");
        opcio = sc.next();
        
        /*Si la vol cambiar, determina al seva dimensió*/
        if (opcio.equalsIgnoreCase("S")){
            System.out.println("\nQuin tamany vols per la placa?");
            System.out.print("Introdueix el valor: ");
            tamany = sc.nextInt();
            colonia = new Bacteris(tamany);
        }
            
        /*Si no, serà amb la dimensió per defecte*/
        else{
            colonia = new Bacteris();
        }
        
        /*Mostrem l'estat incial*/
        System.out.println("\nPartim des de aquest punt:");
        colonia.mostrarColonia();
        System.out.println("\nAnem a veure quantes iteracions fan falta perque "
                + "la colònia sigui estable!");
        
        /*Estructura WHILE per anar generant generacions de bacteris fins que 
        sigui estàble o entri en un cicle de dues voltes*/
        while(!colonia.isColoniaEstable() && !colonia.isColoniaDuesVoltes()){
            colonia.novaGeneracio();
            System.out.println("\n--------------------------------");
            colonia.mostrarColonia();
        }
        
        /*Si s'ha parat el procces per que ha sigut un cicle de dues voltes,
        mostre un missatge indicant-lo*/
        if(colonia.isColoniaDuesVoltes()){
            System.out.println("\nDesgraciadament la colonia mai serà estable, "
                    + "estarà en un cicle infinit de dues voltes.");
        } 
        
        /*Si ha sigut perquè la colònia ha arribat a un estàt estable, mostrem un
        missatge indicant-lo*/
        else if(colonia.isColoniaEstable()){
            System.out.println("\nLa colonia és estable després de " + colonia.getNumIteracions()
            + " iteracions!");
        }
    }
}