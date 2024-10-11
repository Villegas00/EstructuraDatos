import java.util.Scanner;

class Main{
	public static void comparaString (int n1, String string1 , String string2){
		if (n1>=0){
			comparaString(n1-1, string1, string2);
//			System.out.println("Comparo letra a "+n1+string1.charAt(n1)+string2.charAt(n1));
			if(string1.charAt(n1)!=string2.charAt(n1))
				System.out.println("No es la misma palabra");
		}
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String string1 = sc.nextLine();
		String string2 = sc.nextLine();
		int n1=	string1.length()-1;
		comparaString(n1, string1, string2);
	}
}