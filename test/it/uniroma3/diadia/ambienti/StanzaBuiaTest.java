package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

    @Test
    public void testDescrizione_StanzaBuiaConAttrezzoPresente() {
        StanzaBuia stanza = new StanzaBuia("stanza1", "lanterna");
        stanza.addAttrezzo(new Attrezzo("lanterna", 3));
        assertFalse(stanza.getDescrizione().equals("Qui c'è buio pesto"));
    }

    @Test
    public void testDescrizione_StanzaBuiaSenzaAttrezzoPresente() {
        StanzaBuia stanza = new StanzaBuia("stanza2", "lanterna");
        assertTrue(stanza.getDescrizione().equals("Qui c'è buio pesto"));
    }

    @Test
    public void testHasAttrezzo_AttrPresente() {
        StanzaBuia stanza = new StanzaBuia("stanza3", "lanterna");
        stanza.addAttrezzo(new Attrezzo("lanterna", 3));
        assertTrue(stanza.hasAttrezzo("lanterna"));
    }

    @Test
    public void testHasAttrezzo_AttrAssente() {
        StanzaBuia stanza = new StanzaBuia("stanza4", "lanterna");
        assertFalse(stanza.hasAttrezzo("libro"));
    }
}
