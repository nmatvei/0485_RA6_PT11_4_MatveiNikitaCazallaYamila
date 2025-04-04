/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._ra6_pt11_4_matveinikitacazallayamila;

/**
 *
 * @author Nikita i Yamila
 */
public class Bacteris {

    private int matriu[][];
    private boolean coloniaEstable;
    int numIteracions;
    final static int DIMENSIO_COLONIA = 30;

    public Bacteris() {
        this(DIMENSIO_COLONIA);
    }

    public Bacteris(int dimensioColonia) {
        this.matriu = new int[dimensioColonia][dimensioColonia];
    }

    public void generacioInicial() {
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public void mostrarInformacio() {
        for (int i = 0; i < matriu.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.print(matriu[i][j]);
            }
            System.out.println("|");
        }
    }

    public void generarGeneracio() {

    }

    public int veins(int posicioI, int posicioJ) {
        
        int sumVeins = 0, iniciI = 1, iniciJ = 1 , finalI = 2, finalJ = 2;
        final int VECINO = 1;
        
        if (posicioI == 0) {
            iniciI = 0;
        } else if (posicioI == (matriu.length - 1)) {
            finalI = 1;
        }
        
        if (posicioJ == 0) {
            iniciJ = 0;
        } else if (posicioJ == (matriu[posicioI].length -1)) {
            finalJ = 1;
        }

        for (int i = posicioI - iniciI; i < (posicioI + finalI); i++) {
            for (int j = posicioJ - iniciJ; j < (posicioJ + finalJ); j++) {
                if (!(i == posicioI && j == posicioJ)) {
                    if(matriu[i][j] == VECINO){
                       sumVeins++; 
                    }
                }
            }
        }

        return sumVeins;
    }

}
