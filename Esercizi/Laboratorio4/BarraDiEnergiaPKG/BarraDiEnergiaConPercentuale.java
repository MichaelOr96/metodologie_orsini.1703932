

public class BarraDiEnergiaConPercentuale extends BarraDiEnergia{

	public BarraDiEnergiaConPercentuale(int k) {
		super(k);
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + (caricamento*100)/lunghezza + "%";
	}
}
