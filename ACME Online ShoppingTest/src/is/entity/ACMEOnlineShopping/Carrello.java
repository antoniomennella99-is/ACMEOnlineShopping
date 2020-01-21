package is.entity.ACMEOnlineShopping;
import java.util.ArrayList;
public class Carrello {
	private int quantita;
	private Cliente cliente;
	 private ArrayList<Prodotto> listaprodotti;
	
 
	public Carrello() {
		this.quantita = 0;
		this.cliente = null;
		this.listaprodotti = new ArrayList<Prodotto>();
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String toString() {
		return " Carrello di: "+ cliente + " prodotti: " + quantita;
	}

	public ArrayList<Prodotto> getListaprodotti() {
		return listaprodotti;
	}

	public void setListaprodotti(ArrayList<Prodotto> listaprodotti) {
		this.listaprodotti = listaprodotti;
	}
}
