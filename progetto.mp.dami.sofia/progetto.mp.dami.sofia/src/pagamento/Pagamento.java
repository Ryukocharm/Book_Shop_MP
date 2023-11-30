package pagamento;

import java.util.Iterator;

import catalogo.Acquisto;
import gestione.carrello.Carrello;

public abstract class Pagamento {
	
	private double importo;
	private String ricevuta;
	
	public Pagamento(double saldo) {
		this.importo = saldo;
	}
	
	protected double getCredito() {
		return importo;
	}
	
	protected String getRicevuta() {
		return ricevuta;
	}
	
	protected void setRicevuta(String ricevuta) {
		this.ricevuta = ricevuta;
	}
	
	protected void stampaRicevuta(Carrello carrello) {
		setRicevuta(String.format("---Ricevuta---\nCarrello [" + carrello.getnumeroCarrello() + "]\n"));
		Iterator<Acquisto> iter = carrello.getAcquisti();
		while (iter.hasNext()) {
			Acquisto ordine = iter.next();
			setRicevuta(getRicevuta() + String.format(ordine.getNome() + ": " + ordine.getPrezzo() + " euro\n"));
		}
		setRicevuta(getRicevuta() + String.format("Totale: " + carrello.getprezzoTotale() + "\n"));
	}
		
	
	protected final void pagamento(Carrello carrello) throws CreditoInsufficienteEccezione {
		if(getCredito() < carrello.getprezzoTotale()) {
			throw new CreditoInsufficienteEccezione(
					String.format("Credito Insufficiente!"));
		} else if (carrello.getprezzoTotale() > 0) {
			conferma(carrello);
		}
		
	}
	
	protected abstract void conferma(Carrello carrello);
	
}
