import java.util.Scanner;



class Hanoi{
	public static void haoi (it n, String orig, String dest, String temp){
		if(n>0){
//			System.out.printl("mover "+ (n-1) +"discos de  " + orig + "al " + temp);
			hanoi(n-1,orig, temp, dest);
			System.out.printl("mueve el disco "+ n +"de " + orig + "a " + dest);
//			System.out.printl("mover "+ (n-1) +"discos de  " + temp + "al " + destn);
			hanoi(n-1, temp, dest, orig);
		}
	}

	public static cod public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n= sc.next.Int();
		hanoi()n, "Torre A", "Torre C", "Torre B";
	}
}