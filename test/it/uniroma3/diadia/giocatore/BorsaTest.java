package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
    
    private Borsa borsa;
    private Attrezzo attrezzoLeggero;
    private Attrezzo attrezzoPesante;
    private Attrezzo altroAttrezzoPesante;

    @Before
    public void setUp() {
        borsa = new Borsa();
        attrezzoLeggero = new Attrezzo("Penna", 1);
        attrezzoPesante = new Attrezzo("Martello", 3);
        altroAttrezzoPesante = new Attrezzo("Laptop", 3);
    }

    @Test
    public void testAddAttrezzo() {
        assertTrue(borsa.addAttrezzo(attrezzoLeggero));
        assertEquals(1, borsa.getPeso());
        assertTrue(borsa.hasAttrezzo("Penna"));
    }

    @Test
    public void testAddAttrezzoTroppoPesante() {
        Borsa borsaPiccola = new Borsa(2);
        assertFalse(borsaPiccola.addAttrezzo(attrezzoPesante));
        assertEquals(0, borsaPiccola.getPeso());
        assertFalse(borsaPiccola.hasAttrezzo("Martello"));
    }

    @Test
    public void testGetContenutoOrdinatoPerPeso() {
        borsa.addAttrezzo(attrezzoPesante);
        borsa.addAttrezzo(attrezzoLeggero);
        List<Attrezzo> attrezziOrdinati = borsa.getContenutoOrdinatoPerPeso();
        assertNotNull(attrezziOrdinati);
        assertEquals(2, attrezziOrdinati.size());
        assertEquals(attrezzoLeggero, attrezziOrdinati.get(0));
        assertEquals(attrezzoPesante, attrezziOrdinati.get(1));
    }

    @Test
    public void testGetContenutoOrdinatoPerNome() {
        borsa.addAttrezzo(attrezzoPesante);
        borsa.addAttrezzo(attrezzoLeggero);
        SortedSet<Attrezzo> attrezziOrdinati = borsa.getContenutoOrdinatoPerNome();
        assertNotNull(attrezziOrdinati);
        assertEquals(2, attrezziOrdinati.size());
        assertEquals(attrezzoLeggero, attrezziOrdinati.last());
        assertEquals(attrezzoPesante, attrezziOrdinati.first());
    }

    @Test
    public void testGetContenutoRaggruppatoPerPeso() {
        borsa.addAttrezzo(attrezzoPesante);
        borsa.addAttrezzo(attrezzoLeggero);
        borsa.addAttrezzo(altroAttrezzoPesante);
        Map<Integer, Set<Attrezzo>> attrezziRaggruppati = borsa.getContenutoRaggruppatoPerPeso();
        assertNotNull(attrezziRaggruppati);
        assertEquals(2, attrezziRaggruppati.size());
        assertTrue(attrezziRaggruppati.containsKey(1));
        assertTrue(attrezziRaggruppati.containsKey(3));
        assertEquals(1, attrezziRaggruppati.get(1).size());
        assertEquals(2, attrezziRaggruppati.get(3).size());
    }

    @Test
    public void testGetSortedSetOrdinatoPerPeso() {
        borsa.addAttrezzo(attrezzoPesante);
        borsa.addAttrezzo(attrezzoLeggero);
        SortedSet<Attrezzo> attrezziOrdinati = borsa.getSortedSetOrdinatoPerPeso();
        assertNotNull(attrezziOrdinati);
        assertEquals(2, attrezziOrdinati.size());
        assertEquals(attrezzoLeggero, attrezziOrdinati.first());
        assertEquals(attrezzoPesante, attrezziOrdinati.last());
    }

    @Test
    public void testRemoveAttrezzo() {
        borsa.addAttrezzo(attrezzoLeggero);
        Attrezzo rimosso = borsa.removeAttrezzo("Penna");
        assertNotNull(rimosso);
        assertEquals(attrezzoLeggero, rimosso);
        assertFalse(borsa.hasAttrezzo("Penna"));
    }

    @Test
    public void testToStringBorsaVuota() {
        assertEquals("Borsa vuota", borsa.toString());
    }

    @Test
    public void testToStringBorsaNonVuota() {
        borsa.addAttrezzo(attrezzoLeggero);
        String descrizione = borsa.toString();
        assertTrue(descrizione.contains("Penna"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(borsa.isEmpty());
        borsa.addAttrezzo(attrezzoLeggero);
        assertFalse(borsa.isEmpty());
    }

    @Test
    public void testGetPeso() {
        borsa.addAttrezzo(attrezzoLeggero);
        assertEquals(1, borsa.getPeso());
    }

    @Test
    public void testGetPesoMax() {
        assertEquals(Borsa.DEFAULT_PESO_MAX_BORSA, borsa.getPesoMax());
    }
}
