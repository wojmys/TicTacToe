package com.example.tictactoe;

public class View {


    public void presentWinner(String playerWinner) {
        if (playerWinner.equals("draw")) {
            System.out.println("Draw !" + "\n");
        } else {
            System.out.println("The winner is: " + playerWinner + "\n");
        }
    }

    public void presentArray(char[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == array.length - 1) {
                    System.out.print(" | " + array[i][j] + " | ");
                } else
                    System.out.print(" | " + array[i][j]);
            }
            System.out.println();
        }

    }
}


