import java.util.Scanner;

class Main{
	public static void menorNumero (int n, int numeros[],int menor){
		if (n>0){
			menorNumero(n-1, numeros, menor);
			System.out.println("comparo"+numeros[n]+"con"+menor+"en vuelta"+n);
			if (numeros[n]<menor)
				menor = numeros[n];
		}
	System.out.println(menor);
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt(); 
		int[] numeros = new int[n];
		for(int i=0;i<n;i++){
			numeros[i]= sc.nextInt();
			System.out.println(i+" "+n);
		}
		int menor = numeros[n];
		menorNumero(n, numeros, menor);
	}
}