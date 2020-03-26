package esercizio6;

public class SituazioneConto extends Operazione{

	
	@Override
	public void esegui(ContoBancario conto) {
		System.out.println("Il tuo IBAN: " + conto.getIban() + "\nDenaro disponibile: " + conto.getDenaro());
		conto.setCronologia(conto.getCronologia().concat(conto.getOrdine() + ". SituazioneConto;\n"));
		conto.incrementa();
	}

}
