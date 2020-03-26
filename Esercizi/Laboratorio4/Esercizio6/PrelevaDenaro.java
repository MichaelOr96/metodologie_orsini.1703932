package esercizio6;

public class PrelevaDenaro extends Operazione{

	public int prelievo;
	public PrelevaDenaro(int prel) 
	{ 
		super(); 
		this.prelievo = prel;
	}
	
	@Override
	public void esegui(ContoBancario conto) 
	{
		if (prelievo > conto.getDenaro()) System.out.println("Denaro per il prelievo non sufficente");
		else
		{
			System.out.println("Hai prelevato " + prelievo + "€ dal conto con IBAN = \"" + conto.getIban() + "\".");
			conto.setDenaro(conto.getDenaro() - prelievo);
			conto.setCronologia(conto.getCronologia().concat(conto.getOrdine() + ". PrelevaDenaro;\n"));
			conto.incrementa();
		}
	}

}
