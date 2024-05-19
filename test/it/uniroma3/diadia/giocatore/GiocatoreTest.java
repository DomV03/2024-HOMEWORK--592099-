package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class GiocatoreTest {

	private Giocatore nullo;
	private Giocatore pieno;
	private Giocatore vuoto;
	Attrezzo martello = new Attrezzo("martello", 1);
	Attrezzo martellone = new Attrezzo("martellone", 10);
	
	@Before
	void setUp() {
		this.nullo= new Giocatore();
		this.pieno= new Giocatore();
		this.vuoto= new Giocatore();
		
		this.pieno.addAttrezzo(martellone);
		this.vuoto.cfu=20;
		this.vuoto.borsa=new Borsa();
		this.vuoto.borsa.numeroAttrezzi=0;
	}
	
	@Test
	void testVuota() {
		assertEquals(false,this.nullo.addAttrezzo(martello));
	}

	@Test
	void testLibera() {
		assertEquals(true,this.vuoto.addAttrezzo(martello));
	}
	
	@Test
	void testPiena() {
		assertEquals(false,this.pieno.addAttrezzo(martello));
	}

}
