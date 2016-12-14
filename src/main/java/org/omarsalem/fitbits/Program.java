package org.omarsalem.fitbits;

import org.omarsalem.fitbits.models.SoccerPitch;
import org.omarsalem.fitbits.services.DataGetter;
import org.omarsalem.fitbits.services.FileDataGetter;
import org.omarsalem.fitbits.viewmodels.InputViewModel;

import java.io.File;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        File file;
        if (args.length == 0) {
            ClassLoader classLoader = Program.class.getClassLoader();
            file = new File(classLoader.getResource("data.txt").getFile());
        } else {
            file = new File(args[0]);
        }

        DataGetter dataGetter = new FileDataGetter(file);
        SoccerPitch soccerPitch = new SoccerPitch(dataGetter.getLength(), dataGetter.getWidth());
        List<InputViewModel> traineesData = dataGetter.getData();

        for (int i = 0; i < traineesData.size(); i++) {
            final InputViewModel model = traineesData.get(i);
            soccerPitch.add(model.getTrainee());
            for (String instruction : model.getInstructions()) {
                soccerPitch.instruct(i, instruction);
            }
        }

        for (int i = 0; i < soccerPitch.getTraineesCount(); i++) {
            final String finalPosition = soccerPitch.getFinalPosition(i);
            System.out.println(finalPosition);
        }
    }
}
