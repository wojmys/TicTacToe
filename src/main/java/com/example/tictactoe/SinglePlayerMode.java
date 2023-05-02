package com.example.tictactoe;

import java.util.Random;

public class SinglePlayerMode extends PlayerMode {

    Random random = new Random();

    public SinglePlayerMode() {
    }

    public SinglePlayerMode(int rows, int columns) {
        super();
        checkPattern();
        XOArray = new char[rows][columns];
    }

    @Override
    public void chooseCoordinates() {

        while (true) {
            int number;

            if (!player) {
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
            }else{
                number=random.nextInt(maxValueInArray-minValueInArray+1)+minValueInArray;
                try {
                    setCoordinates(number);
                    break;
                } catch (PositionAlreadyTakenException e) {
                    dontPrint=true;
                    break;
//                    continue;
                }
            }
        }
        }

    }

