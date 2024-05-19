package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


class PartitaTest {
    
	private Partita partita;
    private Labirinto labirinto;
    private Stanza stanzaInizio;
    private Stanza stanzaVincente;

    @Before
    public void setUp() {
        stanzaInizio = new Stanza("Inizio");
        stanzaVincente = new Stanza("Vincente");

        // Configura il labirinto
        labirinto = new Labirinto();
        labirinto.setStanzaInizio(stanzaInizio);
        labirinto.setStanzaVincente(stanzaVincente);
        
        partita = new Partita(labirinto);
        
    }

    @Test
    public void testPartitaIniziaNellaStanzaIniziale() {
        assertEquals(stanzaInizio, partita.getStanzaCorrente());
    }

    @Test
    public void testVinta() {
        partita.setStanzaCorrente(stanzaVincente);
        assertTrue(partita.vinta());
    }

    @Test
    public void testNonVinta() {
        assertFalse(partita.vinta());
    }

    @Test
    public void testIsFinitaQuandoVinta() {
        partita.setStanzaCorrente(stanzaVincente);
        assertTrue(partita.isFinita());
    }

    @Test
    public void testIsFinitaQuandoCfuZero() {
        partita.giocatore.setCfu(0);
        assertTrue(partita.isFinita());
    }

    @Test
    public void testIsFinitaQuandoSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita());
    }

    @Test
    public void testIsFinitaQuandoNonVintaENonPersa() {
        assertFalse(partita.isFinita());
    }

    @Test
    public void testGetCfu() {
        assertEquals(partita.giocatore.getCfu(), partita.getCfu());
    }

    @Test
    public void testSetCfu() {
        int cfuIniziali = partita.getCfu();
        partita.setCfu();
        assertEquals(cfuIniziali - 1, partita.getCfu());
    }

    @Test
    public void testIsPersaQuandoCfuZero() {
        partita.giocatore.setCfu(0);
        assertTrue(partita.isPersa());
    }

    @Test
    public void testIsPersaQuandoCfuNonZero() {
        assertFalse(partita.isPersa());
    }
	
}
