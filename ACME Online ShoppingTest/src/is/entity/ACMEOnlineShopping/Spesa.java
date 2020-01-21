package is.entity.ACMEOnlineShopping;
import java.time.LocalDate;

public class Spesa {
	private int ID;
	private double costo_totale;
	private LocalDate Data;
	private StatoSpesa statoSpesa;
	private Carrello listaAcquisti;
	
	public Spesa() {
		this.setID(0);
		this.setCosto_totale(0);
		this.setData(null);
		this.setStatoSpesa(null);
		this.setListaAcquisti(null);
	}
	
	public Spesa(int id, double costo,  LocalDate data, StatoSpesa stato, Carrello lista) {
		this.setID(id);
		this.setCosto_totale(costo);
		this.setData(data);
		this.setStatoSpesa(stato);
		this.setListaAcquisti(lista);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getCosto_totale() {
		return costo_totale;
	}

	public void setCosto_totale(double costo_totale) {
		this.costo_totale = costo_totale;
	}

	public LocalDate getData() {
		return Data;
	}

	public void setData(LocalDate data) {
		Data = data;
	}

	public StatoSpesa getStatoSpesa() {
		return statoSpesa;
	}

	public void setStatoSpesa(StatoSpesa statoSpesa) {
		this.statoSpesa = statoSpesa;
	}

	public Carrello getListaAcquisti() {
		return listaAcquisti;
	}

	public void setListaAcquisti(Carrello listaAcquisti) {
		this.listaAcquisti = listaAcquisti;
	}
	
	public String toString() {
		return "ID: " + ID + " Costo: " + costo_totale + listaAcquisti.getCliente() + " data: " + Data;
	}
}
