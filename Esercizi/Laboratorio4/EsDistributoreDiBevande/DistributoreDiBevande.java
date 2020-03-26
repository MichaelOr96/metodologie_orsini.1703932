package EsDistributoreDiBevande;

import java.util.Random;

public class DistributoreDiBevande {
	private int N;
	private Prodotto[] listaProdotti; 
	private int saldo; 
	
	public DistributoreDiBevande(int n)
	{
		this.N = n;
		this.listaProdotti = new Prodotto[N];
		this.saldo = 0;
	}
	
	public void carica(int num)
	{
		if (postiDisponibili() < num)
		{
			System.out.println("Posti non disponibili");
			return;
		}
		int tipo = 0;
		int posto;
		int prezzo = 0;
		boolean ripetizione = false;
		Random r = new Random();
		for (int i = 0; i<num; i++)
		{
			if (!ripetizione)
			{
				tipo = r.nextInt(3);
				prezzo = r.nextInt(10);
			}
			posto = r.nextInt(N);
			if (listaProdotti[posto] != null)
			{
				i--;
				ripetizione = true;
				continue;
			}
			else ripetizione = false;
			switch(tipo)
			{
				case 0: listaProdotti[posto] = new Caffe(prezzo); break;
				case 1: listaProdotti[posto] = new Cappuccino(prezzo); break;
				case 2: listaProdotti[posto] = new Cioccolato(prezzo); break; 
			}
			
		}
	}
	
	public void inserisciImporto(int importo)
	{
		saldo += importo;
	}
	
	public Prodotto getProdotto(int num)
	{
		if (listaProdotti[num] == null) 
		{
			System.out.println("Nessun prodotto a questo numero");
			return null;
		}
		else
		{
			if (listaProdotti[num].getPrezzo()>getSaldo())
			{
				System.out.println("Saldo insufficente");
				return null;
			}
			else
			{
				System.out.println("Ecco a te il tuo " + listaProdotti[num].getTipo());
				Prodotto out = listaProdotti[num];
				saldo -= out.getPrezzo();
				listaProdotti[num] = null;
				return out;
			}
		}
	}
	
	public int getSaldo()
	{
		return saldo;
	}
	
	public int getResto()
	{
		System.out.println("Il saldo è stato resettato a 0");
		int resto = saldo;
		saldo = 0;
		return resto;
	}
	
	private int postiDisponibili()
	{
		int cont = 0;
		for (int i = 0; i<listaProdotti.length; i++)
		{
			if (listaProdotti[i] == null) cont++;
		}
		return cont;
	}
	
	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i<listaProdotti.length; i++) 
		{
			if (listaProdotti[i]==null) out += listaProdotti[i] + "\n";
			else out += listaProdotti[i].getTipo() + "\n";
		}
		return out;
	}
}
