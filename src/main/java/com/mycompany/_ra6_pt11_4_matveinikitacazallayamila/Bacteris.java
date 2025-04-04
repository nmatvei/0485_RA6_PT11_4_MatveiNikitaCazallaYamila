package com.mycompany._ra6_pt11_4_matveinikitacazallayamila;


/**
 * Classe Bacteris
 * 
 * @author Nikita i Yamila
 */
public class Bacteris {
    
    /*Declaració de variables i atributs*/
    private int colonia[][];
    private int coloniaNova[][];
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
        this.generacioIncial();
        this.coloniaNova = new int[dimensio][dimensio];
        this.coloniaNova = this.colonia;
        this.coloniaEstable = false;
        this.numIteracions = 0;
    }

    public int getNumIteracions() {
        return numIteracions;
    }

    public void setNumIteracions(int numIteracions) {
        this.numIteracions = numIteracions;
    }
    
    
    /**
     * Mètode generacioIncial per omplir la matriu que representa la colònia de 
     * bacteris
     */
    private void generacioIncial(){
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                colonia[i][j] = (int) (Math.random() * 2);
            }
        }
    }
    
    public void novaGeneracio(){
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                int veins = veins(i,j);
                if(colonia[i][j] == 1){
                    if (veins < 2 || veins > 3){
                        coloniaNova[i][j] = 1;
                    }
                    else{
                        
                    }
                }
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
    
    public int veins(int posicioI, int posicioJ) {
        /*Declaració de variables*/
        int sumVeins = 0, iniciI = 1, iniciJ = 1 , finalI = 2, finalJ = 2;
        final int VECINO = 1;
        
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
                    if(colonia[i][j] == VECINO){
                       sumVeins++; 
                    }
                }
            }
        }

        return sumVeins;
    }
}