package ch.tictactoe;

import ch.zhaw.iwi.devops.tictactoe.*;

import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TicTacToeTest {
    private TicTacToe ttt;
    
    @BeforeClass
    public static void allesVorbereiten(){
        //Bspw. Datenbank initialisieren
    }

    @Before
    public void setUp() throws Exception {
        ttt = new TicTacToe();
    }

    @Test
    public void testInitialization() {

        //Start-Spieler merken
        String startingPlayer = ttt.getCurrentPlayer();
        //Zweiten Spieler aufgrund Start-Spieler bestimmen
        String secondPlayer = "";
        if (startingPlayer == "x") {
            secondPlayer = "o";
        } else {
            secondPlayer = "x";
        }
        //Prüfen ob Startspieler x oder o ist
        Assert.assertTrue(startingPlayer == "x" || startingPlayer== "o");
        //Versuch das Spiel mit dem falschen Spieler zu eröffnen
        Assert.assertEquals("x's turn", ttt.play(1,secondPlayer));
        //Versuch das Spiel mit dem korrekten Spieler zu eröffnen
        Assert.assertEquals("x-1", ttt.play(1,startingPlayer));
        //Versuch ein ungültiges Feld zu belegen
        Assert.assertEquals("#error-0to8", ttt.play(10,ttt.getCurrentPlayer()));
    }

    @Test
    public void testDoppelBelegung() {

        //Start-Spieler merken
        String currentPlayer = ttt.getCurrentPlayer();
        //Spiel eröffnen
        Assert.assertEquals(currentPlayer+"-1",ttt.play(1,ttt.getCurrentPlayer()));
        //Prüfen ob der Spieler korrekt wechselt
        assertNotEquals(currentPlayer, ttt.getCurrentPlayer());
        //Spieler merken
        currentPlayer = ttt.getCurrentPlayer();
        //Ungültigen Spielzug mit belegtem Feld
        Assert.assertEquals("#error-1-belegt",ttt.play(1,ttt.getCurrentPlayer()));
        //Gleichzeitig prüfen, dass der Spieler unverändert an der Reihe ist
        Assert.assertEquals(currentPlayer,ttt.getCurrentPlayer());
    }
    @Test
    public void testXWins(){
        ttt.play(1,ttt.getCurrentPlayer());
        ttt.play(0,ttt.getCurrentPlayer());
        ttt.play(4,ttt.getCurrentPlayer());
        ttt.play(3,ttt.getCurrentPlayer());
        Assert.assertEquals("x gewinnt",ttt.play(7,ttt.getCurrentPlayer()));
    }

    @Test
    public void testUnentschieden(){
        ttt.play(0,ttt.getCurrentPlayer());
        ttt.play(3,ttt.getCurrentPlayer());
        ttt.play(1,ttt.getCurrentPlayer());
        ttt.play(4,ttt.getCurrentPlayer());
        ttt.play(5,ttt.getCurrentPlayer());
        ttt.play(2,ttt.getCurrentPlayer());
        ttt.play(6,ttt.getCurrentPlayer());
        ttt.play(8,ttt.getCurrentPlayer());
        Assert.assertEquals("unentschieden!",ttt.play(7,ttt.getCurrentPlayer()));
    }

    @Test
    public void demoAsserts(){
        Assert.assertEquals(1, 1);
        Assert.assertEquals("abc", "abc");

        Object anObject = new Object();
        Assert.assertEquals(anObject, anObject);

        Boolean aBoolean = true;
        Boolean anotherBoolean = false;
        Assert.assertTrue(aBoolean);
        Assert.assertFalse(anotherBoolean);

        Assert.assertNotNull(anObject);
    }

    @Test 
    public void ichSchlageFehl(){
        Assert.assertFalse(true);
    }

    @AfterClass
    public static void allesAufräumen(){
        //Bspw. Datenbank löschen/bereinigen
    }
}