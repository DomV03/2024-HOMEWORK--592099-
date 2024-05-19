package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	private Stanza stanzaCorrente;
	private boolean finita=false;
	
	Labirinto labirinto = new Labirinto();
	public Giocatore giocatore = new Giocatore();
	
	public Partita(Labirinto labirinto2){
		this.labirinto = labirinto2;
		giocatore = new Giocatore();
		//labirinto.creaStanze();
		this.finita = false;
		stanzaCorrente=labirinto.stanzaInizio;
	}

	public Labirinto getLabirinto(){
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return  vinta() || (giocatore.cfu == 0) || finita;
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
			return giocatore.getCfu();
		}

    public void setCfu() {
			giocatore.cfu--;		
		}

	public boolean isPersa() {
		// TODO Auto-generated method stub
		return   (giocatore.cfu == 0) ;
	}
	
	

}
