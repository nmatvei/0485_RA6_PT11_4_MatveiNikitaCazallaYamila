/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._ra6_pt11_4_matveinikitacazallayamila;

import java.util.Arrays;

/**
 *
 * @author Nikita i Yamila
 */
public class Bacteris {

    /*Declaració de variables i atributs*/
    private char colonia[][];
    private char coloniaNova[][];
    private char coloniaAntiga[][];
    private boolean coloniaEstable, coloniaDuesVoltes;
    private int numIteracions;
    private final static int DIMENSIO_PER_DEFECTE = 30;

    /**
     * Constructor per defecte que truca al paràmetrizat
     */
    public Bacteris() {
        this(DIMENSIO_PER_DEFECTE);
    }

    /**
     * Constructor parametritzat
     *
     * @param dimensio
     */
    public Bacteris(int dimensio) {
        this.colonia = new char[dimensio][dimensio];
        this.generacioIncial();
        this.coloniaNova = new char[dimensio][dimensio];
        this.coloniaAntiga = new char[dimensio][dimensio];
        this.coloniaNova = this.colonia;
        this.coloniaEstable = false;
        this.coloniaDuesVoltes = false;
        this.numIteracions = 0;
    }

    public int getNumIteracions() {
        return numIteracions;
    }

    public boolean isColoniaEstable() {
        return coloniaEstable;
    }

    public boolean isColoniaDuesVoltes() {
        return coloniaDuesVoltes;
    }

    /**
     * Mètode generacioIncial per omplir la matriu que representa la colònia de
     * bacteris
     */
    private void generacioIncial() {
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                int nombre = (int) (Math.random() * 2);
                if (nombre == 1) {
                    colonia[i][j] = '#';
                } else {
                    colonia[i][j] = ' ';
                }
            }
        }
    }

    /**
     * Mètode novaGeneracio per generar una nova generacio de bacteris a la
     * colònia
     */
    public void novaGeneracio() {

        copiarColonies(coloniaAntiga, colonia);
        
        int comptadorEstable = 0;

        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                int veins = veins(i, j);
                if (colonia[i][j] == '#') {
                    if (veins <= 1) {
                        coloniaNova[i][j] = ' ';
                    } else if (veins == 2 || veins == 3) {
                        comptadorEstable++;
                    } else if (veins > 3) {
                        coloniaNova[i][j] = ' ';
                    }
                } else {
                    if (veins == 3) {
                        coloniaNova[i][j] = '#';
                    } else {
                        comptadorEstable++;
                    }
                }
            }
        }
        
        if (comptadorEstable == (colonia.length * colonia[0].length)) {
            this.coloniaEstable = true;
        } else {
            copiarColonies(colonia, coloniaNova);
            compararColonies();
        }
        
        

        this.numIteracions++;
    }

    public void copiarColonies(char[][] array1, char[][] array2) {
        
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                array1[i][j] = array2[i][j];
            }
        }

    }
    
    public void compararColonies() {
        
        int comptadorIgual = 0;
        
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia[i].length; j++) {
                if (coloniaNova[i][j] == coloniaAntiga[i][j]) {
                    comptadorIgual++;
                }
            }
        }
        
        if (comptadorIgual == (colonia.length * colonia[0].length)) {
            this.coloniaDuesVoltes = true;
        }
        
    }

    /**
     * Mètode per mostrar com es veu la colònia de bacteris en l'actual
     * generàció
     */
    public void mostrarColonia() {
        for (int i = 0; i < colonia.length; i++) {
            System.out.print("|");
            for (int j = 0; j < colonia.length; j++) {
                System.out.print(colonia[i][j]);
            }
            System.out.print("|\n");
        }
    }

    /**
     * Mètode per comptar el veïns
     *
     * @param posicioI posició de la fila
     * @param posicioJ posició de la columna
     * @return el recompte de veïns
     */
    public int veins(int posicioI, int posicioJ) {

        int sumVeins = 0, iniciI = 1, iniciJ = 1, finalI = 2, finalJ = 2;
        final char VEI = '#';

        if (posicioI == 0) {
            iniciI = 0;
        } else if (posicioI == (colonia.length - 1)) {
            finalI = 1;
        }

        if (posicioJ == 0) {
            iniciJ = 0;
        } else if (posicioJ == (colonia[posicioI].length - 1)) {
            finalJ = 1;
        }

        for (int i = posicioI - iniciI; i < (posicioI + finalI); i++) {
            for (int j = posicioJ - iniciJ; j < (posicioJ + finalJ); j++) {
                if (!(i == posicioI && j == posicioJ)) {
                    if (colonia[i][j] == VEI) {
                        sumVeins++;
                    }
                }
            }
        }

        return sumVeins;
    }
}
