package com.example.tictactoe;

public class MultiPlayerMode extends PlayerMode {

    public MultiPlayerMode() {
    }

    public MultiPlayerMode(int rows, int columns) {
        super();
        checkPattern();
        XOArray = new char[rows][columns];
    }

    @Override
    public void chooseCoordinates() {

        while (true) {
            int number;
            System.out.println(getPlayer()+" : please choose a number");

            try {
                number = scanner.nextInt();

                if ((number < minValueInArray) || (number > maxValueInArray)) {
                    System.out.println("choose value from " + minValueInArray + " to " + maxValueInArray + "\n");
                    continue;
                }
            } catch (Exception e) {
                System.err.println("choose correct Integer value" + "\n");
                scanner.next();
                continue;
            }
            try {
                setCoordinates(number);
                break;
            } catch (PositionAlreadyTakenException e) {
                System.err.println("Position already taken! Try another one" + "\n");
            }
        }
    }
}
