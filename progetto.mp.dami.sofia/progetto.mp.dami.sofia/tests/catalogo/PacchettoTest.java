package catalogo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import catalogo.extra.Promozione;
import catalogo.extra.Variant;
import gestione.carrello.Carrello;

public class PacchettoTest {
	
	private Pacchetto pacchettoTest;
	private Pacchetto pacchettoTest2;
	private Acquisto edizione;
	private Acquisto edizione2;
	private Acquisto cofanetto;
	private Collection<Acquisto> contenuto1;
	private Collection<Acquisto> contenuto2;
	private Carrello carrello;
	private Collection<Acquisto> listaOrdini;
	
	@Before
	public void initialize() {
		contenuto1 = new ArrayList<>();
		contenuto2 = new ArrayList<>();
		listaOrdini = new ArrayList<>();
		Collection<Promozione> promozioni = new ArrayList<>();

		carrello = new Carrello(3, listaOrdini);
		pacchettoTest = new Pacchetto("Fantasy", contenuto1);
		pacchettoTest2 = new Pacchetto("Grandi Titoli", contenuto2);
		edizione = new Edizione("Il Piccolo Principe", "Antoine de Saint Exupery", 16.00);
		edizione2 = new Variant(edizione, "variant cover");
		cofanetto = new Cofanetto("Harry Potter Saga", 170.0, promozioni);
		
	}
	
	@Test
	public void testArgomentiCostruttore() {
		pacchettoTest.aggiungiAcquisto(edizione);
		pacchettoTest.aggiungiAcquisto(edizione2);
		pacchettoTest.aggiungiAcquisto(cofanetto);
		carrello.aggiungiAcquistoAlCarrello(pacchettoTest);
		assertNotNull(pacchettoTest.getContenuto());
	}
	
	@Test
	public void testPacchettoVuoto() {
		assertEquals(0, pacchettoTest.getPrezzo(), 0);
	}
	
	@Test
	public void testPrezzoPacchetto() {
		pacchettoTest2.aggiungiAcquisto(edizione);
		pacchettoTest2.aggiungiAcquisto(cofanetto);
		pacchettoTest.aggiungiAcquisto(pacchettoTest2);
		assertEquals(186.0, pacchettoTest.getPrezzo(), 0);
	}
	
	@Test
	public void testPrezzoPacchettoRimuovendoUnOrdine() {
		pacchettoTest2.aggiungiAcquisto(edizione);
		pacchettoTest2.aggiungiAcquisto(cofanetto);
		pacchettoTest.aggiungiAcquisto(pacchettoTest2);
		pacchettoTest2.rimuoviAcquisto(cofanetto);
		assertEquals(16.0, pacchettoTest.getPrezzo(), 0);
	}
	
	@Test
	public void testNomePacchetto() {
		assertEquals("FANTASY", pacchettoTest.getNome());
	}	

}
