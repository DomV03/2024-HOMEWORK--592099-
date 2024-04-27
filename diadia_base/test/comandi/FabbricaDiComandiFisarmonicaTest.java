package comandi;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;
import comandi.Comando;
import comandi.ComandoAiuto;
import comandi.ComandoFine;
import comandi.ComandoGuarda;
import comandi.ComandoNonValido;
import comandi.ComandoPosa;
import comandi.ComandoPrendi;
import comandi.ComandoVai;

public class FabbricaDiComandiFisarmonicaTest {

    @Test
    public void testCostruisciComando_Vai() {
        FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
        Comando comando = fabbrica.costruisciComando("vai nord");
        assertTrue(comando instanceof ComandoVai);
       
    }

    @Test
    public void testCostruisciComando_Prendi() {
        FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
        Comando comando = fabbrica.costruisciComando("prendi libro");
        assertTrue(comando instanceof ComandoPrendi);
        
    }

    @Test
    public void testCostruisciComando_Posa() {
        FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
        Comando comando = fabbrica.costruisciComando("posa penna");
        assertTrue(comando instanceof ComandoPosa);
     
    }

    @Test
    public void testCostruisciComando_Aiuto() {
        FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
        Comando comando = fabbrica.costruisciComando("aiuto");
        assertTrue(comando instanceof ComandoAiuto);
    
    }

    @Test
    public void testCostruisciComando_Fine() {
        FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
        Comando comando = fabbrica.costruisciComando("fine");
        assertTrue(comando instanceof ComandoFine);
       
    }

    @Test
    public void testCostruisciComando_Guarda() {
        FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
        Comando comando = fabbrica.costruisciComando("guarda");
        assertTrue(comando instanceof ComandoGuarda);
       
    }

    @Test
    public void testCostruisciComando_NonValido() {
        FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica();
        Comando comando = fabbrica.costruisciComando("nonvalido");
        assertTrue(comando instanceof ComandoNonValido);
       
    }
}
