package org.omarsalem.fitbits.models;

import java.util.ArrayList;
import java.util.List;

public class SoccerPitch {

    private final int length;
    private final int width;
    private final List<Trainee> trainees = new ArrayList<>();

    public SoccerPitch(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void add(Trainee trainee) {
        trainees.add(trainee);
    }

    public int getTraineesCount() {
        return trainees.size();
    }

    public void instruct(int index, String instruction) {
        trainees.get(index).command(instruction);
    }

    public String getFinalPosition(int index) {
        return trainees.get(index).toString();
    }

    @Override
    public String toString() {
        return "SoccerPitch{" +
                "length=" + length +
                ", width=" + width +
                ", trainees=" + trainees +
                '}';
    }
}
