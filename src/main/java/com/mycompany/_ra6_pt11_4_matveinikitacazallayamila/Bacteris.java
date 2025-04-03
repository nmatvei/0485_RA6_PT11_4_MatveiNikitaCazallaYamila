package com.mycompany._ra6_pt11_4_matveinikitacazallayamila;

import java.util.Random;

/**
 * Classe Bacteris
 * 
 * @author Nikita i Yamila
 */
public class Bacteris {
    
    /*Declaració de variables i atributs*/
    private int colonia[][];
    private boolean coloniaEstable;
    private int numIteracions;
    private final static int DIMENSIO_PER_DEFECTE = 30;
    
    /**
     * Constructor per defecte que truca al paràmetrizat
     */
    public Bacteris(){
        this(DIMENSIO_PER_DEFECTE);
    }
    
    /**
     * Constructor paràmetritzat
     * 
     * @param dimensio 
     */
    public Bacteris(int dimensio) {
        this.colonia = new int [dimensio][dimensio];
        this.coloniaEstable = false;
        this.numIteracions = 0;
    }
    
    public void generacioIncial(){
        Random generarNombres = new Random();
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                colonia[i][j] = (int) (Math.random() * 2);
            }
        }
    }
    
    /**
     * Mètode per mostrar com es veu la colònia de bacteris en l'actual generàció
     */
    public void mostrarColonia(){
        for (int i = 0; i < colonia.length; i++) {
            System.out.print("|");
            for (int j = 0; j < colonia.length; j++) {
                System.out.print(colonia[i][j]);
            }
            System.out.print("|\n");
        }
    }
    
}
