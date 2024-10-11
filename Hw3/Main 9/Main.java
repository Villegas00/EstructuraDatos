import java.util.Scanner;

class Main{
	public static void decimaltobinario (int integer, int digito,int exp, double binario){
		if (integer>0){
			decimaltobinario(integer/2, digito, exp+1 ,  binario);
			digito = integer % 2;           
            binario = binario + digito * Math.pow(10, exp);  
            System.out.println(binario);
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int integer = sc.nextInt(); 
		int digito=0;
		int exp=0;
		double binario=0;
		decimaltobinario(integer, digito,exp, binario);
	}
}