package comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita,IO InOut) {
		InOut.mostraMessaggio("comando non valido");
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
