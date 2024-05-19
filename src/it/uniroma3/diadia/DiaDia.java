package it.uniroma3.diadia;



import comandi.Comando;
import comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;



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
	


	private Partita partita;

	public DiaDia(IO io, Labirinto labirinto) {
		this.partita = new Partita(labirinto);		
	}

	public void gioca(IO io) {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		io.mostraMessaggio("CFU correnti : "+partita.getCfu());
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione,io));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione,IO io) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita,io);
		if (this.partita.vinta())	
		io.mostraMessaggio("Hai vinto!");
		else if (this.partita.isPersa())
		io.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita() || this.partita.isPersa();
		}
	// implementazioni dei comandi dell'utente:
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca(io);
	}
	
	
}
