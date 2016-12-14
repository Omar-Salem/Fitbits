package org.omarsalem.fitbits;

import java.util.Arrays;

/**
 * Created by Omar on 14/12/2016.
 */
public class InputViewModel {
    private final Trainee trainee;
    private final String[] instructions;

    public InputViewModel(Trainee trainee, String[] instructions) {
        this.trainee = trainee;
        this.instructions = instructions;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public String[] getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "InputViewModel{" +
                "trainee=" + trainee +
                ", instructions=" + Arrays.toString(instructions) +
                '}';
    }
}
