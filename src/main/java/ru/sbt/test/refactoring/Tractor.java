package ru.sbt.test.refactoring;

public class Tractor {
    private static final int FIELD_BORDER_X = 5;
    private static final int FIELD_BORDER_Y = 5;
    private int positionX, positionY;
    private Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        switch (command.charAt(0)) {
            case 'F':
                moveForwards();
                break;
            case 'T':
                turnClockwise();
                break;
        }
    }

    public void moveForwards() {
        if (orientation == Orientation.NORTH)
            ++positionY;
        else if (orientation == Orientation.EAST)
            ++positionX;
        else if (orientation == Orientation.SOUTH)
            --positionY;
        else
            --positionX;

        if (positionX > FIELD_BORDER_X || positionY > FIELD_BORDER_Y)
            throw new TractorInDitchException();
    }

    public void turnClockwise() {
        if (orientation == Orientation.NORTH)
            orientation = Orientation.EAST;
        else if (orientation == Orientation.EAST)
            orientation = Orientation.SOUTH;
        else if (orientation == Orientation.SOUTH)
            orientation = Orientation.WEST;
        else
            orientation = Orientation.NORTH;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
