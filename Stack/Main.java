/* A01329696 Rodrigo Emmanuel Oliveros Vazquez
	A01625055 Sergio Ivan Villegas Arenas*/

import java.util.*;
import java.util.regex.*;

class Main{

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Stack<String> ops  = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
      	Stack<Double> doubles = new Stack<Double>();

        String suma = "+";
		char suma2 = suma.charAt(0);
		String resta = "-";
		char resta2 = resta.charAt(0);
		String multi = "*";
		char multi2 = multi.charAt(0);
		String divi = "/";
		char divi2 = divi.charAt(0);
		String parab = "(";
		char parab2 = parab.charAt(0);
		String parcerr = ")";
		char parcerr2 = parcerr.charAt(0);

		System.out.print("Number of Operations: ");
		int op = entrada.nextInt();
		ArrayList <String> operations = new ArrayList<String>(op);
		System.out.println();
		for(int x=0; x<op; x++){
			System.out.println("Insert Operation: " + (x+1));
			String res;
			while((res=entrada.nextLine()).isEmpty());{}
			operations.add(x, res);
		}

		for(int i=0; i<operations.size(); i++){
			System.out.println("Operacion " + (i+1));
			System.out.println(operations.get(i));

			Pattern p = Pattern.compile("(\\d+(?:\\.\\d+))");
			Matcher m = p.matcher(operations.get(i));
			while(m.find()) {
			  double d = Double.parseDouble(m.group(1));
			  System.out.println(d);
   			  doubles.push(d);
			}

			for(int x=0; x<operations.get(i).length(); x++){
				//System.out.println("Caracter " + x + " : " + operations.get(i).charAt(x));
				char c;
				c = operations.get(i).charAt(x);
				if(c==parab2){}
					else
						if(c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' || c=='0'){
							//System.out.println("PRUEBA");
							//System.out.println(c);
							//double num = (double)c;
							//System.out.println(num);
							String num2 = Character.toString(c);
							double valor = Double.parseDouble(num2);
							//System.out.println(valor);
							vals.push(valor);
						}
						else
							if(c==suma2){
								ops.push(suma);
							}
							else
								if(c==resta2){
									ops.push(resta);
								}
								else
									if(c==multi2){
										ops.push(multi);
									}
									else
										if(c==divi2){
											ops.push(divi);
										}
										else
												if(c==parcerr2){

														if (vals.size()!=1) {
														double v = vals.pop();
														String pop = ops.pop();
														char simbol = pop.charAt(0);

														if(simbol==suma2){
															v = vals.pop() + v;
														}
														else
															if(simbol==resta2){
																v = vals.pop() - v;
															}
															else
																if(simbol==multi2){
																	v = vals.pop() * v;
																}
																else
																	if(simbol==divi2){
																		v = vals.pop() / v;
																	}
														vals.push(v);
														}
														else
															break;
												}
											
												
				}
			

			System.out.println();
			System.out.println("Respuesta: ");
			System.out.println(vals.pop());
			System.out.println();
			}

		}
}