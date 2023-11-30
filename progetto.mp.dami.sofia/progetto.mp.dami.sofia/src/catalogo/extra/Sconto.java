package catalogo.extra;

import catalogo.Cofanetto;

public class Sconto implements Promozione {
	
	private String valore;
	private double sconto;
	
	public Sconto(String nomePromozione, double sconto) {
		this.valore = nomePromozione;
		this.sconto = sconto;
	}

	@Override
	public String getNomePromozione() {
		return " + [ " + valore + " ]";
	}

	@Override
	public double getPrezzoPromozione(Cofanetto cofanetto) {
		return (sconto);
	}

}
