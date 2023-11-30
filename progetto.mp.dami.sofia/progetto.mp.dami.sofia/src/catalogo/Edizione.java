package catalogo;

public class Edizione implements Acquisto {
	
	private String titolo;
	private String autore;
	private double prezzo;
	
	public Edizione(String titolo, String autore, double prezzo) {
		this.autore = autore;
		this.titolo = titolo;
		this.prezzo = prezzo;
	}

	@Override
	public String getNome() {
		return titolo + ", " + autore;
	}

	@Override
	public double getPrezzo() {
		return prezzo;
	}

}
