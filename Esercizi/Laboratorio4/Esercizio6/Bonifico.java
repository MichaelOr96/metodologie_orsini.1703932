package esercizio6;

public class Bonifico extends Operazione{

	private ContoBancario conto2;
	private int versamento;
	public Bonifico(ContoBancario cb2, int vers) 
	{
		super();
		this.conto2 = cb2;
		this.versamento = vers;
	}
	
	@Override
	public void esegui(ContoBancario conto) 
	{
		if (versamento > conto.getDenaro()) System.out.println("Denaro per bonifico non sufficente");
		else {
			System.out.println("Versamento dal conto con IBAN = \"" + conto.getIban() + "\" di " + versamento + "€ al conto corrente con IBAN = \"" + conto2.getIban() + "\".");
			conto2.operazione(new VersaDenaro(versamento));
			conto.setCronologia(conto.getCronologia().concat(conto.getOrdine() + ". Bonifico;\n"));
			conto.incrementa();
		}
	}

}
