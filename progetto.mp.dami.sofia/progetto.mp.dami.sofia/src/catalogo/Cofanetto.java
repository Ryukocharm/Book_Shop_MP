package catalogo;

import java.util.Collection;
import java.util.Iterator;

import catalogo.extra.Promozione;

public class Cofanetto implements Acquisto {
	
	private String nomeCofanetto;
	private double prezzoCofanetto;
	private Collection<Promozione> promozioni;
	
	public Cofanetto(String nomeCofanetto, double prezzoCofanetto, Collection<Promozione> promozioni) {
		this.nomeCofanetto = nomeCofanetto;
		this.prezzoCofanetto = prezzoCofanetto;
		this.promozioni = promozioni;
	}
	
	protected String getnomeCofanetto() {
		return nomeCofanetto;
	}
	
	protected void setnomeCofanetto(String nome) {
		this.nomeCofanetto = nome;
	}

	protected double getprezzoCofanetto() {
		return prezzoCofanetto;
	}
	
	protected void setprezzoCofanetto(double prezzoCofanetto) {
		this.prezzoCofanetto = prezzoCofanetto;
	}

	protected Iterator<Promozione> getPromozioni() {
		return promozioni.iterator();
	}
	
	protected void aggiungiPromozione(Promozione promozione) {
		promozioni.add(promozione);
	}
	
	protected void rimuoviPromozione(Promozione promozione) {
		promozioni.remove(promozione);
	}

	@Override
	public String getNome() {
		setnomeCofanetto(getnomeCofanetto());
		Iterator<Promozione> iter = getPromozioni();
		while (iter.hasNext()) {
			setnomeCofanetto(getnomeCofanetto() + iter.next()
			.getNomePromozione());
		}
		return getnomeCofanetto();
	}

	@Override
	public double getPrezzo() {
		double prezzo = 0;
		prezzo = promozioni.stream()
				 .mapToDouble(promo ->
				 promo.getPrezzoPromozione(this))
				 .sum();
		setprezzoCofanetto(getprezzoCofanetto() - prezzo);
		return getprezzoCofanetto();
	}

}