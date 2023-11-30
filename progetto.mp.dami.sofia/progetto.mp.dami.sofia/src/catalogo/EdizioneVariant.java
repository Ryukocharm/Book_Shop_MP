package catalogo;

public abstract class EdizioneVariant implements Acquisto {
	
	private Acquisto acquisto;
	
	protected EdizioneVariant(Acquisto acquisto) {
		this.acquisto = acquisto;
	}

	@Override
	public String getNome() {
		return acquisto.getNome();
	}

	@Override
	public double getPrezzo() {
		return acquisto.getPrezzo();
	}

}
