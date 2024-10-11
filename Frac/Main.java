/* A01329696 Rodrigo Emmanuel Oliveros Vazquez
A01625055 Sergio Ivan Villegas Arenas */
public class Main{

    public  static double tSelection;
    public  static double tInsertion;
    public  static double tBubble;
    public static double tQuick;
    public static double tMerge;


    public static void main (String[]args){
        
        Fraction a = new Fraction(1, 2);
        Fraction o = new Fraction(1, 2);
        FracArray elarray = new FracArray();
        elarray.leerfracciones();

        System.out.println("arreglo original ");
        System.out.println(elarray);

        System.out.println("Selection sort");
        double ms1 = inicio();
        elarray.selection();
        tSelection = termina(ms1);
        System.out.println(elarray);

        System.out.println("Insertion sort");
        double ms2 = inicio();
        elarray.insertion();
        tInsertion = termina(ms2);
        System.out.println(elarray);

        System.out.println("Bubble sort");
        double ms3 = inicio();
        elarray.bubble();
        tBubble = termina(ms3);
        System.out.println(elarray);

        System.out.println("Quick sort");
        double ms4 = inicio();
        elarray.quickSort();
        tQuick = termina(ms4);
        System.out.println(elarray);

        System.out.println("Merge sort");
        double ms5 = inicio();
        elarray.merge();
        tMerge = termina(ms5);
        System.out.println(elarray);

        System.out.println("Los tiempos son");
        double [] t= {tSelection,tInsertion, tBubble, tQuick, tMerge};
        elarray.bubbleTime(t, 0, t.length-1);
        for(int i = 0; i<=t.length-1; i++){
            if(tSelection==t[i])  
                System.out.println("Selection sort " +t[i]/ 1000000.0);
            if(tInsertion==t[i])  
                System.out.println("Insertion sort " +t[i]/ 1000000.0);
            if(tBubble==t[i])  
                System.out.println("Bubble sort " +t[i]/ 1000000.0);             
            if(tQuick==t[i])  
                System.out.println("Quick sort " +t[i]/ 1000000.0);
            if(tMerge==t[i])  
                System.out.println("Merge sort " +t[i]/ 1000000.0);
        }
    }

    public static double inicio(){
    	
    	double startTime = System.nanoTime();
    	return startTime;
    }

    public static double termina(double t){
    	
    	double tiempoTotal = System.nanoTime(); 
    	double result = (tiempoTotal- t) ;
    	return result;
    }
}