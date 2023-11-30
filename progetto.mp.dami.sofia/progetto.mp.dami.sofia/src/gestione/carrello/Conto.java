package gestione.carrello;

public class Conto extends CarrelloOsservatore {
	
	private String statusConto;

	public Conto(Carrello carrello) {
		super(carrello);
	}
	
	protected String getStatusConto() {
		return statusConto;
	}

	protected void setStatusConto(String statusConto) {
		this.statusConto = statusConto;
	}

	@Override
	public void aggiorna(Carrello carrello) {
		setStatusConto(String.format
				("Prezzo Totale: " + carrello.getprezzoTotale() + " euro."));
	}
}
