package catalogo.extra;

import catalogo.Acquisto;
import catalogo.EdizioneVariant;

public class Gadget extends EdizioneVariant {
	
	private String descrizione;
	private double prezzoExtra;
	
	public Gadget(Acquisto acquisto, String nomeGadget, double prezzoGadget) {
		super(acquisto);
		this.descrizione = nomeGadget;
		this.prezzoExtra = prezzoGadget;
	}
	
	@Override
	public String getNome() {
		return super.getNome() + " + " + descrizione;
	}
	
	@Override
	public double getPrezzo() {
		return super.getPrezzo() + prezzoExtra;
	}
	
}
