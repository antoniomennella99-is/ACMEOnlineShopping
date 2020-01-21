package is.control.ACMEOnlineShopping;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import is.entity.ACMEOnlineShopping.*;

public class GestioneProdottiTest {

	@Test
	public void test01QuantitaCarrello() {
		int i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();
		Carrello carrello1 = new Carrello();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
		gestioneprodotti.aggiungiCarrello(carrello1);
		gestioneprodotti.aggiungiProdotto(detersivo, 4);
		gestioneprodotti.aggiungiCliente(antonio);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
		
		 i = carrello1.getQuantita();
		 assertEquals(2, i);
	}
	
	@Test
	public void test02CostoCarrello() {
		double i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();
		Carrello carrello1 = new Carrello();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
		gestioneprodotti.aggiungiCarrello(carrello1);
		gestioneprodotti.aggiungiProdotto(detersivo, 4);
		gestioneprodotti.aggiungiCliente(antonio);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
		
		i = gestioneprodotti.calcoaPrezzo(carrello1);
		
		assertEquals(10, i, 0);
	}
	
	@Test
	public void test03CostoSpesa() {
		double i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();
		LocalDate data1 = LocalDate.of(2019, Month.JANUARY, 20);
		Carrello carrello1 = new Carrello();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Prodotto farina = new Prodotto(002, "Farina", "tipo00", 1);
		Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
		gestioneprodotti.aggiungiProdotto(farina, 20);
		gestioneprodotti.aggiungiCarrello(carrello1);
		gestioneprodotti.aggiungiProdotto(detersivo, 4);
		gestioneprodotti.aggiungiCliente(antonio);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, farina, 2);
		Spesa spesa1 = new Spesa(001, gestioneprodotti.procediAlPAgamento(antonio, carrello1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		gestioneprodotti.aggiungiSpesa(spesa1);
		
		i = spesa1.getCosto_totale();
		assertEquals(12, i, 0);
	}
	
	@Test
	public void test04QuantitaDiProdotti() {
		int i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Prodotto farina = new Prodotto(002, "Farina", "tipo00", 1);
		Prodotto smalto = new Prodotto(003, "Smalto", "coloreViola", 3);
		gestioneprodotti.aggiungiProdotto(detersivo, 20);
		gestioneprodotti.aggiungiProdotto(farina, 6);
		gestioneprodotti.aggiungiProdotto(smalto, 35);
		
	i =	gestioneprodotti.numeroProdottiTotali();
	
	assertEquals(61, i);
		
		
	}
	
	@Test public void test05CalcoloSpesaScontoConClienteNonAbituale() {
		double i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();
		LocalDate data_Sconto1 = LocalDate.of(2019, Month.FEBRUARY, 24);
		Sconto sconto1 = new Sconto(001, 50, data_Sconto1);
		LocalDate data1 = LocalDate.of(2019, Month.JANUARY, 20);
		Carrello carrello1 = new Carrello();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Prodotto farina = new Prodotto(002, "Farina", "tipo00", 1);
		Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
		gestioneprodotti.aggiungiProdotto(farina, 20);
		gestioneprodotti.aggiungiCarrello(carrello1);
		gestioneprodotti.aggiungiProdotto(detersivo, 4);
		gestioneprodotti.aggiungiCliente(antonio);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, farina, 2);
		Spesa spesa1 = new Spesa(001, gestioneprodotti.procediAlPAgamento(antonio, carrello1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		gestioneprodotti.aggiungiSpesa(spesa1);
		gestioneprodotti.aggiungiSconto(sconto1);
		
		spesa1.setCosto_totale(gestioneprodotti.applicaSconto(sconto1, spesa1, antonio));
		
	i = spesa1.getCosto_totale();	
	
	assertEquals(12, i, 0);	
	}
	
	@Test 
		public void test06CalcoloSpesaScontoConClienteAbituale() {
		double i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();
		LocalDate data_Sconto1 = LocalDate.of(2019, Month.FEBRUARY, 24);
		Sconto sconto1 = new Sconto(001, 50, data_Sconto1);
		LocalDate data1 = LocalDate.of(2019, Month.JANUARY, 20);
		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		Carrello carrello3 = new Carrello();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Prodotto farina = new Prodotto(002, "Farina", "tipo00", 1);
		Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
		gestioneprodotti.aggiungiProdotto(farina, 20);
		gestioneprodotti.aggiungiCarrello(carrello1);
		gestioneprodotti.aggiungiCarrello(carrello2);
		gestioneprodotti.aggiungiCarrello(carrello3);
		gestioneprodotti.aggiungiProdotto(detersivo, 16);
		gestioneprodotti.aggiungiCliente(antonio);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, farina, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello2, antonio, farina, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello3, antonio, farina, 2);
		Spesa spesa1 = new Spesa(001, gestioneprodotti.procediAlPAgamento(antonio, carrello1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		Spesa spesa2 = new Spesa(002, gestioneprodotti.procediAlPAgamento(antonio, carrello2), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		Spesa spesa3 = new Spesa(003, gestioneprodotti.procediAlPAgamento(antonio, carrello3), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		gestioneprodotti.aggiungiSpesa(spesa1);
		gestioneprodotti.aggiungiSpesa(spesa2);
		gestioneprodotti.aggiungiSpesa(spesa3);
		gestioneprodotti.aggiungiSconto(sconto1);
		
		spesa1.setCosto_totale(gestioneprodotti.applicaSconto(sconto1, spesa1, antonio));
		
	i = spesa1.getCosto_totale();	
	
	assertEquals(6, i, 0);	
	}
	
	@Test 
	public void test07CalcoloSpesaScontoScaduto() {
	double i = 0;
	GestioneProdotti gestioneprodotti = new GestioneProdotti();
	LocalDate data_Sconto1 = LocalDate.of(2019, Month.JANUARY, 19);
	Sconto sconto1 = new Sconto(001, 50, data_Sconto1);
	LocalDate data1 = LocalDate.of(2019, Month.JANUARY, 20);
	Carrello carrello1 = new Carrello();
	Carrello carrello2 = new Carrello();
	Carrello carrello3 = new Carrello();
	Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
	Prodotto farina = new Prodotto(002, "Farina", "tipo00", 1);
	Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
	gestioneprodotti.aggiungiProdotto(farina, 20);
	gestioneprodotti.aggiungiCarrello(carrello1);
	gestioneprodotti.aggiungiCarrello(carrello2);
	gestioneprodotti.aggiungiCarrello(carrello3);
	gestioneprodotti.aggiungiProdotto(detersivo, 16);
	gestioneprodotti.aggiungiCliente(antonio);
	gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
	gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, farina, 2);
	gestioneprodotti.aggiungiAlCarrello(carrello2, antonio, farina, 2);
	gestioneprodotti.aggiungiAlCarrello(carrello3, antonio, farina, 2);
	Spesa spesa1 = new Spesa(001, gestioneprodotti.procediAlPAgamento(antonio, carrello1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
	Spesa spesa2 = new Spesa(002, gestioneprodotti.procediAlPAgamento(antonio, carrello2), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
	Spesa spesa3 = new Spesa(003, gestioneprodotti.procediAlPAgamento(antonio, carrello3), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
	gestioneprodotti.aggiungiSpesa(spesa1);
	gestioneprodotti.aggiungiSpesa(spesa2);
	gestioneprodotti.aggiungiSpesa(spesa3);
	gestioneprodotti.aggiungiSconto(sconto1);
	
	spesa1.setCosto_totale(gestioneprodotti.applicaSconto(sconto1, spesa1, antonio));
	
	i = spesa1.getCosto_totale();	

	assertEquals(12, i, 0);	
}
	@Test 
	public void test08CalcoloSpesaScontoGiaUtilizzato() {
	double i = 0;
	GestioneProdotti gestioneprodotti = new GestioneProdotti();
	LocalDate data_Sconto1 = LocalDate.of(2019, Month.FEBRUARY, 24);
	Sconto sconto1 = new Sconto(001, 50, data_Sconto1);
	LocalDate data1 = LocalDate.of(2019, Month.JANUARY, 20);
	Carrello carrello1 = new Carrello();
	Carrello carrello2 = new Carrello();
	Carrello carrello3 = new Carrello();
	Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
	Prodotto farina = new Prodotto(002, "Farina", "tipo00", 1);
	Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
	gestioneprodotti.aggiungiProdotto(farina, 20);
	gestioneprodotti.aggiungiCarrello(carrello1);
	gestioneprodotti.aggiungiCarrello(carrello2);
	gestioneprodotti.aggiungiCarrello(carrello3);
	gestioneprodotti.aggiungiProdotto(detersivo, 16);
	gestioneprodotti.aggiungiCliente(antonio);
	gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
	gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, farina, 2);
	gestioneprodotti.aggiungiAlCarrello(carrello2, antonio, farina, 2);
	gestioneprodotti.aggiungiAlCarrello(carrello3, antonio, farina, 2);
	Spesa spesa1 = new Spesa(001, gestioneprodotti.procediAlPAgamento(antonio, carrello1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
	Spesa spesa2 = new Spesa(002, gestioneprodotti.procediAlPAgamento(antonio, carrello2), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
	Spesa spesa3 = new Spesa(003, gestioneprodotti.procediAlPAgamento(antonio, carrello3), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
	gestioneprodotti.aggiungiSpesa(spesa1);
	gestioneprodotti.aggiungiSpesa(spesa2);
	gestioneprodotti.aggiungiSpesa(spesa3);
	gestioneprodotti.aggiungiSconto(sconto1);
	
	spesa1.setCosto_totale(gestioneprodotti.applicaSconto(sconto1, spesa1, antonio));
	spesa2.setCosto_totale(gestioneprodotti.applicaSconto(sconto1, spesa2, antonio));
	
	i = spesa2.getCosto_totale();	

	assertEquals(2, i, 0);	
}
	
	@Test
	public void Test09SpeseComplessiveDiUnCliente() {
		int i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();
		
		LocalDate data1 = LocalDate.of(2019, Month.JANUARY, 20);
		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		Carrello carrello3 = new Carrello();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Prodotto farina = new Prodotto(002, "Farina", "tipo00", 1);
		Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
		gestioneprodotti.aggiungiProdotto(farina, 20);
		gestioneprodotti.aggiungiCarrello(carrello1);
		gestioneprodotti.aggiungiCarrello(carrello2);
		gestioneprodotti.aggiungiCarrello(carrello3);
		gestioneprodotti.aggiungiProdotto(detersivo, 16);
		gestioneprodotti.aggiungiCliente(antonio);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, farina, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello2, antonio, farina, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello3, antonio, farina, 2);
		Spesa spesa1 = new Spesa(001, gestioneprodotti.procediAlPAgamento(antonio, carrello1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		Spesa spesa2 = new Spesa(002, gestioneprodotti.procediAlPAgamento(antonio, carrello2), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		Spesa spesa3 = new Spesa(003, gestioneprodotti.procediAlPAgamento(antonio, carrello3), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		gestioneprodotti.aggiungiSpesa(spesa1);
		gestioneprodotti.aggiungiSpesa(spesa2);
		gestioneprodotti.aggiungiSpesa(spesa3);
		
		i = gestioneprodotti.conteggioSpese(antonio);	

		assertEquals(3, i);
		
	}
	
	@Test
	public void Test10DenaroComlessivoSpesoDaUnCliente() {
		double i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();	
		LocalDate data1 = LocalDate.of(2019, Month.JANUARY, 20);
		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		Carrello carrello3 = new Carrello();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Prodotto farina = new Prodotto(002, "Farina", "tipo00", 1);
		Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
		gestioneprodotti.aggiungiProdotto(farina, 20);
		gestioneprodotti.aggiungiCarrello(carrello1);
		gestioneprodotti.aggiungiCarrello(carrello2);
		gestioneprodotti.aggiungiCarrello(carrello3);
		gestioneprodotti.aggiungiProdotto(detersivo, 16);
		gestioneprodotti.aggiungiCliente(antonio);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, farina, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello2, antonio, farina, 2);
		gestioneprodotti.aggiungiAlCarrello(carrello3, antonio, farina, 2);
		Spesa spesa1 = new Spesa(001, gestioneprodotti.procediAlPAgamento(antonio, carrello1), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		Spesa spesa2 = new Spesa(002, gestioneprodotti.procediAlPAgamento(antonio, carrello2), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		Spesa spesa3 = new Spesa(003, gestioneprodotti.procediAlPAgamento(antonio, carrello3), data1, StatoSpesa.ORDINATA, antonio.getCarrello());
		gestioneprodotti.aggiungiSpesa(spesa1);
		gestioneprodotti.aggiungiSpesa(spesa2);
		gestioneprodotti.aggiungiSpesa(spesa3);
		
		i = gestioneprodotti.conteggioDenaro(antonio);
		
		assertEquals(16, i, 0);
	}
	
	@Test
	public void Test11AggiornamentoQuantitaProdotto() {
		int i = 0;
		GestioneProdotti gestioneprodotti = new GestioneProdotti();
		Carrello carrello1 = new Carrello();
		Prodotto detersivo = new Prodotto(001, "Detersivo", "Smacchiante", 5);
		Cliente antonio = new Cliente(carrello1, "Antonio", "password", "12345678", "1234 5678 9101");
		gestioneprodotti.aggiungiCarrello(carrello1);
		gestioneprodotti.aggiungiProdotto(detersivo, 4);
		gestioneprodotti.aggiungiCliente(antonio);
		gestioneprodotti.aggiungiAlCarrello(carrello1, antonio, detersivo, 2);
		
			i = gestioneprodotti.numeroProdotti(detersivo);
			
			assertEquals(2, i);
	}
}
