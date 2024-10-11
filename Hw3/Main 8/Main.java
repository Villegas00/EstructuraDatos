import java.util.Scanner;

class Main{
	public static void sumainteger (int n, String integer1, int  suma, String dato){
		if (n>0){
			sumainteger(n-1, integer1, suma+suma, dato);
			System.out.println("se suma "+ integer1.charAt(n) + " a " + suma + "en vuelta" + n);
			dato=Character.toString(integer1.charAt(n));
			suma= suma+Integer.parseInt(dato);
			System.out.println("la suma final es"+suma);	
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int i = sc.nextInt(); 
		String integer1 = Integer.toString(i);
		int n= integer1.length();
		int suma=0;
		String dato="";
		sumainteger(n, integer1, suma, dato);
	}
}