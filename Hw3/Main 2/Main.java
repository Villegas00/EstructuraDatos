import java.util.Scanner;

class Main{
	public static void numberchar (int n1, char char1 , String string){
		int n2=0;
		System.out.println(n1);
		if (n1>=0){
			numberchar(n1-1, char1, string);
			System.out.println("Comparo letra "+ n1+ string.charAt(n1)+char1);
			if(string.charAt(n1)==char1){
				n2=(n2+1);
				System.out.println(" hola ");
			}
		}
		System.out.println(n2);
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		char char1 = sc.next().charAt(0);
		String string = sc.nextLine();
		int n1=	string.length()-1;
		numberchar(n1,char1, string);
	}
}