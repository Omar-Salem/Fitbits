package org.omarsalem.fitbits;


import org.junit.Before;
import org.junit.Test;
import org.omarsalem.fitbits.services.FileDataGetter;
import org.omarsalem.fitbits.viewmodels.InputViewModel;

import java.io.File;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileDataGetterTest {
    private FileDataGetter target;

    @Before
    public void setup() {
        //Arrange
        final File file = new File(getClass().getResource("/data.txt").getFile());
        target = new FileDataGetter(file);
    }

    @Test
    public void dataFile_parserWorking() {
        //Assert
        assertEquals(5, target.getLength());
        assertEquals(15, target.getWidth());
        assertEquals(2, target.getData().size());
        final InputViewModel trainee1 = target.getData().get(0);
        assertEquals("1 2 N", trainee1.getTrainee().toString());
        assertArrayEquals(new String[]{"L", "M", "L", "M", "L", "M", "L", "M", "M"}, trainee1.getInstructions());
    }
}