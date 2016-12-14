package org.omarsalem.fitbits;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataGetter implements DataGetter {
    private int length;
    private int width;
    private List<InputViewModel> traineeData = new ArrayList<>();

    public FileDataGetter(File file) {
        boolean firstLineParsed = false;
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNext()) {
                final String[] split = sc.nextLine().split(" ");
                if (!firstLineParsed) {
                    firstLineParsed = true;
                    length = Integer.parseInt(split[0]);
                    width = Integer.parseInt(split[1]);
                } else {
                    int x = Integer.parseInt(split[0]);
                    int y = Integer.parseInt(split[1]);

                    Trainee trainee = new Trainee(x, y, split[2]);
                    final String[] instructions = sc.nextLine().split("");
                    InputViewModel inputViewModel = new InputViewModel(trainee, instructions);
                    traineeData.add(inputViewModel);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public List<InputViewModel> getData() {
        return traineeData;
    }
}
