package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	private Labirinto vuoto;
	private Labirinto vincente;
	private Labirinto perdente;
	
	@Before
	public void setUp() {
		this.vuoto = new Labirinto();
		this.vincente = new Labirinto();
		String Vincitore="Caffetteria";
		Stanza stanzaV= new Stanza(Vincitore);
		this.vincente.stanzaInizio=stanzaV;
		this.vincente.stanzaVincente=stanzaV;
		
		this.perdente = new Labirinto();
		String Perdente="Caffetteria";
		Stanza stanzaP= new Stanza(Perdente);
		this.perdente.stanzaInizio=stanzaP;
		this.perdente.stanzaVincente=stanzaP;
	}

	@Test
	void testVuoto() {
		assertEquals(null,vuoto);
	}
	
	@Test
	void testVincente() {
		assertEquals(new Stanza("Caffetteria"),this.vincente.getStanzaVincente());
	}

	@Test
	void testStanzaDifferente() {
		//mi aspetto che sia falso
		assertEquals(new Stanza("Bar"),this.perdente.getStanzaVincente());
	}

}
