package catalogo.extra;

import catalogo.Acquisto;
import catalogo.EdizioneVariant;

public class Variant extends EdizioneVariant {
	
	private String variant;

	public Variant(Acquisto edizioneTest, String variant) {
		super(edizioneTest);
		this.variant = variant;
	}
	
	@Override
	public String getNome() {
		return super.getNome() + " [" + variant + "]";
	}
	
	@Override
	public double getPrezzo() {
		return super.getPrezzo();
	}

}
