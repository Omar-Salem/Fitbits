package org.omarsalem.fitbits.services;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.omarsalem.fitbits.viewmodels.InputViewModel;

import java.io.File;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileDataGetterTest {
    @Test
    public void dataFileExists_traineeDataParsed() {
        //Arrange
        final File file = new File(getClass().getResource("/data.txt").getFile());
        FileDataGetter target = new FileDataGetter(file);

        //Assert
        assertEquals(5, target.getLength());
        assertEquals(15, target.getWidth());
        assertEquals(2, target.getData().size());
        final InputViewModel trainee1 = target.getData().get(0);
        assertEquals(1, trainee1.getTrainee().getX());
        assertEquals(2, trainee1.getTrainee().getY());
        assertEquals("N", trainee1.getTrainee().getHeading());
        assertArrayEquals(new String[]{"L", "M", "L", "M", "L", "M", "L", "M", "M"}, trainee1.getInstructions());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void dataFileNonExistent_exceptionThrown() throws RuntimeException {
        //Assert
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("File not found");

        //Act
        new FileDataGetter(new File("/dummy"));
    }
}