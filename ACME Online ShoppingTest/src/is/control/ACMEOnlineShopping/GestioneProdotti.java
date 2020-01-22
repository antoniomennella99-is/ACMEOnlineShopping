package is.control.ACMEOnlineShopping;
import java.util.*;

import is.entity.ACMEOnlineShopping.*;

public class GestioneProdotti {
	
		public ArrayList<Spesa> listaSpesa;
		public ArrayList<Prodotto> listaprodotti;
		public ArrayList<Cliente> listaclientipagato; //Lista clienti che hanno almeno fatto una spesa
		public ArrayList<Carrello> listacarrelli;	//lista carrelli usati
		public ArrayList<Carrello> listacarrellitutti;	//lista completa di tutti i carrelli
		public ArrayList<Sconto> listasconti;
		public ArrayList<Sconto> listascontiusati;
		public ArrayList<Cliente> listaclienti;
		public ArrayList<ClienteAbituale> listaclientiabituali;
		
		public GestioneProdotti() {
			listaprodotti = new ArrayList<Prodotto>();
			listaclientipagato = new ArrayList<Cliente>();
			 listacarrelli = new ArrayList<Carrello>();
			 listacarrellitutti = new ArrayList<Carrello>();
			 listasconti = new ArrayList<Sconto>();
			 listascontiusati = new ArrayList<Sconto>();
			 listaclienti = new ArrayList<Cliente>();
			listaclientiabituali = new ArrayList<ClienteAbituale>();
			listaSpesa = new ArrayList<Spesa>();	
		}
		
		public void aggiungiCliente(Cliente C) {
			listaclienti.add(C);
		}
		
		
		public ArrayList<Cliente> getListaClienti(){
			return listaclienti;
		}
		
		
		public ArrayList<ClienteAbituale> getListaClientiAbituali(){
			return listaclientiabituali;
		}
		
		public void aggiungiSpesa(Spesa S) {
			listaSpesa.add(S);
		}
		
		public ArrayList<Spesa> listaSpese() {
			return listaSpesa;
		}
		
		public void aggiungiSconto(Sconto S) {
			listasconti.add(S);
		}
		
		public ArrayList<Sconto> listaSconti(){
			return listasconti;
		}
		
		public ArrayList<Sconto> listaScontiUsati(){
			return listascontiusati;
		}
		
		public void aggiungiProdotto(Prodotto P, int quantità) {
			for (int i = 0; i < quantità; i++) {
				listaprodotti.add(P);
			}			
		}
		
		public void aggiungiCarrello(Carrello C) {
			listacarrellitutti.add(C);			
		}
		
		
		public ArrayList<Carrello> listaCarrelli() {
			return listacarrelli;
		}
		
		
		public ArrayList<Cliente> clientiPagato(){
			return listaclientipagato;
		}
		
		
		
		
		
		public void rimuoviProdotto(Prodotto P , int quantita) {	//rimuove una certa quantità di prodotto dal catalogo
			if(P.getQ_disponibileProd() >= quantita) {
				System.out.println("\nImpossibile rimuovere" + P.toString() +" terminato.");
			} else {
				for (int i = 0; i < quantita; i++) {				
				listaprodotti.remove(P);
			}
			}		
		}
		
		public ArrayList<Prodotto> getListaProdotti(){
			return listaprodotti;
		}
		
		public int numeroProdotti(Prodotto P) {
			int i = 0;
			if(listaprodotti.contains(P)) {
			for (Prodotto prod : listaprodotti) {
				if (prod.getCodiceProd() == P.getCodiceProd()) {
					i++;
				}
			}
			} else {
				System.out.println(P.toString() + " non in catalogo.");
			}
			return i;
		}
		
		public int numeroProdottiTotali() {	
			int i;
			for ( i = 0; i < listaprodotti.size(); i++) {
			}
			return i;
		}
		
		public void aggiungiAlCarrello(Carrello car, Cliente C, Prodotto P, int quantita) {
			if(getListaClienti().contains(C)) {					
				if(!listaprodotti.contains(P)) {
					System.out.println("\n" + P.toString() + " non trovato.");	
				}else {					
					for (int i = 0; i < quantita; i++) {
						car.getListaprodotti().add(P);	
				} 
					rimuoviProdotto(P, quantita);
					car.setQuantita(car.getQuantita() + quantita);
				}
				
			} else {
				System.out.println("\n" + C.toString() + " non trovato.");
			}
	}
	
	public void mostraCarrello(Cliente C , Carrello car) { //mostra tutti u prodotti presenti in un carrello 
		ArrayList<Prodotto> listacarrello = new ArrayList<Prodotto>();
		if(getListaClienti().contains(C)) {
			for (Prodotto prodotto : car.getListaprodotti()) {
				listacarrello.add(prodotto);
			}
			System.out.println("Carrello di: " + C.getNomeCli() +".\n");
			for (Prodotto prodotto : listacarrello) {
				System.out.println(prodotto.toString());
			}
		}else {
			System.out.println("\n" + C.toString() + " non trovato.");
	}
}
	
