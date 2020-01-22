package is.entity.ACMEOnlineShopping;

public class ClienteAbituale extends Cliente{
	private int numSpes;

	
	public ClienteAbituale(Carrello car, String nome, String password, String numero, String carta, int num) {
		super(car,nome, password,numero,carta);
		this.numSpes = num;
		
	}
	public int getNumSpes() {
		return numSpes;
	}
	
	public void setNumSpes(int NumSpes) {
		numSpes = NumSpes;
	}
	
	public String toString() {
		return super.toString() + " numero di Spese: " + numSpes ;
	}

}
