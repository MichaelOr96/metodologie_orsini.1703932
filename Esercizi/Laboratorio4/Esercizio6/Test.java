package esercizio6;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContoBancario cb1 = new ContoBancario(1000, "IT 17 X 03317 13401 000001234567");
		ContoBancario cb2 = new ContoBancario(2000, "UK 14 Y 04417 23421 000009876543");
		
		cb1.operazione(new PrelevaDenaro(200));
		cb1.operazione(new PrelevaDenaro(600));

		cb2.operazione(new SvuotaConto());
		cb2.operazione(new VersaDenaro(700));
		
		System.out.println();
		cb1.resoConto();
		cb2.resoConto();
		
		cb1.operazione(new Bonifico(cb2, 50));
		
		System.out.println();
		cb1.resoConto();
		cb2.resoConto();
		
		// test di versamenti e bonifici senza disponibilità
		cb1.operazione(new PrelevaDenaro(10000));
		cb1.operazione(new Bonifico(cb2, 10000));
		
		//ulteriori test a scelta
	}

}
