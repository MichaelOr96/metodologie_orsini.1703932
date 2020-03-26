

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BarraDiEnergia b1 = new BarraDiEnergia(15);
		BarraDiEnergiaConPercentuale b2 = new BarraDiEnergiaConPercentuale(15);
		
		int n = 6;
		for (int i = 0; i < n; i++)
		{
			b1.incremento();
			b2.incremento();
		}

		System.out.println(b1.toString());
		System.out.println(b2.toString());
		
		
	}

}
