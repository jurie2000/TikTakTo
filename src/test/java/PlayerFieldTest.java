import org.example.GameFolder.PlayField;
import org.example.GameFolder.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PlayerFieldTest {
    private final Player player;
    private final PlayField playField;

    PlayerFieldTest(){
        this.playField = new PlayField();
        this.player = new Player("Jusin");
        playField.iniPlayField();
        playField.setField(0,0,'J');
        playField.setField(0,1,'J');
        playField.setField(0,2,'J');

        playField.setField(1,0,'J');
        playField.setField(2,0,'J');
        playField.setField(3,0,'J');

        playField.setField(2,1,'J');
        playField.setField(1,1,'J');
        playField.setField(2,2,'J');
    }

    //012x
    //JJJ0
    //JJ'1
    //J'J2
    //   y



    @Test
    public void checkOutOfBounds(){
        assertFalse(playField.checkOutOfBounds(0, 0));
        assertTrue(playField.checkOutOfBounds(0,3));

    }

    @Test
    public void checkIfFieldFree(){
        assertFalse(playField.checkIfFieldFree(1,1));
        assertTrue(playField.checkIfFieldFree(1,2));
    }
    @Test
    public void testCheckForWinCase(){
        assertTrue(playField.checkForWin(1,0,player),"UpperLower WinCase");
        assertTrue(playField.checkForWin(0,1,player),"LeftRight WinCase");
        assertTrue(playField.checkForWin(1,1,player), "LowerRightUpperLeft WinCase");
        assertTrue(playField.checkForWin(0,2,player), "LowerLefUpperRight WinCase");

    }

    @Test
    public void testCheckLeft(){
        playField.checkLeft(0,2,player);
        assertEquals(2,playField.getCounter());
        playField.setCounter(0);
        playField.checkLeft(0,0,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);
        playField.checkLeft(0,1,player);
        assertEquals(1,playField.getCounter());
    }

    @Test
    public void testCheckRight(){
        playField.checkRight(0,0,player);
        assertEquals(2,playField.getCounter());
        playField.setCounter(0);
        playField.checkRight(0,1,player);
        assertEquals(1,playField.getCounter());
        playField.setCounter(0);
        playField.checkRight(0,2,player);
        assertEquals(0,playField.getCounter());
    }
    @Test
    public void testCheckUpper(){
        playField.checkUpper(0,0,player);
        assertEquals(2,playField.getCounter());
        playField.setCounter(0);
        playField.checkUpper(1,0,player);
        assertEquals(1,playField.getCounter());
        playField.setCounter(0);
        playField.checkUpper(2,0,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);
        playField.checkUpper(1,2,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);
    }

    @Test
    public void testCheckLower(){
        playField.checkLower(0,0,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);
        playField.checkLower(1,0,player);
        assertEquals(1,playField.getCounter());
        playField.setCounter(0);
        playField.checkLower(2,0,player);
        assertEquals(2,playField.getCounter());
        playField.setCounter(0);
        playField.checkLower(1,2,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);

    }

    @Test
    public void testCheckUpperLeft(){
        playField.checkUpperLeft(2,2,player);
        assertEquals(2,playField.getCounter());
        playField.setCounter(0);
        playField.checkUpperLeft(1,1,player);
        assertEquals(1,playField.getCounter());
        playField.setCounter(0);
        playField.checkUpperLeft(0,0,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);
    }

    @Test
    public void testCheckUpperRight(){
        playField.checkUpperRight(2,0,player);
        assertEquals(2,playField.getCounter());
        playField.setCounter(0);
        playField.checkUpperRight(1,1,player);
        assertEquals(1,playField.getCounter());
        playField.setCounter(0);
        playField.checkUpperRight(0,2,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);
    }
    @Test
    public void testCheckLowerLeft(){
        playField.checkLowerLeft(0,2,player);
        assertEquals(2,playField.getCounter());
        playField.setCounter(0);
        playField.checkLowerLeft(1,1,player);
        assertEquals(1,playField.getCounter());
        playField.setCounter(0);
        playField.checkLowerLeft(2,0,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);
    }
    @Test
    public void testCheckLowerRight(){
        playField.checkLowerRight(0,0,player);
        assertEquals(2,playField.getCounter());
        playField.setCounter(0);
        playField.checkLowerRight(1,1,player);
        assertEquals(1,playField.getCounter());
        playField.setCounter(0);
        playField.checkLowerRight(2,2,player);
        assertEquals(0,playField.getCounter());
        playField.setCounter(0);
    }


}