	public void rimuoviDalCarrello(Carrello car, Cliente C ,  Prodotto P, int quantita) {
		if(getListaClienti().contains(C)) {
			if(car.getQuantita() != 0) {
				for (int i = 0; i < quantita; i++) {
					car.getListaprodotti().remove(P);
				}
				 aggiungiProdotto(P,quantita); 
				 car.setQuantita(car.getQuantita()- quantita);
			}else {
				System.out.println("\nCarrello vuoto!");
			}				
		}else {
			System.out.println("\n" + C.toString() + " non trovato.");
		}
	}
	
	public double procediAlPAgamento(Cliente C, Carrello car) {
		double a = 0;
		if(getListaClienti().contains(C)) {
			if(car.getQuantita() != 0) {
				for (Prodotto prodotto :  car.getListaprodotti()) {
					a = a + prodotto.getPrezzoProd();
				}
				listaclientipagato.add(C);
				listacarrelli.add(car);
			}else {
				System.out.println("\nCarrello vuoto!");
			}
			
		}else {
			System.out.println("\n" + C.toString() + " non trovato.");
		}
		
		return a;
	}
	
	
	public int conteggioSpese(Cliente C) {
		int i =0;
		for (Cliente cliente : listaclientipagato) {
			if(cliente.equals(C)) {
				i++;
			}
		}
		return i;
	}
	
	public double calcoaPrezzo(Carrello car) {
		double i = 0;
		ArrayList<Prodotto> listaP = new ArrayList<Prodotto>();
		for (Prodotto prod : car.getListaprodotti()) {
			listaP.add(prod);
		}for (Prodotto prodotto : listaP) {
			i = i + prodotto.getPrezzoProd();
		}
		
		return i;
	}
	
	public ArrayList<Carrello> carrelli(Cliente C){
		ArrayList<Carrello> listaC = new ArrayList<Carrello>();
			for (Carrello carrello : listacarrellitutti) {
				if(carrello.getCliente().equals(C)) {
					listaC.add(carrello);
				}
			}
		return listaC;
	}
	
	public double conteggioDenaro(Cliente C) {
		ArrayList<Spesa> listaS = new ArrayList<Spesa>();
		double i = 0;
		
		for (Spesa spesa : listaSpesa) {
			if (spesa.getListaAcquisti().equals(C.getCarrello())) {
				listaS.add(spesa);
			}
		}for (Spesa spesa : listaS) {
			i = i + spesa.getCosto_totale();
		}
		
		return i;
	}
	

	public double applicaSconto(Sconto S, Spesa Sp, Cliente C) {
		double i = 0;	
		if(listasconti.contains(S)) {
			if(aggiungiClienteAbituale(C)) {
				if (listascontiusati.contains(S)) {
					System.out.println(S.toString() + " già utilizzato.");
					i = Sp.getCosto_totale();
				} else if(S.getData_Scadenza().isAfter(Sp.getData())) {
					i = (Sp.getCosto_totale() * S.getPercentuale_di_Sconto())/100;
					listascontiusati.add(S);
				} else {
					System.out.println(S.toString() + " scaduto.");
					i = Sp.getCosto_totale();
				}
			} else {
				System.out.println("\n" + C.getNomeCli() +" non è nella lista dei clienti abituali!.");
				i = Sp.getCosto_totale();
			}
		} else {
			System.out.println(S.toString() + " non è nella lista degli sconti.");
			i = Sp.getCosto_totale();
		}		
		
		return i;
	}


	public boolean aggiungiClienteAbituale(Cliente C) {
		boolean flag = false;
		if(getListaClienti().contains(C)) {
			if (conteggioSpese(C) >= 3) {
				 C = new ClienteAbituale(C.getCarrello(), C.getNomeCli(), C.getPasswordC(), C.getNumTel(), C.getCartaCredito(), 3);
				getListaClientiAbituali().add((ClienteAbituale)C);
				flag = true;
			} 	
		} else {
			System.out.println(C.toString() + " non trovato.");
			flag = false;
		}
		return flag;
	}
	
	public String generaReport(int k) {
		String s = new String("");
																	//LinkedHashSet per una versione oridinata
		ArrayList<Cliente> listaclienti2 = new ArrayList<Cliente>(new HashSet<Cliente>(listaclientipagato));
		for (Cliente cliente :listaclienti2 ) {
			if(conteggioSpese(cliente) >= k) {
				 s += "\n" + "Cliente: " + cliente.getNomeCli() + " Spese: "+ conteggioSpese(cliente) + " Denaro: " + conteggioDenaro(cliente)+ "€";

			} else {
				s+= "\n "+ cliente.toString() +" non ha fatto almeno "+ k +" spese.";
			}
		}
		return s;
	}
		
	
}
