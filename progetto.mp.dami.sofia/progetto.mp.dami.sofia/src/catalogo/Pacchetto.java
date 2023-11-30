package catalogo;

import java.util.Collection;
import java.util.Iterator;

public class Pacchetto implements Acquisto {
	
	private String nomePacchetto;
	private Collection<Acquisto> contenuto;
	
	public Pacchetto(String nomePacchetto, Collection<Acquisto> contenuto) {
		this.nomePacchetto = nomePacchetto;
		this.contenuto = contenuto;
	}
	
	public void aggiungiAcquisto(Acquisto acquisto) {
		contenuto.add(acquisto);
	}
	
	public void rimuoviAcquisto(Acquisto acquisto) {
		contenuto.remove(acquisto);
	}
	
	public String getNomePacchetto() {
		return nomePacchetto.toUpperCase();
	}

	public double getPrezzoPacchetto() {
		return contenuto.stream()
				.mapToDouble(
				prodotto -> prodotto.getPrezzo())
				.sum();
	}

	public Iterator<Acquisto> getContenuto() {
		return contenuto.iterator();
	}


	@Override
	public String getNome() {
		return getNomePacchetto();
	}

	@Override
	public double getPrezzo() {
		return getPrezzoPacchetto();
	}
	
}
