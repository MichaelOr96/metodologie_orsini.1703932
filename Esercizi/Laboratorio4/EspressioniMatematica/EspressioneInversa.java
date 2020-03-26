package EspressioniMatematica;

public class EspressioneInversa extends Espressione{
	
	private Espressione e;
    public EspressioneInversa(Espressione e)
    {
        this.e = e;
    }

    @Override
    public double getValore() { return -e.getValore(); }

}
