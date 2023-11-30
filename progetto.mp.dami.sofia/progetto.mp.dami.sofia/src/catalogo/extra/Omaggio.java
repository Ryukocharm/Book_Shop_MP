package catalogo.extra;

import catalogo.Cofanetto;

public class Omaggio implements Promozione {
	
	private String omaggio;
	private double prezzo;
	
	public Omaggio(String omaggio, double prezzo) {
		this.omaggio = omaggio;
		this.prezzo = prezzo;
	}

	@Override
	public String getNomePromozione() {
		return " + [ " + omaggio + " ]";
	}

	@Override
	public double getPrezzoPromozione(Cofanetto cofanetto) {
		return prezzo;
	}

}
