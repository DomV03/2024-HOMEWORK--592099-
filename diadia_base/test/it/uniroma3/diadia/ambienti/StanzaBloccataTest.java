package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    @Test
    public void testGetStanzaAdiacente_DirezioneCorrettaConAttrezzo() {
        StanzaBloccata stanza = new StanzaBloccata("stanza1", "osso", "nord");
        stanza.addAttrezzo(new Attrezzo("osso", 1));
        assertEquals(null, stanza.getStanzaAdiacente("ovest"));
        assertEquals(null, stanza.getStanzaAdiacente("sud"));
        assertEquals(null, stanza.getStanzaAdiacente("est"));
        assertEquals(null, stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetDescrizione_AttrPresente() {
        StanzaBloccata stanza = new StanzaBloccata("stanza3", "osso", "nord");
        stanza.addAttrezzo(new Attrezzo("osso", 1));
        assertTrue(stanza.getDescrizione().contains("osso"));
    }

    @Test
    public void testGetDescrizione_AttrAssente() {
        StanzaBloccata stanza = new StanzaBloccata("stanza4", "osso", "nord");
        assertTrue(stanza.getDescrizione().contains("Ti serve l'osso per avanzare"));
    }

    @Test
    public void testHasAttrezzo_AttrPresente() {
        StanzaBloccata stanza = new StanzaBloccata("stanza5", "osso", "nord");
        stanza.addAttrezzo(new Attrezzo("osso", 1));
        assertTrue(stanza.hasAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzo_AttrAssente() {
        StanzaBloccata stanza = new StanzaBloccata("stanza6", "osso", "nord");
        assertFalse(stanza.hasAttrezzo("osso"));
    }
}
