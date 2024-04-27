package comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	@Override
	public void esegui(Partita partita, IO InOut) {
		InOut.mostraMessaggio("Grazie per aver giocato"); 
		partita.setFinita();

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
