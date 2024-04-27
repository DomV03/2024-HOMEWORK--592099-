package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	final static private String OggC="osso"; 
    final static private String dir =("nord");
    final static private String messaggio =("Ti serve l'osso per avanzare");
    private String Ogg;
    private String Di;
	public StanzaBloccata(String nome) {
		this(nome,OggC,dir);
	}
	
	public StanzaBloccata(String nome,String Oggc,String Dir) {
		super(nome);
		this.Ogg=Oggc;
		this.Di=Dir;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(Di)) {
		if(this.hasAttrezzo(Ogg)) {
			return super.getStanzaAdiacente(direzione);
		}else 
			return this;
		}else
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(Ogg)) {
			return super.getDescrizione();
		}else 
			return super.getDescrizione()+"\n"+messaggio;
	}
}
