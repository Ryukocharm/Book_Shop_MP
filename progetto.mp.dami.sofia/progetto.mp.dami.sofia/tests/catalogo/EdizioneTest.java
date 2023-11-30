package catalogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import catalogo.extra.Gadget;
import catalogo.extra.Variant;

public class EdizioneTest {
	
	private Acquisto edizioneTest;
	private Acquisto edizioneVariantTest;
	private Acquisto edizioneVariantTest2;
	
	
	@Before
	public void initialize() {
		edizioneTest = new Edizione("Scheletri", "Zerocalcare", 12.50);
		edizioneVariantTest = new Gadget(edizioneTest, "peluche", 3.00);
	}
	

	@Test
	public void testCostruttoreStandard() {
		assertEquals("Scheletri, Zerocalcare", edizioneTest.getNome());
		assertEquals(12.50, edizioneTest.getPrezzo(), 0);
	}
	
	@Test
	public void testCostruttorGadget() {
		assertEquals("Scheletri, Zerocalcare + peluche", edizioneVariantTest.getNome());
		assertEquals(15.50, edizioneVariantTest.getPrezzo(), 0);
	}
	
	@Test
	public void testCostruttoreVariant() {
		edizioneVariantTest2 = new Variant(edizioneTest, "variant");
		assertEquals("Scheletri, Zerocalcare [variant]", edizioneVariantTest2.getNome());
		assertTrue(edizioneTest.getPrezzo() == edizioneVariantTest2.getPrezzo());
	}


}
