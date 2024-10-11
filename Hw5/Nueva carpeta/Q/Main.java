import java.util.Scanner;

class Main{
    public static void quicksort (int[] a, int inicio,int fin){
        if(inicio<fin){
            int temp=0;
            int pivote = a[fin];
            int i=(inicio-1);
            for(int j = inicio; j<fin; j++){
                if (a[j] < pivote){ 
                    i++;  
                    temp = a[i]; 
                    a[i] = a[j]; 
                    a[j] = temp; 
                } 
            }
            temp = a[i+1]; 
            a[i+1] = a[fin]; 
            a[fin] = temp; 
            i++;
            quicksort(a, i+1, fin); 
        } 
        
    }

    public static void main(String[] args){
        int a[] = {4,8,2,9,11,32,45,65,9,7,8};
        int fin = a.length; 
        int inicio = 0;
        for(int i = 0; i<fin; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        quicksort(a, inicio, fin);
        for(int i = 0; i<fin; i++){
            System.out.print(a[i]+" ");
        }
    }
}