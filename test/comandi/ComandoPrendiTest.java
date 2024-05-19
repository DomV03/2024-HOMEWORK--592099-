package comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Labirinto;

public class ComandoPrendiTest {

    private ComandoPrendi comandoPrendi;
    private Partita partita;
    private Stanza stanzaCorrente;
    private Attrezzo attrezzo;
    private IO io;
    private Giocatore giocatore;

    @Before
    public void setUp() {
        // Crea la stanza
        stanzaCorrente = new Stanza("Stanza");

        // Crea l'attrezzo
        attrezzo = new Attrezzo("Chiave", 1);

        // Aggiungi l'attrezzo alla stanza
        stanzaCorrente.addAttrezzo(attrezzo);

        // Crea il labirinto e imposta la stanza corrente
        Labirinto labirinto = new Labirinto();
        labirinto.setStanzaInizio(stanzaCorrente);

        // Crea la partita
        partita = new Partita(labirinto);

        // Crea il giocatore
        giocatore = partita.giocatore;
    }

    @Test
    public void testPrendiAttrezzoPresente() {
        comandoPrendi = new ComandoPrendi("Chiave");
        comandoPrendi.esegui(partita, io);

        // Verifica che l'attrezzo sia stato aggiunto al giocatore
        assertTrue(giocatore.hasAttrezzo("Chiave"));

        // Verifica che l'attrezzo sia stato rimosso dalla stanza
        assertNull(stanzaCorrente.getAttrezzo("Chiave"));

    }

    @Test
    public void testPrendiAttrezzoNonPresente() {
        comandoPrendi = new ComandoPrendi("Martello");
        comandoPrendi.esegui(partita, io);

        // Verifica che l'attrezzo non sia stato aggiunto al giocatore
        assertFalse(giocatore.hasAttrezzo("Martello"));

    }

    @Test
    public void testPrendiConParametroNull() {
        comandoPrendi = new ComandoPrendi(null);
        comandoPrendi.esegui(partita, io);

    }

    @Test
    public void testPrendiQuandoBorsaPiena() {
        // Aggiungi molti attrezzi alla borsa fino a riempirla
        for (int i = 0; i < 10; i++) {
            giocatore.addAttrezzo(new Attrezzo("Attrezzo" + i, 1));
        }

        comandoPrendi = new ComandoPrendi("Chiave");
        comandoPrendi.esegui(partita, io);

        // Verifica che l'attrezzo non sia stato aggiunto al giocatore
        assertFalse(giocatore.hasAttrezzo("Chiave"));

        // Verifica che l'attrezzo sia ancora presente nella stanza
        assertNotNull(stanzaCorrente.getAttrezzo("Chiave"));

    }
}

