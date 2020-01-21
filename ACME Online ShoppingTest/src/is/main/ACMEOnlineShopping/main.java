package is.main.ACMEOnlineShopping;
import is.control.ACMEOnlineShopping.*;
import is.entity.ACMEOnlineShopping.*;

import java.time.LocalDate;
import java.time.Month;
//import java.util.*;

public class main {
	
	
	public static void main(String[] args) {
	
	//GestioneClienti gestoreclienti = new GestioneClienti();
	GestioneProdotti gestoreprodotti = new GestioneProdotti();
	//GestioneSpesa gestorespesa = new GestioneSpesa();
	
	Carrello car1 = new Carrello();
	Carrello car2 = new Carrello();	
	Carrello car3 = new Carrello();
	Carrello car5 = new Carrello();
	Carrello car4 = new Carrello();
	Carrello car6 = new Carrello();
	
	LocalDate data1 = LocalDate.of(2019, Month.JANUARY, 20);
	LocalDate data2 = LocalDate.of(2019, Month.JANUARY, 23);
	LocalDate data3 = LocalDate.of(2019, Month.JANUARY, 31);
	LocalDate data_Sconto1 = LocalDate.of(2019, Month.FEBRUARY, 24);
	LocalDate data_Sconto2 = LocalDate.of(2019, Month.JANUARY, 22);
	LocalDate data4 = LocalDate.of(2019, Month.FEBRUARY, 7);
	LocalDate data_nunzia = LocalDate.of(2019, Month.JANUARY, 20);
	LocalDate data_nunzia2 = LocalDate.of(2019, Month.JANUARY, 23);
	
	Cliente antonio = new Cliente (car1, "Antonio", "Maria", "1234466", "2414 5664 5433");
	Cliente nunzia = new Cliente (car2, "Nunzia", "alsldl", "45674322", "152255 5494 48");
	
	car1.setCliente(antonio);
	car2.setCliente(nunzia);
	car3.setCliente(antonio);
	car5.setCliente(antonio);
	car4.setCliente(nunzia);
	car6.setCliente(nunzia);
	
	Prodotto farina = new Prodotto(123,"Farina", "Tipo 00", 1);
	Prodotto latte = new Prodotto(321, "Latte", "Parmalat", 2);
	Prodotto detersivo = new Prodotto(456, "Detersivo", "Smacchiante", 5);
	Prodotto uova = new Prodotto(777, "Uova", "Coccodrillo", 3);
	
	Spesa spesa_antonio;
	Spesa spesa_nunzia;
	Spesa spesa_antonio2;
	Spesa spesa_antonio3;
	Spesa spesa_nunzia2;
	Spesa spesa_nunzia3;

	gestoreprodotti.aggiungiProdotto(farina, 4);
	gestoreprodotti.aggiungiProdotto(latte, 5);
	gestoreprodotti.aggiungiProdotto(detersivo, 15);
	gestoreprodotti.aggiungiProdotto(uova, 12);
	gestoreprodotti.aggiungiCarrello(car1);
	gestoreprodotti.aggiungiCarrello(car2);
	gestoreprodotti.aggiungiCarrello(car3);
	gestoreprodotti.aggiungiCarrello(car5);
	gestoreprodotti.aggiungiCarrello(car6);
	gestoreprodotti.aggiungiCarrello(car4);
	 
	
	gestoreprodotti.aggiungiCliente(antonio);
	gestoreprodotti.aggiungiCliente(nunzia);
	
	 gestoreprodotti.aggiungiAlCarrello(car1,antonio, latte, 3);
	 gestoreprodotti.aggiungiAlCarrello(car1, antonio, farina, 1);
	 gestoreprodotti.aggiungiAlCarrello(car2,nunzia, latte, 2);
	 gestoreprodotti.aggiungiAlCarrello(car2, nunzia, farina, 2);
	 gestoreprodotti.aggiungiAlCarrello(car3, antonio, detersivo, 10);
	 gestoreprodotti.aggiungiAlCarrello(car5, antonio, uova, 6);
	 gestoreprodotti.aggiungiAlCarrello(car4, nunzia, uova, 6);
	 gestoreprodotti.aggiungiAlCarrello(car6, nunzia, farina, 1);
	 
	 Sconto sconto1 = new Sconto(777, 50, data_Sconto1);
	 Sconto sconto2 = new Sconto(666, 50, data_Sconto2);

	 spesa_antonio = new Spesa(1, gestoreprodotti.procediAlPAgamento(antonio, car1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
	 spesa_antonio2 = new Spesa(2, gestoreprodotti.procediAlPAgamento(antonio, car3), data3, StatoSpesa.ORDINATA, antonio.getCarrello());
	 spesa_nunzia = new Spesa(3, gestoreprodotti.procediAlPAgamento(nunzia, car2), data2, StatoSpesa.ORDINATA, nunzia.getCarrello());
	 spesa_antonio3 = new Spesa(4, gestoreprodotti.procediAlPAgamento(antonio, car5), data4, StatoSpesa.ORDINATA, antonio.getCarrello());
	 spesa_nunzia2 = new Spesa(5, gestoreprodotti.procediAlPAgamento(nunzia, car4), data_nunzia, StatoSpesa.ORDINATA, nunzia.getCarrello());
	 spesa_nunzia3 = new Spesa(6, gestoreprodotti.procediAlPAgamento(nunzia, car6), data_nunzia2, StatoSpesa.ORDINATA, nunzia.getCarrello());
	 
	 gestoreprodotti.aggiungiSpesa(spesa_antonio);
	 gestoreprodotti.aggiungiSpesa(spesa_antonio3);
	 gestoreprodotti.aggiungiSpesa(spesa_antonio2);
	 gestoreprodotti.aggiungiSpesa(spesa_nunzia);
	 gestoreprodotti.aggiungiSpesa(spesa_nunzia2);
	 gestoreprodotti.aggiungiSpesa(spesa_nunzia3);

	 
	System.out.println("Lista clienti:\n"+gestoreprodotti.getListaClienti()); 
	 /*gestoreprodotti.aggiungiClienteAbituale(antonio);
	 gestoreprodotti.aggiungiClienteAbituale(nunzia);*/
	
	 gestoreprodotti.aggiungiSconto(sconto1);
	 gestoreprodotti.aggiungiSconto(sconto2);

      spesa_antonio3.setCosto_totale((gestoreprodotti.applicaSconto(sconto1, spesa_antonio3, antonio)));
      spesa_nunzia2.setCosto_totale(gestoreprodotti.applicaSconto(sconto2, spesa_nunzia2, nunzia));
    System.out.println(gestoreprodotti.generaReport(2));
	 System.out.println(gestoreprodotti.getListaClientiAbituali());
    
   
	}
}
