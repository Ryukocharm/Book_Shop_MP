package gestione.carrello;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import catalogo.Acquisto;
import catalogo.Cofanetto;
import catalogo.Edizione;
import catalogo.extra.Promozione;


public class CarrelloTest {
	
	private Carrello carrelloTest;
	private Acquisto edizione;
	private Acquisto edizione2;
	private Cofanetto cofanetto;
	private Collection<Acquisto> listaOrdini;
	
	@Before
	public void initialize() {
		listaOrdini = new ArrayList<>();
		Collection<Promozione> promozioni = new ArrayList<>();

		carrelloTest = new Carrello(5, listaOrdini);
		edizione = new Edizione("Il Piccolo Principe", "Antoine de Saint Exupery", 16.00);
		edizione2 = new Edizione("Il Signore degli Anelli", "JRR Tolkien", 30.5);
		cofanetto = new Cofanetto("One Piece Box", 100.0, promozioni);
	}
	

	@Test
	public void testCarrelloCostruttore() {
		assertSame(5, carrelloTest.getnumeroCarrello());
		assertNotNull(carrelloTest.getAcquisti());
	}
	
	@Test
	public void testCarrelloSenzaAcquisti() {
		assertFalse(carrelloTest.getAcquisti().hasNext());
		assertEquals(0, carrelloTest.getprezzoTotale(), 0);
	}
	
	@Test
	public void testListaOrdiniAggiungi() {
		listaOrdini.add(edizione);
		listaOrdini.add(cofanetto);
		listaOrdini.remove(cofanetto);
		assertTrue(listaOrdini.contains(edizione));
		assertFalse(listaOrdini.contains(cofanetto));
	}
	
	@Test
	public void testAggiungiAcquistiAlCarrello() {
		carrelloTest.aggiungiAcquistoAlCarrello(edizione);
		carrelloTest.aggiungiAcquistoAlCarrello(edizione2);
		carrelloTest.aggiungiAcquistoAlCarrello(cofanetto);
		assertTrue(listaOrdini.size() == 3);
	}
	
	@Test
	public void testPrezzoTotaleAggiungendoDegliAcquisti() {		
		carrelloTest.aggiungiAcquistoAlCarrello(edizione);
		carrelloTest.aggiungiAcquistoAlCarrello(cofanetto);
		assertEquals(116.0, carrelloTest.getprezzoTotale(), 0);
	}

	@Test
	public void testPrezzoTotaleRimuovendoUnAcquisto() {
		carrelloTest.aggiungiAcquistoAlCarrello(edizione);
		carrelloTest.aggiungiAcquistoAlCarrello(cofanetto);
		carrelloTest.rimuoviAcquistoDalCarrello(cofanetto);
		assertEquals(16.00, carrelloTest.getprezzoTotale(), 0);
	}
	
	@Test
	public void testPrezzoTotaleRimuovendoTuttiGliAcquisti() {
		carrelloTest.aggiungiAcquistoAlCarrello(edizione);
		carrelloTest.aggiungiAcquistoAlCarrello(edizione2);
		carrelloTest.rimuoviAcquistoDalCarrello(edizione);
		carrelloTest.rimuoviAcquistoDalCarrello(edizione2);
		assertEquals(0, carrelloTest.getprezzoTotale(), 0);
	}

}
