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

public class ComandoPosaTest {

    private ComandoPosa comandoPosa;
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

        // Crea il labirinto e imposta la stanza corrente
        Labirinto labirinto = new Labirinto();
        labirinto.setStanzaInizio(stanzaCorrente);

        // Crea la partita
        partita = new Partita(labirinto);

        // Crea il giocatore
        giocatore = partita.giocatore;

        // Aggiungi l'attrezzo al giocatore
        giocatore.addAttrezzo(attrezzo);
    }

    @Test
    public void testPosaAttrezzoPresente() {
        comandoPosa = new ComandoPosa("Chiave");
        comandoPosa.esegui(partita, io);

        // Verifica che l'attrezzo sia stato rimosso dal giocatore
        assertFalse(giocatore.hasAttrezzo("Chiave"));

        // Verifica che l'attrezzo sia stato aggiunto alla stanza
        assertNotNull(stanzaCorrente.getAttrezzo("Chiave"));

    }

    @Test
    public void testPosaAttrezzoNonPresente() {
        comandoPosa = new ComandoPosa("Martello");
        comandoPosa.esegui(partita, io);

        // Verifica che l'attrezzo "Martello" non sia stato rimosso dal giocatore
        assertFalse(giocatore.hasAttrezzo("Martello"));


    }

    @Test
    public void testPosaConParametroNull() {
        comandoPosa = new ComandoPosa(null);
        comandoPosa.esegui(partita, io);


    }

    @Test
    public void testPosaQuandoStanzaPiena() {
        // Riempie la stanza con attrezzi fino a renderla piena
        for (int i = 0; i < 10; i++) {
            stanzaCorrente.addAttrezzo(new Attrezzo("Attrezzo" + i, 1));
        }

        comandoPosa = new ComandoPosa("Chiave");
        comandoPosa.esegui(partita, io);

        // Verifica che l'attrezzo "Chiave" non sia stato rimosso dal giocatore
        assertTrue(giocatore.hasAttrezzo("Chiave"));

        // Verifica che l'attrezzo "Chiave" non sia stato aggiunto alla stanza
        assertNull(stanzaCorrente.getAttrezzo("Chiave"));

    }
}

