package EspressioniMatematica;

public class EspressioneComposta extends Espressione{
	
	protected Espressione e1;
	protected Espressione e2;
	protected Operatore op;
	
	public EspressioneComposta(Espressione e1, Espressione e2, Operatore op) {
		this.e1 = e1;
        this.e2 = e2;
        this.op = op;
	}
	
	@Override
    public double getValore()
    {
       return switch (op)
       {
            case PIU -> e1.getValore() + e2.getValore();
            case MENO -> e1.getValore() - e2.getValore();
            case PER -> e1.getValore() * e2.getValore();
            case DIVISO -> e1.getValore() / e2.getValore();
            case MODULO -> e1.getValore() % e2.getValore();
        };
    }

}
