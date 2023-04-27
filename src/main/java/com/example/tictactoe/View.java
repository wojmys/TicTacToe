package com.example.tictactoe;

import java.util.Scanner;

public class View {

    private PlayerMode playerMode;
    private int gamePattern;
    private int gameMode;


    public void presentWinner(String playerWinner) {
        if (playerWinner.equals("draw")) {
            System.out.println("Draw !" + "\n");
        } else {
            System.out.println("The winner is: " + playerWinner + "\n");
        }
    }

    public void presentArray(char[][] array) {
        if (gameMode == 1) {
            playerMode = new SinglePlayerMode();

        } else {
            playerMode = new MultiPlayerMode();

        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == playerMode.getColumns() - 1) {
                    System.out.print(" | " + playerMode.getXOArray()[i][j] + " | ");
                } else
                    System.out.print(" | " + playerMode.getXOArray()[i][j]);
            }
            System.out.println();
        }

    }
}


