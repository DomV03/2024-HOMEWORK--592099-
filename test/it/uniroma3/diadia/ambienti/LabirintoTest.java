package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LabirintoTest {

    private Labirinto labirinto;

    @Before
    public void setUp() {
        labirinto = new Labirinto();
        labirinto.creaStanze();
    }

    @Test
    public void testStanzaVincente() {
        Stanza stanzaVincente = labirinto.getStanzaVincente();
        assertNotNull(stanzaVincente);
    }

    @Test
    public void testStanzaInizio() {
        Stanza stanzaInizio = labirinto.stanzaInizio;
        assertNotNull(stanzaInizio);
    }

    @Test
    public void testCollegamentoStanze() {
        Stanza aulaN10 = labirinto.stanzaInizio.getStanzaAdiacente("sud");
        assertNotNull(aulaN10);
        assertEquals("Aula N10", aulaN10.getNome());

        Stanza atrio = aulaN10.getStanzaAdiacente("nord");
        assertNotNull(atrio);
        assertEquals("Atrio", atrio.getNome());

        Stanza aulaN11 = atrio.getStanzaAdiacente("est");
        assertNotNull(aulaN11);
        assertEquals("Aula N11", aulaN11.getNome());

        Stanza laboratorio = atrio.getStanzaAdiacente("ovest");
        assertNotNull(laboratorio);
        assertEquals("Laboratorio Campus", laboratorio.getNome());
    }


}