package comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita, IO InOut) {
		InOut.mostraMessaggio("CFU correnti : "+partita.getCfu());
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		InOut.mostraMessaggio(partita.giocatore.borsa.toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
