package com.mycompany._ra6_pt11_4_matveinikitacazallayamila;

import java.util.Arrays;

/**
 * Classe Bacteris que representa una placa on es troben bacteris.
 * 
 * @author Nikita i Yamila
 */
public class Bacteris {

    /*Declaració de variables i atributs*/
    private int colonia[][];
    private int coloniaNova[][];
    private int coloniaAntiga[][];
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
        this.colonia = new int[dimensio][dimensio];
        this.coloniaNova = new int[dimensio][dimensio];
        this.coloniaAntiga = new int[dimensio][dimensio];
        this.generacioIncial();
        this.coloniaEstable = false;
        this.coloniaDuesVoltes = false;
        this.numIteracions = 0;
    }
    
    /**
     * Mètode GET per conseguir el nombre d'iteracions
     * 
     * @return nombre d'iteracions
     */
    public int getNumIteracions() {
        return numIteracions;
    }
    
    /**
     * Mètode GET per veure si la colònia és estable
     * 
     * @return si la colònia és estable
     */
    public boolean isColoniaEstable() {
        return coloniaEstable;
    }
    
    /**
     * Mètode GET per veure si la colònia no es troba en un cicle de dues voltes
     * 
     * @return si es troba en un cicle de dues voltes
     */
    public boolean isColoniaDuesVoltes() {
        return coloniaDuesVoltes;
    }

    /**
     * Mètode generacióInicial per generar una colonia de manera aleatoria
     */
    private void generacioIncial() {
        for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                int nombre = (int) (Math.random() * 2);
                    coloniaNova[i][j] = nombre;
            }
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
                System.out.print(coloniaNova[i][j]);
            }
            System.out.print("|\n");
        }
    }

    /**
     * Mètode novaGeneracio per generar una nova generacio de bacteris a la
     * colònia i guardar els estàts anteriors de la colònia.
     */
    public void novaGeneracio() {
        /*Copiem el contingut de la matrius a */
        this.coloniaAntiga = copiarMatriu(colonia);
        this.colonia = copiarMatriu(coloniaNova);
        
         for (int i = 0; i < colonia.length; i++) {
            for (int j = 0; j < colonia.length; j++) {
                int veins = veins(i,j);
                if(colonia[i][j] == 1){
                    if (veins < 2 || veins > 3){
                        coloniaNova[i][j] = 0;
                    }
                } else{
                    if (veins == 3){
                        coloniaNova[i][j] = 1;
                    }
                }
            }
        }
        
        /*Determinem si la colònia és estàble o si es troba en un bucle de dues
         voltes*/
        if(coloniesIgualsAntiga()){
            this.coloniaEstable = true;
        } else if (coloniesIgualsLoop()){
            this.coloniaDuesVoltes = true;
        }
        
        /*Augmentem el número d'iteracions*/
        this.numIteracions++;
    }
    
    /**
     * Mètode copiaMatriu per copiar una matriu utilitzat el mètode clone()
     * @param original
     * @return una còpia de la matriu introduïda com a paràmetre
     */
    private int[][] copiarMatriu(int[][] matriuOriginal) {
        /*Declarem una matriu que serà la còpia*/
        int[][] copiaMatriu = new int[matriuOriginal.length][];
        
        /*Estrutura FOR per copiar el contingut de la matriu*/
        for (int i = 0; i < matriuOriginal.length; i++) {
            copiaMatriu[i] = matriuOriginal[i].clone();
        }
        
        /*Retornem la còpia de la matriu*/
        return copiaMatriu;
    }

    /**
     * Mètode coloniesIgualsAntiga per comprovar que el contingut de coloniaNova
     * i colonia són iguals.
     * 
     * @return true o false
     */    
    private boolean coloniesIgualsAntiga() {
        boolean iguals = Arrays.deepEquals(coloniaNova, colonia);
        return iguals;
    }
    
    /**
     * Mètode coloniesIgualsLoop per comprovar si el contingut de coloniaNova i
     * coloniaAntiga és el mateix, per veure si la colònia es troba en un cicle
     * de dues voltes.
     * 
     * @return true o false
     */
    private boolean coloniesIgualsLoop(){
        boolean iguals = Arrays.deepEquals(coloniaNova, coloniaAntiga);
        return iguals;
    }

    /**
     * Mètode per comptar el veïns
     *
     * @param posicioI posició de la fila
     * @param posicioJ posició de la columna
     * @return el recompte de veïns
     */
    public int veins(int posicioI, int posicioJ) {
        /*Declaració de variables*/
        int sumVeins = 0, iniciI = 1, iniciJ = 1, finalI = 2, finalJ = 2;
        final int VEI = 1;
        
        /*Determinem les condicions per el següent FOR per que no es pasi de l'array*/
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
        
        /*Estructura FOR per pasar d'una determinada manera per calular el nombre
        veins d'una posició de la taula*/
        for (int i = posicioI - iniciI; i < (posicioI + finalI); i++) {
            for (int j = posicioJ - iniciJ; j < (posicioJ + finalJ); j++) {
                if (!(i == posicioI && j == posicioJ)) {
                    if (colonia[i][j] == VEI) {
                        sumVeins++;
                    }
                }
            }
        }
        
        /*Retornem el nombre de veïns*/
        return sumVeins;
    }
}