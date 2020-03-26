package EspressioniMatematica;

public class Costante extends Espressione{
	
	private final double costante;
	public Costante(double costante) {
		this.costante = costante;
	}
	
	@Override
	public double getValore() { return costante; }

}
