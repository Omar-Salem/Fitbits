package org.omarsalem.fitbits.viewmodels;

import org.omarsalem.fitbits.models.Trainee;

import java.util.Arrays;

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
