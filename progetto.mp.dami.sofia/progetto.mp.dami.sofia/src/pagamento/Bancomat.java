package pagamento;

import gestione.carrello.Carrello;

public class Bancomat extends Pagamento {
	
	public Bancomat(double importo) {
		super(importo);
	}

	@Override
	public void conferma(Carrello carrello) {
		stampaRicevuta(carrello);
		setRicevuta(getRicevuta() + String.format("Pagamento con bancomat. Totale: "
				+ carrello.getprezzoTotale()));	
	}

}
