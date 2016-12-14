package org.omarsalem.fitbits;

import static org.omarsalem.fitbits.Util.*;

public class Trainee {
    private int x;
    private int y;
    private String heading;
    private int bearing;

    public Trainee(int x, int y, String heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
        switch (heading) {
            case "N":
                this.bearing = ZERO_DEGREES;
                break;
            case "E":
                this.bearing = NINETY_DEGREES;
                break;
            case "S":
                this.bearing = ONE_HUNDRED_EIGHT_DEGREES;
                break;
            case "W":
                this.bearing = TWO_HUNDRED_SEVENTY_DEGREES;
                break;
        }
    }

    public void command(String instruction) {
        switch (instruction) {
            case "L":
                this.bearing -= NINETY_DEGREES;
                adjustHeading();
                break;
            case "R":
                this.bearing += NINETY_DEGREES;
                adjustHeading();
                break;
            case "M":
                move();
                break;
        }
    }

    private void adjustHeading() {
        if (bearing < 0) {
            bearing += FULL_CIRCLE;
        }
        bearing %= FULL_CIRCLE;
        switch (bearing) {
            case ZERO_DEGREES:
                heading = "N";
                break;
            case NINETY_DEGREES:
                heading = "E";
                break;
            case ONE_HUNDRED_EIGHT_DEGREES:
                heading = "S";
                break;
            case TWO_HUNDRED_SEVENTY_DEGREES:
                heading = "W";
                break;
        }
    }

    private void move() {
        switch (bearing) {
            //North
            case ZERO_DEGREES:
                y++;
                break;
            //East
            case NINETY_DEGREES:
                x++;
                break;
            //South
            case ONE_HUNDRED_EIGHT_DEGREES:
                y--;
                break;
            //West
            default:
                x--;
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", x, y, heading);
    }
}