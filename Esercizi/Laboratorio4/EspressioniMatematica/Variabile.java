package EspressioniMatematica;

public class Variabile extends Espressione{
	
	private String nomeVariabile;
    private double valoreVariabile;
    public Variabile(String nomeVariabile, double valoreVariabile)
    {
        this.nomeVariabile = nomeVariabile;
        this.valoreVariabile = valoreVariabile;
    }

    @Override
    public double getValore() { return valoreVariabile; }

    public String getNomeVariabile() { return nomeVariabile; }
}

}
