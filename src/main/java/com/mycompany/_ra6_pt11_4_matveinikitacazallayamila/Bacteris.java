package com.mycompany._ra6_pt11_4_matveinikitacazallayamila;

import java.util.Arrays;


/**
 * Classe Bacteris
 * 
 * @author Nikita i Yamila
 */
public class Bacteris {
    
    /*Declaració de variables i atributs*/
    private char colonia[][];
    private char coloniaNova[][];
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
        this.colonia = new char [dimensio][dimensio];
        this.generacioIncial();
        this.coloniaNova = new char[dimensio][dimensio];
        this.coloniaNova = this.colonia;
        this.coloniaEstable = false;
        this.numIteracions = 0;
    }

    public int getNumIteracions() {
        return numIteracions;
    }

    public boolean isColoniaEstable() {
        return coloniaEstable;
    }
    
    /**
     * Mètode generacioIncial per omplir la matriu que representa la colònia de 
     * bacteris
     */
    private void generacioIncial(){
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                int nombre = (int) (Math.random() * 2);
                if (nombre == 1){
                    colonia[i][j] = '#';
                } else{
                    colonia[i][j] = ' ';
                }
            }
        }
    }
    
    /**
     * Mètode novaGeneracio per generar una nova generacio de bacteris a la colònia
     */
    public void novaGeneracio(){
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                int veins = veins(i,j);
                if(colonia[i][j] == '#'){
                    if (veins < 2 || veins > 3){
                        coloniaNova[i][j] = ' ';
                    }
                } else{
                    if (veins == 3){
                        coloniaNova[i][j] = '#';
                    }
                }
            }
        }
        
        
        
        if (!this.coloniesIguals()){
            this.numIteracions++;
            colonia = coloniaNova;
        } else {
            coloniaEstable = true;
        } 
    }
    
    /**
     * Mètode per mostrar com es veu la colònia de bacteris en l'actual generàció
     */
    public void mostrarColonia(){
        for (int i = 0; i < coloniaNova.length; i++) {
            System.out.print("|");
            for (int j = 0; j < coloniaNova.length; j++) {
                System.out.print(coloniaNova[i][j]);
            }
            System.out.print("|\n");
        }
    }
    
    
    public int veins(int posicioI, int posicioJ) {
        /*Declaració de variables*/
        int sumVeins = 0, iniciI = 1, iniciJ = 1 , finalI = 2, finalJ = 2;
        final char VEI = '#';
        
        if (posicioI == 0) {
            iniciI = 0;
        } else if (posicioI == (colonia.length - 1)) {
            finalI = 1;
        }
        
        if (posicioJ == 0) {
            iniciJ = 0;
        } else if (posicioJ == (colonia[posicioI].length -1)) {
            finalJ = 1;
        }

        for (int i = posicioI - iniciI; i < (posicioI + finalI); i++) {
            for (int j = posicioJ - iniciJ; j < (posicioJ + finalJ); j++) {
                if (!(i == posicioI && j == posicioJ)) {
                    if(colonia[i][j] == VEI){
                       sumVeins++; 
                    }
                }
            }
        }

        return sumVeins;
    }
    
    private boolean coloniesIguals(){
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                if(colonia[i][j] != coloniaNova[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}