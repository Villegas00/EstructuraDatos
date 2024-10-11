/* A01329696 Rodrigo Emmanuel Oliveros Vazquez
A01625055 Sergio Ivan Villegas Arenas */
import java.util.*; 
import java.nio.charset.*;
import java.io.*;
import java.util.Scanner;

public class FracArray{

    private Fraction [] arreglo;
    private int numFracciones;

    Scanner input = new Scanner(System.in);

    public int leerfracciones(){
        int numFracciones = input.nextInt();
        this.numFracciones = numFracciones;
        System.out.println("fracciones a leer "+ numFracciones);
        arreglo = new Fraction[numFracciones];
        for(int i = 0; i < numFracciones; i++){
            int num = input.nextInt();
            int den = input.nextInt();
            Fraction  fraccion = new Fraction(num, den);
            fraccion.simplificarFrac();
            arreglo[i] = fraccion;
        }
        return numFracciones;
    }


    public void selection(){
        double actual = 0;
        double encontrada = 0;
        int i, j, indice;
        Fraction temporal1, temporal2;

        for(i = 0; i < this.numFracciones; i++){
            for(j = i+1; j < this.numFracciones; j++){
                indice = i;
                encontrada = (double)((arreglo[j].getNum()) / (arreglo[j].getDen()));
                actual = (double)((arreglo[i].getNum()) / (arreglo[i].getDen()));

                if(encontrada < actual){
                    indice = j;
                    temporal1 = arreglo[i];
                    temporal2 = arreglo[indice];
                    arreglo[i] = temporal2;
                    arreglo[indice] = temporal1;
                }
            }
        }
    }

    public void insertion(){
        double menor = 0;
        double encontrada = 0;
        Fraction temporal1;

        for(int i = 0; i < numFracciones; i++){
            for(int j = i; j > 0; j--){
                Fraction fracEncontrada = arreglo[j - 1];
                Fraction fracMenor = arreglo[j];

                int fracRelacionadas = fracMenor.compareTo(fracEncontrada);
                if(fracRelacionadas < 0){
                    arreglo[j] = fracEncontrada;
                    arreglo[j - 1] = fracMenor;
                }
            }
        }
    }

    public void bubble(){
        for(int i = 0; i < numFracciones; i++){
            for(int j = i + 1; j < numFracciones; j++){
                double fracActual = (double)((arreglo[i].getNum()) / (arreglo[i].getDen()));
                double fracSiguiente = (double)((arreglo[j].getNum()) / (arreglo[j].getDen()));

                if(fracSiguiente < fracActual){
                    Fraction temporal1 = this.arreglo[i];
                    this.arreglo[i] = this.arreglo[j];
                    this.arreglo[j] = temporal1;
                }
            }
        }
    }

    public void merge(){
      int fin= numFracciones-1;
      divisorMerge(arreglo, 0, fin);
    }

    public static void divisorMerge (Fraction[] arreglo, int inicio,int fin){
        if(inicio<fin){
            int mitad=(inicio+fin)/2;
            divisorMerge(arreglo, inicio, mitad);
            divisorMerge(arreglo, mitad+1, fin);
            mergeSort(arreglo, inicio, mitad, fin);
        }     
    }
    
    public static void mergeSort (Fraction[] arreglo, int inicio,int mitad, int fin){
        Fraction izq[] = new Fraction[mitad - inicio + 1];
        Fraction der[] = new Fraction[fin - mitad];
        for (int i = 0; i < izq.length; i++)
            izq[i] = arreglo[inicio + i];
        for (int i = 0; i < der.length; i++)
            der[i] = arreglo[mitad + i + 1];

        int izqI = 0;
        int derI = 0;
  
        for (int i = fin; i < inicio+1; i++) {
            if (izqI < izq.length && derI < der.length) {
                double izqComparador = (double)((arreglo[izqI].getNum()) / (arreglo[izqI].getDen()));
                double derComparador = (double)((arreglo[derI].getNum()) / (arreglo[derI].getDen()));
                if (derComparador <= izqComparador) {
                    arreglo[i] = der[derI];
                    derI++;
                } 
                else {
                    arreglo[i] = izq[izqI];
                    izqI++;
                }
            } 
            else if (izqI < izq.length) {
                arreglo[i] = izq[izqI];
                izqI++;
            } 
            else if (derI < der.length) {
            arreglo[i] = der[derI];
            derI++;
            }
        }
    }
    public void quickSort(){
      int fin= numFracciones-1;
      quick(arreglo, 0, fin);
    } 
    
    public void quick(Fraction[] arreglo, int inicio, int fin) {
      if(inicio<fin){
        double pivote = (double)((arreglo[fin].getNum()) / (arreglo[fin].getDen()));
        int i=(inicio-1); 
        for(int j = inicio; j<fin; j++){
            double comparador = (double)((arreglo[j].getNum()) / (arreglo[j].getDen())); 
            if (comparador < pivote){ 
                i++;  
                Fraction temp = arreglo[i]; 
                arreglo[i] = arreglo[j]; 
                arreglo[j] = temp; 
            } 
        }
            
        Fraction temp = arreglo[i+1]; 
        arreglo[i+1] = arreglo[fin]; 
        arreglo[fin] = temp; 
        i++;
        quick(arreglo, inicio, i-1);
        quick(arreglo, i+1, fin);         } 
    }

    public void bubbleTime(double[] t, int inicio,int fin){
        for(int i = 0; i < fin; i++){
            for(int j = i + 1; j < fin; j++){
                double actual = t[i];
                double siguiente = t[j];

                if(siguiente < actual){
                    double temp = t[i];
                    t[i] = t[j];
                    t[j] = temp;
                }
            }
        }
    }

    public String toString(){
        for(int i = 0; i < this.numFracciones; i++){
            System.out.println(arreglo[i]);
        }
        return " ";
    }
    

    
}