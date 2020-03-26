package esercizio5;

public abstract class Animale
{
    protected String verso;
    protected int numeroZampe;
    protected Taglia taglia;

    public Animale(String verso, int numeroZampe, Taglia taglia)
    {
        this.verso = verso;
        this.numeroZampe = numeroZampe;
        this.taglia = taglia;
    }

    public void emettiVerso()
    {
        System.out.println(verso);
    }

    public int getNumeroZampe() { return numeroZampe; }

    public Taglia getTaglia() { return taglia; }

}
