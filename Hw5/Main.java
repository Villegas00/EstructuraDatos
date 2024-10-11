import java.util.Scanner;

class Main{
    public static void divisorMerge (int[] a, int inicio,int fin){
        if(inicio<fin){
            int mitad=(inicio+fin)/2;
            divisorMerge(a, inicio, mitad);
            divisorMerge(a, mitad+1, fin);
            mergeSort(a, inicio, mitad, fin);
        } 
        
    }

    public static void mergeSort (int[] a, int inicio,int mitad, int fin){
        int izq[] = new int[mitad - inicio + 1];
        int der[] = new int[fin - mitad];
        for (int i = 0; i < izq.length; i++)
            izq[i] = a[inicio + i];
        for (int i = 0; i < der.length; i++)
            der[i] = a[mitad + i + 1];

        int n = 0;
        int j = 0;
        int h = inicio;
        while (n < izq.length && j < der.length) {
            if (izq[n] <= der[j]) {
                a[h] = izq[n];
                n++;
            }
            else {
                a[h] = der[j++];
                j++;
            }
            h++;
        }
        while (n < izq.length) {
            a[h] = izq[n];
            h++;
            n++;
        }
        while (j < der.length) {
            a[h] = der[j];
            h++;
            j++;
        }

    }

    public static void main(String[] args){
        int a[] = {48,8,2,9,11,32,45,9,7,8}; 
        int fin = 9; 
        int inicio = 0; 
        for(int i = 0; i<fin; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");
        divisorMerge(a, 0, fin);
        for(int i = 0; i<fin; i++){
            System.out.print(a[i]+" ");
        }
    }
}