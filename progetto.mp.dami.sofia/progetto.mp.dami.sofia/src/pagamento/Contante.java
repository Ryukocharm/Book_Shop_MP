package pagamento;

import gestione.carrello.Carrello;

public class Contante extends Pagamento {

	public Contante(double saldo) {
		super(saldo);
	}

	@Override
	public void conferma(Carrello carrello) {
		stampaRicevuta(carrello);
		setRicevuta(getRicevuta() + String.format("Pagamento in contanti. Totale: "
		+ getCredito() + " euro\n"
		+ "Resto: " + (getCredito() - carrello.getprezzoTotale()) + " euro."));		
	}

}
