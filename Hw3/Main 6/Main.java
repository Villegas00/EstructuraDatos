import java.util.Scanner;

class Main{
	public static void invierteString (int n, String string, char[] istring, int in){
		if (n>0){
			invierteString(n-1, string, istring,in+1);
			istring[in]=string.charAt(n);
			System.out.println(istring);	
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String string = sc.nextLine(); 
		int n=string.length();
		char[] istring= new char[n];
		int in=0;
		invierteString(n, string, istring, in);
		
	}
}