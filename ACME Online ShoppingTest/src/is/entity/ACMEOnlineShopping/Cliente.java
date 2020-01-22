package is.entity.ACMEOnlineShopping;

public class Cliente {
	protected String nomeCli;
	protected String passwordC;
	protected String numTel;
	protected String CartaCredito;
	protected Carrello carrello;
	
	public Cliente(Carrello car,String nome, String password, String numero, String carta) {
		this.setNomeCli(nome);
		this.setPasswordC(password);
		this.setNumTel(numero);
		this.setCartaCredito(carta);
		this.setCarrello(car);
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	public String getPasswordC() {
		return passwordC;
	}

	public void setPasswordC(String passwordC) {
		this.passwordC = passwordC;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getCartaCredito() {
		return CartaCredito;
	}

	public void setCartaCredito(String cartaCredito) {
		CartaCredito = cartaCredito;
	}
	
	public String toString() {
		return " Cliente: " + nomeCli + " Telefono: " + numTel;
	}

	public Carrello getCarrello() {
		return carrello;
	}

	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}
	
}
