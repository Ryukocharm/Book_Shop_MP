package gestione.carrello;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import catalogo.Acquisto;
import catalogo.Cofanetto;
import catalogo.Edizione;
import catalogo.Pacchetto;
import catalogo.extra.Promozione;



public class ContoTest {
	
	private Conto contoTest;
	private Carrello carrello;
	private Acquisto edizione;
	private Acquisto edizione2;
	private Cofanetto cofanetto;
	private Pacchetto pacchetto;
	private Pacchetto pacchetto2;
	private Collection<Acquisto> contenuto1;
	private Collection<Acquisto> contenuto2;
	
	@Before
	public void initialize() {
		contenuto1 = new ArrayList<>();
		contenuto2 = new ArrayList<>();
		Collection<Acquisto> acquisti = new ArrayList<>();
		Collection<Promozione> promozioni = new ArrayList<>();

		carrello = new Carrello(7, acquisti);
		edizione = new Edizione("Il Piccolo Principe", "Antoine de Saint Exupery", 16.0);
		edizione2 = new Edizione("Il Signore degli Anelli", "JRR Tolkien", 30.5);
		cofanetto = new Cofanetto("One Piece Box", 100.0, promozioni);
		pacchetto = new Pacchetto("Fantasy", contenuto1);
		pacchetto2 = new Pacchetto("Grandi Titoli", contenuto2);
		contoTest = new Conto(carrello);

	}
	
	@Test
	public void testAcquistoSemplice() {
		carrello.aggiungiAcquistoAlCarrello(edizione);
		String attesa = String.format("Prezzo Totale: 16.0 euro.");
		assertEquals(attesa, contoTest.getStatusConto());
	}
	
	@Test
	public void testAcquistoSemplice2() {
		carrello.aggiungiAcquistoAlCarrello(edizione);
		carrello.aggiungiAcquistoAlCarrello(edizione2);
		carrello.aggiungiAcquistoAlCarrello(cofanetto);
		String attesa = String.format("Prezzo Totale: 146.5 euro.");
		assertEquals(attesa, contoTest.getStatusConto());
	}
	
	@Test
	public void testAcquistoConRimozione() {
		carrello.aggiungiAcquistoAlCarrello(edizione2);
		carrello.aggiungiAcquistoAlCarrello(edizione);
		carrello.rimuoviAcquistoDalCarrello(edizione2);
		String attesa = String.format("Prezzo Totale: 16.0 euro.");
		assertEquals(attesa, contoTest.getStatusConto());
	}
	
	@Test
	public void testAcquistoComposto() {
		pacchetto2.aggiungiAcquisto(edizione);
		pacchetto2.aggiungiAcquisto(cofanetto);
		pacchetto.aggiungiAcquisto(pacchetto2);
		carrello.aggiungiAcquistoAlCarrello(pacchetto);
		String attesa = String.format("Prezzo Totale: 116.0 euro.");
		assertEquals(attesa, contoTest.getStatusConto());
	}
	
	@Test
	public void testAggiornaCarrelloSenzaOrdini() {
		contoTest.aggiorna(carrello);
		assertEquals("Prezzo Totale: 0.0 euro.", contoTest.getStatusConto());
	}
	
	@Test
	public void testContoInesistente() {
		contoTest.rimuoviOsservatore(carrello);
		assertNull(contoTest.getStatusConto());
	}
	
}
