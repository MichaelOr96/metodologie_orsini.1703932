
public class BarraDiEnergia{

	protected int lunghezza;
	protected int caricamento;
	
	public BarraDiEnergia(int k)
	{
		this.lunghezza = k;
		this.caricamento = 0;
	}
	
	public void incremento()
	{
		caricamento++;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out ="";
		for (int i = 0; i<lunghezza; i++)
		{
			if (i<caricamento) out += "O";
			else out += "=";
		}
		return out;
	}
}
