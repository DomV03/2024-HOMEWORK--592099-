package comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;

	public ComandoVai(String parametro) {
		setParametro(parametro);
	}

	@Override
	public void esegui(Partita partita, IO InOut) {
		if(direzione==null)
			InOut.mostraMessaggio("Dove vuoi andare");
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			InOut.mostraMessaggio("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			
			partita.setCfu();
		}
		InOut.mostraMessaggio("CFU correnti : "+partita.getCfu());
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		direzione=parametro;
	}

}
