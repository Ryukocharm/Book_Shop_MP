package gestione.carrello;

public abstract class CarrelloOsservatore {
	
	protected CarrelloOsservatore(Carrello soggetto) {
		soggetto.aggiungiOsservatore(this);
	}
	
	protected void rimuoviOsservatore(Carrello soggetto) {
		soggetto.rimuoviOsservatore(this);
	}
	
	protected abstract void aggiorna(Carrello soggetto);

}
