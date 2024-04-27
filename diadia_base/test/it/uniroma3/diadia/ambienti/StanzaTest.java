package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

    private Stanza stanza;

    @Before
    public void setUp() {
        stanza = new Stanza("Atrio");
    }

    @Test
    public void testAddAttrezzo_StanzaConSpazio() {
        Attrezzo attrezzo = new Attrezzo("martello", 5);
        assertTrue(stanza.addAttrezzo(attrezzo));
        assertEquals(attrezzo, stanza.getAttrezzo("martello"));
    }

    @Test
    public void testRemoveAttrezzo_AttrPresente() {
        Attrezzo attrezzo = new Attrezzo("martello", 5);
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.removeAttrezzo(attrezzo));
        assertNull(stanza.getAttrezzo("martello"));
    }

    @Test
    public void testRemoveAttrezzo_AttrAssente() {
        Attrezzo attrezzo = new Attrezzo("martello", 5);
        assertFalse(stanza.removeAttrezzo(attrezzo));
    }

    @Test
    public void testHasAttrezzo_AttrPresente() {
        Attrezzo attrezzo = new Attrezzo("martello", 5);
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.hasAttrezzo("martello"));
    }

    @Test
    public void testHasAttrezzo_AttrAssente() {
        assertFalse(stanza.hasAttrezzo("martello"));
    }
}