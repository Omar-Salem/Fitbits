package org.omarsalem.fitbits.models;

import java.awt.*;

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getHeading() {
        return heading;
    }

    public void turnLeft() {
        this.bearing -= NINETY_DEGREES;
        adjustHeading();
    }

    public void turnRight() {
        this.bearing += NINETY_DEGREES;
        adjustHeading();
    }

    public Point getNewPosition() {
        switch (bearing) {
            //North
            case ZERO_DEGREES:
                return new Point(x, y + 1);
            //East
            case NINETY_DEGREES:
                return new Point(x + 1, y);
            //South
            case ONE_HUNDRED_EIGHT_DEGREES:
                return new Point(x, y - 1);
            //West
            default:
                return new Point(x - 1, y);
        }
    }

    public void move(Point newPosition) {
        this.x = newPosition.x;
        this.y = newPosition.y;
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
}