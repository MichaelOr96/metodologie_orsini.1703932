package esercizio6;

public class VersaDenaro extends Operazione{

	public int versamento;
	public VersaDenaro(int vers) 
	{ 
		super(); 
		this.versamento = vers;
	}
	
	@Override
	public void esegui(ContoBancario conto) 
	{	
		System.out.println("Hai versato " + versamento + "€ sul conto con IBAN = \"" + conto.getIban() + "\".");
		conto.setDenaro(conto.getDenaro() + versamento);	
		conto.setCronologia(conto.getCronologia().concat(conto.getOrdine() + ". VersaDenaro;\n"));
		conto.incrementa();
	}

}
