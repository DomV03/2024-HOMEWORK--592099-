package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	
	public Stanza stanzaInizio;
	public Stanza stanzaVincente;
	
	
	 /**
     * Crea tutte le stanze e le porte di collegamento
     */
	   public void creaStanze() {

			/* crea gli attrezzi */
	    	Attrezzo lanterna = new Attrezzo("lanterna",3);
			Attrezzo osso = new Attrezzo("osso",1);
	    	
			/* crea stanze del labirinto */
			StanzaBloccata atrio = new StanzaBloccata("Atrio");
			Stanza aulaN11 = new Stanza("Aula N11");
			StanzaBuia aulaN10 = new StanzaBuia("Aula N10");
			StanzaMagica laboratorio = new StanzaMagica("Laboratorio Campus");
			Stanza biblioteca = new Stanza("Biblioteca");
			
			
			/* collega le stanze */
			atrio.impostaStanzaAdiacente("nord", biblioteca);
			atrio.impostaStanzaAdiacente("est", aulaN11);
			atrio.impostaStanzaAdiacente("sud", aulaN10);
			atrio.impostaStanzaAdiacente("ovest", laboratorio);
			aulaN11.impostaStanzaAdiacente("est", laboratorio);
			aulaN11.impostaStanzaAdiacente("ovest", atrio);
			aulaN10.impostaStanzaAdiacente("nord", atrio);
			aulaN10.impostaStanzaAdiacente("est", aulaN11);
			aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
			laboratorio.impostaStanzaAdiacente("est", atrio);
			laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
			biblioteca.impostaStanzaAdiacente("sud", atrio);

	        /* pone gli attrezzi nelle stanze */
			aulaN10.addAttrezzo(lanterna);
			laboratorio.addAttrezzo(osso);

			// il gioco comincia nell'atrio
	        stanzaInizio = atrio;  
			stanzaVincente = biblioteca;
	    }
	   
	   public Stanza getStanzaVincente() {
			return stanzaVincente;
		}

	public void setStanzaVincente(Stanza s) {
		// TODO Auto-generated method stub
		stanzaVincente=s;
	}

	public void setStanzaInizio(Stanza s) {
		// TODO Auto-generated method stub
		stanzaInizio=s;
	}
	
	public Stanza getStanzaInizio() {
		// TODO Auto-generated method stub
		return stanzaInizio;
	}
}
