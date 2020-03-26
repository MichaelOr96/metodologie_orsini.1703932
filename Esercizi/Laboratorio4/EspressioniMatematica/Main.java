
public class Main {
	
	 public static void main(String[] args) {
	        Espressione cinque = new Costante(5);
	        Espressione tre = new Costante(3);
	        Espressione due = new Costante(2);

	        Espressione x = new Variabile("x",6);

	        Espressione treDivisoDue = new EspressioneComposta(tre,due,Operatore.DIVISO);
	        Espressione a = new EspressioneComposta(cinque, treDivisoDue, Operatore.PIU);
	        Espressione b = new EspressioneComposta(a,due,Operatore.MENO);
	        Espressione bInverso = new EspressioneInversa(b);
	        Espressione risultatoFinale = new EspressioneComposta(bInverso,x,Operatore.PER);
	        System.out.println(risultatoFinale.getValore());

}
