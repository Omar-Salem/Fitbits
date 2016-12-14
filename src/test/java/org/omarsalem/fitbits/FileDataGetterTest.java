package org.omarsalem.fitbits;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.omarsalem.fitbits.services.FileDataGetter;
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
        assertEquals("1 2 N", trainee1.getTrainee().toString());
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