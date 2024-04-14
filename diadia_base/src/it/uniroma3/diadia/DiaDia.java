package it.uniroma3.diadia;



import it.uniroma3.diadia.ambienti.Stanza;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */


public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IOConsole InOut) {
		String istruzione; 
		
		InOut.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		InOut.mostraMessaggio("CFU correnti : "+partita.getCfu());
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		
		do		
			istruzione = InOut.leggiRiga();
		while (!processaIstruzione(istruzione,InOut));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione,IOConsole InOut) {
		if(partita.isFinita()) {
			InOut.mostraMessaggio("CFU esauriti");
			return true;
		}
		else {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(InOut); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro(),InOut);
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto(InOut);
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro(),InOut);
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro(),InOut);
		else
			InOut.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			InOut.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
		}
	}   

	// implementazioni dei comandi dell'utente:
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole InOut) {
		for(int i=0; i< elencoComandi.length; i++) 
			InOut.mostraMessaggio(elencoComandi[i]+" ");
		
	}
	
	private void prendi(String attrezzo,IOConsole InOut) {
		if(attrezzo==null) 
			InOut.mostraMessaggio("Quale strumento prendere ?");
		else {
			
		if(this.partita.getStanzaCorrente().getAttrezzo(attrezzo)!=null) {
			if(this.partita.giocatore.addAttrezzo(this.partita.getStanzaCorrente().getAttrezzo(attrezzo))) {
			if(this.partita.getStanzaCorrente().removeAttrezzo(this.partita.getStanzaCorrente().getAttrezzo(attrezzo)))
				InOut.mostraMessaggio("Strumento preso");
			else
				InOut.mostraMessaggio("Strumento non presente");
			}else {
				InOut.mostraMessaggio("Borsa piena / Peso troppo grande");
			}
			this.partita.giocatore.Stampa();

		}else
		{
			InOut.mostraMessaggio("Strumento non presente");
			
		}
		}
		InOut.mostraMessaggio("CFU correnti : "+partita.getCfu());
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	
	private void posa(String attrezzo,IOConsole InOut) {
		if(attrezzo==null) 
			InOut.mostraMessaggio("Quale strumento posare ?");
		else {
			if(this.partita.giocatore.borsa.hasAttrezzo(attrezzo)) {
				if(this.partita.getStanzaCorrente().addAttrezzo(this.partita.giocatore.borsa.getAttrezzo(attrezzo))) {
					this.partita.giocatore.borsa.removeAttrezzo(attrezzo);
					InOut.mostraMessaggio("Strumento posato");
				}else
					InOut.mostraMessaggio("Stanza piena");
				
			}else
				InOut.mostraMessaggio("Strumento non presente");
			
			
		}
		InOut.mostraMessaggio("CFU correnti : "+partita.getCfu());
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione,IOConsole InOut) {
		if(direzione==null)
			InOut.mostraMessaggio("Dove vuoi andare");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			InOut.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			
			this.partita.setCfu();
		}
		InOut.mostraMessaggio("CFU correnti : "+partita.getCfu());
		InOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole InOut) {
		InOut.mostraMessaggio("Grazie per aver giocato");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IOConsole InOut = new IOConsole();
		gioco.gioca(InOut);
	}
	
	
}
