import java.util.Scanner;

class Main{
	public static void sumaElements (int n, int elements[],int suma){
		if (n>0){
			sumaElements(n-1, elements, suma+suma);
			System.out.println("se suma "+ elements[n] + " a " + suma + "en vuelta" + n);
			suma=suma+elements[n];
			System.out.println("la suma final es "+suma);
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt(); 
		int[] elements = new int[n];
		for(int i=0;i<n;i++){
			elements[i]= sc.nextInt();
			System.out.println(i+" "+n);
		}
		int suma=0;
		sumaElements(n, elements, suma);
	}
}