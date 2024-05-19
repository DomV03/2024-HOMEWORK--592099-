package comandi;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
    private ComandoVai comandoVai;
    private Partita partita;
    private Labirinto labirinto;
    private Stanza stanzaInizio;
    private Stanza stanzaAdiacente;
    private IO io;

    @Before
    public void setUp() {
        // Crea le stanze
        stanzaInizio = new Stanza("Inizio");
        stanzaAdiacente = new Stanza("Adiacente");
        
        // Configura le stanze adiacenti
        stanzaInizio.impostaStanzaAdiacente("nord", stanzaAdiacente);
        
        // Crea il labirinto e imposta le stanze iniziale e vincente
        labirinto = new Labirinto();
        labirinto.setStanzaInizio(stanzaInizio);

        // Crea la partita
        partita = new Partita(labirinto);
        

    }

    @Test
    public void testVaiInDirezioneValida() {
        comandoVai = new ComandoVai("nord");
        comandoVai.esegui(partita, io);
        
        assertEquals(stanzaAdiacente, partita.getStanzaCorrente());

    }

    @Test
    public void testVaiInDirezioneInvalida() {
        comandoVai = new ComandoVai("sud");
        comandoVai.esegui(partita, io);
        
        assertEquals(stanzaInizio, partita.getStanzaCorrente());
     
    }

    @Test
    public void testVaiConDirezioneNulla() {
        comandoVai = new ComandoVai(null);
        comandoVai.esegui(partita, io);
        
        assertEquals(stanzaInizio, partita.getStanzaCorrente());

    }
	
}
