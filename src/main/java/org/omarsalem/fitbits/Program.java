package org.omarsalem.fitbits;

import org.omarsalem.fitbits.models.SoccerPitch;
import org.omarsalem.fitbits.services.DataGetter;
import org.omarsalem.fitbits.services.FileDataGetter;
import org.omarsalem.fitbits.viewmodels.InputViewModel;

import java.io.File;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("please supply input file");
        }

        File file = new File(args[0]);

        DataGetter dataGetter = new FileDataGetter(file);
        SoccerPitch soccerPitch = new SoccerPitch(dataGetter.getLength(), dataGetter.getWidth());
        List<InputViewModel> traineesData = dataGetter.getData();

        for (int i = 0; i < traineesData.size(); i++) {
            final InputViewModel model = traineesData.get(i);
            soccerPitch.addTrainee(model.getTrainee());
            for (String instruction : model.getInstructions()) {
                soccerPitch.instructTrainee(i, instruction);
            }
        }

        for (int i = 0; i < soccerPitch.getTraineesCount(); i++) {
            final String finalPosition = soccerPitch.getTraineeFinalPosition(i);
            System.out.println(finalPosition);
        }
    }
}
