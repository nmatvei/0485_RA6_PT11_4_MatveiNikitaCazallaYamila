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
    final int DIMENSIO_COLONIA = 30;

    public Bacteris() {
        this.matriu = new int[DIMENSIO_COLONIA][DIMENSIO_COLONIA];
    }

    public Bacteris(int dimensioColonia) {
        this.matriu = new int[dimensioColonia][dimensioColonia];
    }

    public void generacioInicial() {

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = (int) Math.random() * 2;
            }
        }

    }

    public void mostrarInformacio() {

    }

    public void generarGeneracio() {

    }

    public int veins(int posicioI, int posicioJ) {
        
        int sumVeins = 0;

        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 1; j++) {
                if (i != 0 && j != 0) {
                    sumVeins += matriu[i][j];
                }
            }
        }

        return sumVeins;
    }

}
