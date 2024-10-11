import java.util.Scanner;

class Main{
	public static void invierteinteger (int n, String integer, char[] iinteger, int in){
		if (n>0){
			invierteinteger(n-1, integer, iinteger, in+1);
			iinteger[in]=integer.charAt(n);
			System.out.println(iinteger[in]);	
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int i = sc.nextInt(); 
		String integer = Integer.toString(i);
		int n= integer.length();
		char[] iinteger=new char[n];
		int in=0;
		invierteinteger(n, integer, iinteger, in);
	}
}