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

        int izqI = 0;
        int derI = 0;

       
        for (int i = inicio; i < fin+1; i++) {
            if (izqI < izq.length && derI < der.length) {
                if (izq[izqI] < der[derI]) {
                    a[i] = izq[izqI];
                    izqI++;
                } 
                else {
                    a[i] = der[derI];
                    derI++;
                }
            } 
            else if (izqI < izq.length) {
                a[i] = izq[izqI];
                izqI++;
            } 
            else if (derI < der.length) {
            a[i] = der[derI];
            derI++;
            }
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