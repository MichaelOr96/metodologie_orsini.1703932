package esercizio6;

public class ContoBancario {
	private int denaro;
	private String iban;
	private String cronologia;
	private int ordine;
	
	public ContoBancario(int den, String ib)
	{
		this.denaro = den;
		this.iban = ib;
		this.cronologia = "";
		this.ordine = 0;
	}
	
	public String getCronologia() {
		return cronologia;
	}
	
	public void setCronologia(String cronologia) {
		this.cronologia = cronologia;
	}
	
	public int getDenaro() {
		return denaro;
	}
	
	public void setDenaro(int denaro) {
		this.denaro = denaro;
	}
	
	public int getOrdine() {
		return ordine;
	}
	
	public String getIban() {
		return iban;
	}
	
	public void incrementa() 
	{
		ordine++;
	}
	
	public void operazione(Operazione op)
	{
		op.esegui(this);
	}
	
	public void resoConto ()
	{
		System.out.println(cronologia);
	}
}
