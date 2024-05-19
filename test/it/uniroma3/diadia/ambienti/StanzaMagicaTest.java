package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

    private StanzaMagica stanzaMagica;
    private Attrezzo attrezzo1;
    private Attrezzo attrezzo2;
    private Attrezzo attrezzo3;
    private Attrezzo attrezzo4;

    @Before
    public void setUp() {
        stanzaMagica = new StanzaMagica("Stanza Magica", 3);
        attrezzo1 = new Attrezzo("penna", 1);
        attrezzo2 = new Attrezzo("matita", 2);
        attrezzo3 = new Attrezzo("quaderno", 1);
        attrezzo4 = new Attrezzo("libro", 3);
    }

    @Test
    public void testAddAttrezzoFinoASoglia() {
        assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo2));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo3));
        assertEquals(attrezzo1, stanzaMagica.getAttrezzo("penna"));
        assertEquals(attrezzo2, stanzaMagica.getAttrezzo("matita"));
        assertEquals(attrezzo3, stanzaMagica.getAttrezzo("quaderno"));
    }

    @Test
    public void testAddAttrezzoOltreSoglia() {
        assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo2));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo3));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo4));

        Attrezzo attrezzoModificato = stanzaMagica.getAttrezzo("orbil"); // "libro" reversed
        assertNotNull(attrezzoModificato);
        assertEquals(6, attrezzoModificato.getPeso());
    }

    @Test
    public void testModificaAttrezzo() {
        Attrezzo attrezzoModificato = stanzaMagica.modificaAttrezzo(attrezzo4);

        assertEquals("orbil", attrezzoModificato.getNome());
        assertEquals(6, attrezzoModificato.getPeso());
    }
    
    @Test
    public void testContatoreAttrezziPosati() {
        assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo2));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo3));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo4));

        assertEquals(4, stanzaMagica.getcontatoreAttrezziPosati());
    }
}

