package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {
    
	private Partita Vinta;
	private Partita Persa;
	private Partita InCorso;
	
	@Before
	public void setUp() {
		
		this.Vinta=new Partita();
		
		this.Persa=new Partita();
		this.Persa.giocatore.setCfu(0);
		
		this.InCorso=new Partita();
		this.InCorso.giocatore.setCfu(15);
		
		this.Vinta.giocatore= new Giocatore();
		this.Vinta.labirinto= new Labirinto();
		this.Vinta.setStanzaCorrente(this.Vinta.labirinto.getStanzaVincente());

		
	}
	
	
	@Test
	void testVittoria() {
		assertEquals(true,this.Vinta.isFinita());
	}
	
	@Test
	void testSconfitta() {
		assertEquals(true,this.Persa.isFinita());
	}
	
	@Test
	void testInCorso() {
		assertEquals(false,this.InCorso.isFinita());
	}

}
