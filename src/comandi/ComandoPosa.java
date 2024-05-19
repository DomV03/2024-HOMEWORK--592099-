package comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {

	private String attrezzo=null;
	
	public ComandoPosa(String parametro) {
		setParametro(parametro);
	}

	@Override
	public void esegui(Partita partita, IO InOut) {
		if(attrezzo==null) 
			InOut.mostraMessaggio("Quale strumento posare ?");
		else {
			if(partita.giocatore.borsa.hasAttrezzo(attrezzo)) {
				if(partita.getStanzaCorrente().addAttrezzo(partita.giocatore.borsa.getAttrezzo(attrezzo))) {
					partita.giocatore.borsa.removeAttrezzo(attrezzo);
					InOut.mostraMessaggio("Strumento posato");
				}else
					InOut.mostraMessaggio("Stanza piena");
				
			}else
				InOut.mostraMessaggio("Strumento non presente");
			
			
		}
		InOut.mostraMessaggio("CFU correnti : "+partita.getCfu());
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());	}

	@Override
	public void setParametro(String parametro) {
		attrezzo=parametro;
	}

}
