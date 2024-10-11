import java.util.Scanner;

class Main{
	public static void invierteElements (int n, int elements[], int ielements[]){
		if (n>=0){
			invierteElements(n-1, elements, ielements);
			for(int i=0;i<n;i++){
			ielements[i]= elements[n];
			System.out.println("estas es la inversion"+ielements[i]);
			}	
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt(); 
		int[] elements = new int[n];
		int[] ielements = new int[n];
		for(int i=0;i<n;i++){
			elements[i]= sc.nextInt();
		}
		invierteElements(n, elements, ielements);
	}
}