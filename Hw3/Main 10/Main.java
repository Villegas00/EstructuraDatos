import java.util.Scanner;

class Main{
	public static char[] invierteString (int n, String string, char[] istring, int in){
		if (n>0){
			invierteString(n-1, string, istring,in+1);
			istring[in]=string.charAt(n);
			System.out.println(istring);	
		}
		return istring;
	}

	public static void comparaString (int n, String string , char[] istring){
		if (n>=0){
			comparaString(n-1, string, istring);
			System.out.println(n);
			System.out.println("Comparo letra a "+n+string.charAt(n)+istring[n]);
			if(string.charAt(n)!=istring[n]);
				System.out.println("No es palindromo");
		}
	}

public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String string = sc.nextLine(); 
		int n=string.length();
		char[] istring= new char[n];
		int in=0;
		invierteString(n, string, istring, in);
		comparaString(n, string, istring);
	}

}