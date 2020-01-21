package is.entity.ACMEOnlineShopping;

import java.time.LocalDate;

public class Sconto {
	private int Codice_Sconto;
	private double Percentuale_di_Sconto;
	private LocalDate Data_Scadenza;
	
	public Sconto(int codice, double percentuale, LocalDate data) {
		this.setCodice_Sconto(codice);
		this.setPercentuale_di_Sconto(percentuale);
		this.setData_Scadenza(data);
	}

	public int getCodice_Sconto() {
		return Codice_Sconto;
	}

	public void setCodice_Sconto(int codice_Sconto) {
		Codice_Sconto = codice_Sconto;
	}

	public double getPercentuale_di_Sconto() {
		return Percentuale_di_Sconto;
	}

	public void setPercentuale_di_Sconto(double percentuale_di_Sconto) {
		Percentuale_di_Sconto = percentuale_di_Sconto;
	}

	public LocalDate getData_Scadenza() {
		return Data_Scadenza;
	}

	public void setData_Scadenza(LocalDate data_Scadenza) {
		Data_Scadenza = data_Scadenza;
	}
	
	public String toString() {
		return "\nSconto: " + getCodice_Sconto() + " Percentuale: " + getPercentuale_di_Sconto() +"% Scadenza: " + getData_Scadenza(); 
	}
}
