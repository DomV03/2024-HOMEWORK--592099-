package comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando {
    private String attrezzo=null;
	


	public ComandoPrendi(String parametro) {
		setParametro(parametro);
	}

	@Override
	public void esegui(Partita partita, IO InOut) {
		// TODO Auto-generated method stub
		if(attrezzo==null) 
			InOut.mostraMessaggio("Quale strumento prendere ?");
		else {
			
		if(partita.getStanzaCorrente().getAttrezzo(attrezzo)!=null) {
			if(partita.giocatore.addAttrezzo(partita.getStanzaCorrente().getAttrezzo(attrezzo))) {
			if(partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(attrezzo)))
				InOut.mostraMessaggio("Strumento preso");
			else
				InOut.mostraMessaggio("Strumento non presente");
			}else {
				InOut.mostraMessaggio("Borsa piena / Peso troppo grande");
			}
			partita.giocatore.Stampa();

		}else
		{
			InOut.mostraMessaggio("Strumento non presente");
			
		}
		}
		InOut.mostraMessaggio("CFU correnti : "+partita.getCfu());
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		attrezzo=parametro;

	}

}
