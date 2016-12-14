package org.omarsalem.fitbits.models;

import java.awt.*;
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

    public void addTrainee(Trainee trainee) {
        final Point position = new Point(trainee.getX(), trainee.getY());
        if (checkIsValidPosition(position)) {
            trainees.add(trainee);
        }
    }

    public int getTraineesCount() {
        return trainees.size();
    }

    public void instructTrainee(int index, String instruction) {
        final Trainee trainee = trainees.get(index);
        switch (instruction) {
            case "L":
                trainee.turnLeft();
                break;
            case "R":
                trainee.turnRight();
                break;
            default:
                final Point newPosition = trainee.getNewPosition();
                if (checkIsValidPosition(newPosition)) {
                    trainee.move(newPosition);
                }
                break;
        }
    }

    public String getTraineeFinalPosition(int index) {
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

    private boolean checkIsValidPosition(Point newPosition) {
        final boolean outside = newPosition.x < 0 || newPosition.x > length || newPosition.y < 0 || newPosition.y > width;
        return !outside;
    }
}
