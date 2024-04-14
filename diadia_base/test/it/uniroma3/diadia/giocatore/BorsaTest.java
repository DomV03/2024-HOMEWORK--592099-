package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	private Borsa vuota;
	private Borsa piena;
	private Borsa libera;
	private Borsa pesoSi;
	private Borsa pesoNo;
	Attrezzo martello = new Attrezzo("martello", 1);
	Attrezzo martellone = new Attrezzo("martellone", 10);

	@Before
	void setUp() {
		this.vuota= new Borsa();
		this.piena= new Borsa();
		this.libera= new Borsa();
		this.pesoSi= new Borsa();
		this.pesoNo= new Borsa();
		
		this.piena.numeroAttrezzi=10;
		this.libera.numeroAttrezzi=0;
		this.pesoNo.addAttrezzo(martellone);
		this.pesoSi.addAttrezzo(martello);
	}
	
	
	@Test
	void testVuota() {
		assertEquals(false,this.vuota.addAttrezzo(martello));
	}

	@Test
	void testLibera() {
		assertEquals(true,this.libera.addAttrezzo(martello));
	}
	
	@Test
	void testPiena() {
		assertEquals(false,this.piena.addAttrezzo(martello));
	}
	
	@Test
	void testPesoSi() {
		assertEquals(true,this.pesoSi.addAttrezzo(martello));
	}
	
	@Test
	void testPesoNo() {
		assertEquals(false,this.pesoNo.addAttrezzo(martello));
	}
	
	@Test
	void testBorsaVuota() {
		assertEquals(false,this.libera.removeAttrezzo("martello"));
	}
	
	@Test
	void testMartelloNo() {
		assertEquals(false,this.pesoNo.removeAttrezzo("martello"));
	}
	
	@Test
	void testMartelloSi() {
		assertEquals(true,this.pesoSi.removeAttrezzo("martello"));
	}
	
	
}
