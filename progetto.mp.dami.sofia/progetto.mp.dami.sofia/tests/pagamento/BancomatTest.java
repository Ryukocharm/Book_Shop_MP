package pagamento;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import catalogo.Acquisto;
import catalogo.Cofanetto;
import catalogo.Edizione;
import catalogo.extra.Promozione;
import gestione.carrello.Carrello;

public class BancomatTest {
	
	private Pagamento bancomatTest;
	private Carrello carrello;
	private Acquisto edizione;
	private Acquisto edizione2;
	private Acquisto cofanetto;
	private Collection<Promozione> promozioni;

	@Before
	public void initialize() {
		Collection <Acquisto> acquisti = new ArrayList<>();
		promozioni = new ArrayList<>();
		
		carrello = new Carrello(5, acquisti);
		bancomatTest = new Bancomat(120.5);
		edizione = new Edizione("Il Conte di Montecristo", "Alexandre Dumas", 16.0);
		edizione2 = new Edizione("Scheletri", "Zerocalcare", 12.5);	
		cofanetto = new Cofanetto("One Piece Box", 100.0, promozioni);
		
		carrello.aggiungiAcquistoAlCarrello(edizione);
		carrello.aggiungiAcquistoAlCarrello(cofanetto);
	}

	@Test
	public void testConfermaPagamento() {		
		try {
			bancomatTest.pagamento(carrello);
		} catch(CreditoInsufficienteEccezione e) {
			fail("Exception should not be thrown");
		}
		String attesa = String.format("---Ricevuta---\n"
				+ "Carrello [5]\n"
				+ "Il Conte di Montecristo, Alexandre Dumas: " + edizione.getPrezzo() + " euro\n"
				+ "One Piece Box: "  + cofanetto.getPrezzo() + " euro\n"
				+ "Totale: " + carrello.getprezzoTotale() + "\n"
				+ "Pagamento con bancomat. Totale: " + carrello.getprezzoTotale());
		assertEquals(attesa, bancomatTest.getRicevuta());		
	}
	
	@Test
	public void testConfermaPagamentoRimuovendoUnOrdine() {	
		carrello.rimuoviAcquistoDalCarrello(cofanetto);
		try {
			bancomatTest.pagamento(carrello);
		} catch(CreditoInsufficienteEccezione e) {
			fail("Exception should not be thrown");
		}
		String attesa = String.format("---Ricevuta---\n"
				+ "Carrello [5]\n"
				+ "Il Conte di Montecristo, Alexandre Dumas: "  + edizione.getPrezzo() + " euro\n"
				+ "Totale: " + carrello.getprezzoTotale() + "\n"
				+ "Pagamento con bancomat. Totale: " + carrello.getprezzoTotale());
		assertEquals(attesa, bancomatTest.getRicevuta());
	}
	
	@Test
	public void testCreditoInsufficiente() {
		carrello.aggiungiAcquistoAlCarrello(edizione2);	
		String eccezione = String.format("Credito Insufficiente!");
		try {
			bancomatTest.pagamento(carrello);
			fail("Should get a CreditoInsufficienteEccezione exception");
		} catch(CreditoInsufficienteEccezione e) {
			assertEquals(eccezione, e.getMessage());		
		}
	}
	
	@Test
	public void testRicevutaInesistente() {
		carrello.rimuoviAcquistoDalCarrello(cofanetto);
		carrello.rimuoviAcquistoDalCarrello(edizione);	
		try {
			bancomatTest.pagamento(carrello);
		} catch(CreditoInsufficienteEccezione e) {
			fail("Exception should not be thrown");
		}
		assertNull(bancomatTest.getRicevuta());
	}

}
