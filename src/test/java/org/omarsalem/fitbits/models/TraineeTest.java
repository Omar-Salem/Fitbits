package org.omarsalem.fitbits.models;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;


public class TraineeTest {

    private Trainee target;

    @Before
    public void setUp() throws Exception {
        target = new Trainee(1, 2, "N");
    }

    @Test
    public void testTurnLeft() throws Exception {
        //Arrange
        String[] orientations = new String[]{"W", "S", "E", "N", "W"};

        //Act
        for (String o : orientations) {
            target.turnLeft();

            //Assert
            assertEquals(target.getHeading(), o);
        }
    }

    @Test
    public void testTurnRight() throws Exception {
        //Arrange
        String[] orientations = new String[]{"E", "S", "W", "N", "E"};

        //Act
        for (String o : orientations) {
            target.turnRight();

            //Assert
            assertEquals(target.getHeading(), o);
        }
    }

    @Test
    public void getNewPosition_north_yAxisIncreased() throws Exception {
        //Arrange
        target = new Trainee(1, 2, "N");

        //Act
        final Point actual = target.getNewPosition();

        //Assert
        assertEquals(new Point(1, 3), actual);
    }

    @Test
    public void getNewPosition_south_yAxisDecreased() throws Exception {
        //Arrange
        target = new Trainee(1, 2, "S");

        //Act
        final Point actual = target.getNewPosition();

        //Assert
        assertEquals(new Point(1, 1), actual);
    }

    @Test
    public void getNewPosition_east_xAxisIncreased() throws Exception {
        //Arrange
        target = new Trainee(1, 2, "E");

        //Act
        final Point actual = target.getNewPosition();

        //Assert
        assertEquals(new Point(2, 2), actual);
    }

    @Test
    public void getNewPosition_west_xAxisDecreased() throws Exception {
        //Arrange
        target = new Trainee(1, 2, "W");

        //Act
        final Point actual = target.getNewPosition();

        //Assert
        assertEquals(new Point(0, 2), actual);
    }

    @Test
    public void testMove() throws Exception {
        //Arrange
        final int x = 9;
        final int y = 10;
        final Point newPosition = new Point(x, y);

        //Act
        target.move(newPosition);

        //Assert
        assertEquals(x, target.getX());
        assertEquals(y, target.getY());
    }
}