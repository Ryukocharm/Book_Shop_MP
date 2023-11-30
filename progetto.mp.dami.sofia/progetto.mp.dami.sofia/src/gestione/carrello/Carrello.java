package gestione.carrello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import catalogo.Acquisto;

public class Carrello {
	private int numeroCarrello;
	private double prezzoTotale;
	private Collection<Acquisto> listaAcquisti;
	private Collection<CarrelloOsservatore> osservatori = new ArrayList<>();
	
	public Carrello(int numeroCarrello, Collection<Acquisto> listaOrdini) {
		this.numeroCarrello = numeroCarrello;
		this.listaAcquisti = listaOrdini;
	}

	public int getnumeroCarrello() {
		return numeroCarrello;
	}

	public double getprezzoTotale() {
		return prezzoTotale;
	}

	public Iterator<Acquisto> getAcquisti() {
		return listaAcquisti.iterator();
	}
	
	public void aggiungiAcquistoAlCarrello(Acquisto acquisto) {
		listaAcquisti.add(acquisto);
		prezzoTotale = prezzoTotale + acquisto.getPrezzo();
		notificaOsservatore();		
	}
	
	public void rimuoviAcquistoDalCarrello(Acquisto acquisto) {
		listaAcquisti.remove(acquisto);
		prezzoTotale = prezzoTotale - acquisto.getPrezzo();
		notificaOsservatore();		
	}

	protected void aggiungiOsservatore(CarrelloOsservatore osservatore) {
		osservatori.add(osservatore);		
	}

	protected void rimuoviOsservatore(CarrelloOsservatore osservatore) {
		osservatori.remove(osservatore);
	}
	
	protected void notificaOsservatore() {
		osservatori.forEach(osservatore -> osservatore.aggiorna(this));
	}

	
}
