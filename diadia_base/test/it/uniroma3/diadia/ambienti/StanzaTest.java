package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	private Stanza vuota;
	private Stanza piena;
	private Stanza libera;
	private Stanza martelloNO;
	private Stanza martelloSI;
	Attrezzo martello = new Attrezzo("martello", 1);
	
	@Before
	void setUp() {
	this.vuota= new Stanza(null);
	this.piena= new Stanza("atrio");
	this.libera= new Stanza("bagno");
	this.martelloNO= new Stanza("atrio1");
	this.martelloSI= new Stanza("bagno1");
	
	this.piena.numeroAttrezzi=10;
	this.martelloSI.addAttrezzo(martello);
	
	}
	
	@Test
	void testVuota() {
		assertEquals(false,this.vuota.addAttrezzo(martello));
	}
	
	@Test
	void testPiena() {
		assertEquals(false,this.piena.addAttrezzo(martello));
	}

	@Test
	void testLibera() {
		assertEquals(true,this.libera.addAttrezzo(martello));
	}
	
	@Test
	void testVuotaTogli() {
		assertEquals(false,this.vuota.removeAttrezzo(martello));
	}
	
	@Test
	void testNoMartello() {
		assertEquals(false,this.martelloNO.removeAttrezzo(martello));
	}

	@Test
	void testSiMartello() {
		assertEquals(true,this.martelloSI.removeAttrezzo(martello));
	}
}
