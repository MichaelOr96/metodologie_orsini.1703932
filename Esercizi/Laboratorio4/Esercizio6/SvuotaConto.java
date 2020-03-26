package esercizio6;

public class SvuotaConto extends Operazione{

	
	@Override
	public void esegui(ContoBancario conto) 
	{
		System.out.println("Hai svuotato il conto con IBAN = \"" + conto.getIban() + "\".");
		conto.setDenaro(0);
		conto.setCronologia(conto.getCronologia().concat(conto.getOrdine() + ". SvuotaConto;\n"));
		conto.incrementa();
	}

}
