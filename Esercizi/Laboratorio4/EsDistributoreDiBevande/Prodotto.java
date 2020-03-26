package EsDistributoreDiBevande;

public class Prodotto {
	private int prezzo;
	private String tipo;
	
	public Prodotto(int p, String t)
	{
		this.tipo = t;
		this.prezzo = p;
	}
	
	public int getPrezzo() {
		return prezzo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
