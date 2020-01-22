package is.main.ACMEOnlineShopping;
import is.control.ACMEOnlineShopping.*;
import is.entity.ACMEOnlineShopping.*;

import java.time.LocalDate;
import java.time.Month;


public class Main {
	
	
	public static void main(String[] args) {
	
	
	GestioneProdotti gestoreprodotti = new GestioneProdotti();
	
	
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
	LocalDate data5 = LocalDate.of(2019, Month.JANUARY, 20);
	LocalDate data6 = LocalDate.of(2019, Month.JANUARY, 23);
	
	Cliente antonio = new Cliente (car1, "Antonio", "Mennella", "1234466", "2414 5664 5433");
	Cliente giovanni = new Cliente (car2, "Giovanni", "Battista", "45674322", "152255 5494 48");

	
	Prodotto crema = new Prodotto(123,"Crema Viso", "Idratante", 3);
	Prodotto aspirabriciole = new Prodotto(321, "Aspirabriciole", "Elettrico", 30);
	Prodotto detersivo = new Prodotto(456, "Detersivo", "Smacchiante", 5);
	Prodotto smalto = new Prodotto(777, "Smalto", "colore viola", 3);
	
	Spesa spesa_antonio;
	Spesa spesa_giovanni;
	Spesa spesa_antonio2;
	Spesa spesa_antonio3;
	Spesa spesa_giovanni2;
	Spesa spesa_giovanni3;

	gestoreprodotti.aggiungiProdotto(crema, 10);
	gestoreprodotti.aggiungiProdotto(aspirabriciole, 30);
	gestoreprodotti.aggiungiProdotto(detersivo, 15);
	gestoreprodotti.aggiungiProdotto(smalto, 12);
	gestoreprodotti.aggiungiCarrello(car1);
	gestoreprodotti.aggiungiCarrello(car2);
	gestoreprodotti.aggiungiCarrello(car3);
	gestoreprodotti.aggiungiCarrello(car5);
	gestoreprodotti.aggiungiCarrello(car6);
	gestoreprodotti.aggiungiCarrello(car4);
	 
	
	gestoreprodotti.aggiungiCliente(antonio);
	gestoreprodotti.aggiungiCliente(giovanni);
	
	 gestoreprodotti.aggiungiAlCarrello(car1,antonio, aspirabriciole, 3);
	 gestoreprodotti.aggiungiAlCarrello(car1, antonio, crema, 1);
	 gestoreprodotti.aggiungiAlCarrello(car2,giovanni, aspirabriciole, 2);
	 gestoreprodotti.aggiungiAlCarrello(car2, giovanni, crema, 2);
	 gestoreprodotti.aggiungiAlCarrello(car3, antonio, detersivo, 10);
	 gestoreprodotti.aggiungiAlCarrello(car5, antonio, smalto, 6);
	 gestoreprodotti.aggiungiAlCarrello(car4, giovanni, smalto, 6);
	 gestoreprodotti.aggiungiAlCarrello(car6, giovanni, crema, 1);
	 
	 Sconto sconto1 = new Sconto(777, 50, data_Sconto1);
	 Sconto sconto2 = new Sconto(666, 50, data_Sconto2);

	 spesa_antonio = new Spesa(1, gestoreprodotti.procediAlPAgamento(antonio, car1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
	 spesa_antonio2 = new Spesa(2, gestoreprodotti.procediAlPAgamento(antonio, car3), data3, StatoSpesa.ORDINATA, antonio.getCarrello());
	 spesa_giovanni = new Spesa(3, gestoreprodotti.procediAlPAgamento(giovanni, car2), data2, StatoSpesa.ORDINATA, giovanni.getCarrello());
	 spesa_antonio3 = new Spesa(4, gestoreprodotti.procediAlPAgamento(antonio, car5), data4, StatoSpesa.ORDINATA, antonio.getCarrello());
	 spesa_giovanni2 = new Spesa(5, gestoreprodotti.procediAlPAgamento(giovanni, car4), data5, StatoSpesa.ORDINATA, giovanni.getCarrello());
	 spesa_giovanni3 = new Spesa(6, gestoreprodotti.procediAlPAgamento(giovanni, car6), data6, StatoSpesa.ORDINATA, giovanni.getCarrello());
	 
	 gestoreprodotti.aggiungiSpesa(spesa_antonio);
	 gestoreprodotti.aggiungiSpesa(spesa_antonio3);
	 gestoreprodotti.aggiungiSpesa(spesa_antonio2);
	 gestoreprodotti.aggiungiSpesa(spesa_giovanni);
	 gestoreprodotti.aggiungiSpesa(spesa_giovanni2);
	 gestoreprodotti.aggiungiSpesa(spesa_giovanni3);

	 
	System.out.println("Lista clienti:\n"+gestoreprodotti.getListaClienti()); 
	
	 gestoreprodotti.aggiungiSconto(sconto1);
	 gestoreprodotti.aggiungiSconto(sconto2);

      spesa_antonio3.setCosto_totale((gestoreprodotti.applicaSconto(sconto1, spesa_antonio3, antonio)));
      spesa_giovanni2.setCosto_totale(gestoreprodotti.applicaSconto(sconto2, spesa_giovanni2, giovanni));
      
    System.out.println(gestoreprodotti.generaReport(3));
	 
    
   
	}
}
