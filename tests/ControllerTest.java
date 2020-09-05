import model.*;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    //Test of het aantal objecten in de database klopt
    @org.junit.jupiter.api.Test
    void checkAdd() throws Exception {
        Database testDb = new Database();
        Figure testSphere = new Sphere("Ball", Shape.sphere, 2);
        Figure testCube = new Cube("Box", Shape.cube, 2);
        Figure testCuboid = new Cuboid("Block", Shape.cuboid, 2, 3, 4);
        testDb.addFigure(testSphere);
        testDb.addFigure(testCube);
        testDb.addFigure(testCuboid);
        double firstCount = testDb.getFigures().size();
        Assertions.assertEquals(3, firstCount);
    }

    //Test of de naam van het figuur juist in de database staat
    @org.junit.jupiter.api.Test
    void checkName() throws Exception {
        Database testDb2 = new Database();
        Figure testCone = new Cone("IceCone", Shape.cone, 5, 10);
        testDb2.addFigure(testCone);
        String coneName = testDb2.getFigures().get(0).getName();
        Assertions.assertEquals("IceCone", coneName);
    }
}