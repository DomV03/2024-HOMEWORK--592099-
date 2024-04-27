package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	final static private String OggC="lanterna"; 
    final static private String messaggio =("Qui c'e' buio pesto");
    private String Ogg;
	public StanzaBuia(String nome) {
		this(nome,OggC);
		// TODO Auto-generated constructor stub
	}
	
	public StanzaBuia(String nome,String Oggc) {
		super(nome);
		this.Ogg=Oggc;
	}

	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(Ogg)) {
			return super.getDescrizione();
		}else 
			return messaggio;
	}

}
