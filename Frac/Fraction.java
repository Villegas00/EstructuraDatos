/* A01329696 Rodrigo Emmanuel Oliveros Vazquez
A01625055 Sergio Ivan Villegas Arenas */
class Fraction implements Comparable<Fraction>{

	int num;
	int den;

	int men (int x, int y){
		if(x<y)
			return x;
		else
			return y;
	}

	Fraction (int num, int den){
		this.num = num;
		this.den = den;
	}

	public int getNum(){
		return this.num;
	}

	public int getDen(){
		return this.den;
	}

	Fraction multiplicarFrac(Fraction a, Fraction b){
		return new Fraction (a.num*b.num,a.den*b.den);
	}

	Fraction sumarFrac (Fraction o){
		return new Fraction (this.den * o.num + this.num * o.den, this.den * o.den);
	}

	void simplificarFrac(){
		int menor = men (num, den);
		for (int i = menor; i>1; i--) {
			if (num%i==0 && den%i==0) {
				num = num/i;
				den = den/i;
				i=1;
			}
		}
	}

	public String toString () {
		return num + "/" + den;
	}

	public int compareTo(Fraction o){
		double entrada = (double)((o.getNum()) / (o.getDen()));
		double local = (double)((this.num / (this.den)));
		if(local == entrada)
			return 0;
		if(local < entrada)
			return -1;
		else
			return 1;

	}
}