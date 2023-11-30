package pagamento;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import catalogo.Acquisto;
import catalogo.Edizione;
import gestione.carrello.Carrello;

public class ContanteTest {
	
	private Pagamento contanteTest;
	private Carrello carrello;
	private Acquisto edizione;

	@Before
	public void initialize() {
		Collection <Acquisto> acquisti = new ArrayList<>();
		
		carrello = new Carrello(5, acquisti);
		contanteTest = new Contante(20);
		edizione = new Edizione("Il Quinto Giorno", "Frank Schatzing", 16);
	}
	

	@Test
	public void testCostruttoreContante() {
		assertEquals(20, contanteTest.getCredito(), 0);
	}
	
	@Test
	public void testRicevutaInesistente() {
		try {
			contanteTest.pagamento(carrello);
		} catch(CreditoInsufficienteEccezione e) {
			fail("Exception should not be thrown");
		}
		assertNull(contanteTest.getRicevuta());
	}
	
	@Test
	public void testPagamentoSenzaResto() {
		Acquisto edizione2 = new Edizione("One Piece 1", "Oda Eichiro", 4);
		
		carrello.aggiungiAcquistoAlCarrello(edizione);
		carrello.aggiungiAcquistoAlCarrello(edizione2);
		try {
			contanteTest.pagamento(carrello);
		} catch(CreditoInsufficienteEccezione e) {
			fail("Exception should not be thrown");
		}
		String attesa = String.format("---Ricevuta---\n"
				+ "Carrello [5]\n"
				+ "Il Quinto Giorno, Frank Schatzing: 16.0 euro\n"
				+ "One Piece 1, Oda Eichiro: 4.0 euro\n"
				+ "Totale: " + carrello.getprezzoTotale() + "\n"
				+ "Pagamento in contanti. Totale: " + contanteTest.getCredito() + " euro\n"
				+ "Resto: 0.0 euro.");
		assertEquals(attesa, contanteTest.getRicevuta());		
	}
	
	@Test
	public void testPagamentoConResto() {
		carrello.aggiungiAcquistoAlCarrello(edizione);
		try {
			contanteTest.pagamento(carrello);
		} catch(CreditoInsufficienteEccezione e) {
			fail("Exception should not be thrown");
		}
		String attesa = String.format("---Ricevuta---\n"
				+ "Carrello [5]\n"
				+ "Il Quinto Giorno, Frank Schatzing: " + edizione.getPrezzo() + " euro\n"
				+ "Totale: " + carrello.getprezzoTotale() + "\n"
				+ "Pagamento in contanti. Totale: " + contanteTest.getCredito() + " euro\n"
				+ "Resto: 4.0 euro.");
		assertEquals(attesa, contanteTest.getRicevuta());		
	}
	
	

}
