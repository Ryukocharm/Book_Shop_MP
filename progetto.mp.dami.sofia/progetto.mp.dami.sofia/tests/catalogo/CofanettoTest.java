package catalogo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import catalogo.extra.Omaggio;
import catalogo.extra.Promozione;
import catalogo.extra.Sconto;


public class CofanettoTest {
	
	private Cofanetto cofanettoTest;
	private Promozione sconto;
	private Promozione omaggio;
	private Collection<Promozione> promozioni;
	
	@Before
	public void initialize() {
		promozioni = new ArrayList<>();
		
		cofanettoTest = new Cofanetto("One Piece Box", 100.0, promozioni);
		omaggio = new Omaggio("Omaggio", 0.0);
		sconto = new Sconto("Sconto", 10.0);
	}
	
	@Test
	public void testArgomentiCostruttore() {
		assertEquals("One Piece Box", cofanettoTest.getNome());
		assertEquals(100, cofanettoTest.getPrezzo(), 0);
		assertNotNull(cofanettoTest.getPromozioni());
	}
	
	@Test
	public void testPrezzoSenzaPromozioni() {
		assertTrue(cofanettoTest.getPrezzo() == cofanettoTest.getprezzoCofanetto());
	}
	
	@Test
	public void testAggiungiPromozione() {
		cofanettoTest.aggiungiPromozione(omaggio);
		assertTrue(promozioni.contains(omaggio));
	}
	
	@Test
	public void testAggiungiOmaggioNome() {
		cofanettoTest.aggiungiPromozione(omaggio);		
		String attesa = String.format("One Piece Box + [ Omaggio ]");
		assertEquals(attesa, cofanettoTest.getNome());
	}
	
	@Test
	public void testRimuoviOmaggioNome() {
		cofanettoTest.aggiungiPromozione(omaggio);	
		cofanettoTest.rimuoviPromozione(omaggio);	
		String attesa = String.format("One Piece Box");
		assertEquals(attesa, cofanettoTest.getNome());
	}
	
	@Test
	public void testAggiungiOmaggioPrezzo() {
		cofanettoTest.aggiungiPromozione(omaggio);
		assertEquals(100, cofanettoTest.getPrezzo(), 0);
	}
	
	@Test
	public void testAggiungiScontoNome() {
		cofanettoTest.aggiungiPromozione(sconto);		
		String attesa = String.format("One Piece Box + [ Sconto ]");
		assertEquals(attesa, cofanettoTest.getNome());
	}
	
	@Test
	public void testAggiungiScontoPrezzo() {
		cofanettoTest.aggiungiPromozione(sconto);		
		assertEquals(90, cofanettoTest.getPrezzo(), 0);
	}
	
	@Test
	public void testRimuoviScontoNome() {
		cofanettoTest.aggiungiPromozione(sconto);
		cofanettoTest.rimuoviPromozione(sconto);
		String attesa = String.format("One Piece Box");
		assertEquals(attesa, cofanettoTest.getNome());
	}
	
	@Test
	public void testRimuoviScontoPrezzo() {
		cofanettoTest.aggiungiPromozione(sconto);
		cofanettoTest.rimuoviPromozione(sconto);
		assertEquals(100, cofanettoTest.getPrezzo(), 0);
	}

}
