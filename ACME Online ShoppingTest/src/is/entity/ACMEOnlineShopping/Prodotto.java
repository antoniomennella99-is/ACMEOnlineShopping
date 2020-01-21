package is.entity.ACMEOnlineShopping;

public class Prodotto {
	private int CodiceProd;
	private String nomeProd;
	private String descrizioneProd;
	private double prezzoProd;
	private int Q_disponibileProd;
	
	public Prodotto(int codice, String nome, String descrizione, double prezzo) {
		this.setCodiceProd(codice);
		this.setNomeProd(nome);
		this.setDescrizioneProd(descrizione);
		this.setPrezzoProd(prezzo);
	}
	
	public Prodotto(int codice, String nome, String descrizione, double prezzo, int quantita) {
		this.setCodiceProd(codice);
		this.setNomeProd(nome);
		this.setDescrizioneProd(descrizione);
		this.setPrezzoProd(prezzo);
		this.setQ_disponibileProd(quantita);
	}

	public int getCodiceProd() {
		return CodiceProd;
	}

	public void setCodiceProd(int codiceProd) {
		CodiceProd = codiceProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getDescrizioneProd() {
		return descrizioneProd;
	}

	public void setDescrizioneProd(String descrizioneProd) {
		this.descrizioneProd = descrizioneProd;
	}

	public double getPrezzoProd() {
		return prezzoProd;
	}

	public void setPrezzoProd(double prezzoProd) {
		this.prezzoProd = prezzoProd;
	}

	public int getQ_disponibileProd() {
		return Q_disponibileProd;
	}

	public void setQ_disponibileProd(int q_disponibileProd) {
		Q_disponibileProd = q_disponibileProd;
	}

	public String toString() {
		return "Prodotto: " + nomeProd +" Prezzo: "+ prezzoProd + "€.";
	}
	
}
