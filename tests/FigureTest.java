import model.*;
import org.junit.jupiter.api.Assertions;

class FigureTest {

    //Test of een kubus met ribbe 3 inderdaad een inhoud van 27 geeft.
    @org.junit.jupiter.api.Test
    void checkVolume() throws Exception {
        Figure testCube = new Cube("Doosje", Shape.cube, 3);
        double testVolume = testCube.getVolume();
        Assertions.assertEquals(27.0,testVolume);
    }
}


