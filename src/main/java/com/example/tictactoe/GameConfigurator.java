package com.example.tictactoe;

import java.util.Scanner;

public class GameConfigurator {

    private int chosenNumberGamePattern;
    private int chosenNumberGameMode;
    private int rows;
    private int columns;
    private char array[][];


    public void initialGreeting() {
        System.out.println("Welcome to Tic Tac Toe game" + "\n");
    }

    public void chooseGamePattern() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose game pattern:");

        System.out.println("Press 1 for 3x3 pattern");
        System.out.println("Press 2 for 5x5 pattern");
        try {
            chosenNumberGamePattern = scanner.nextInt();

            if (chosenNumberGamePattern == 1) {
                rows = 3;
                columns = 3;
                array = new char[rows][columns];
            } else if (chosenNumberGamePattern == 2) {
                rows = 5;
                columns = 5;
                array = new char[rows][columns];
            } else {
                throw new Exception("choose correct game pattern");
            }
        } catch (Exception e) {
            chooseGamePattern();
        }
    }

    public void chooseGameMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose game mode:");

        System.out.println("Press 1 for singleplayer mode");
        System.out.println("Press 2 for multiplayer mode");

        try {
            chosenNumberGameMode = scanner.nextInt();
            if (chosenNumberGameMode == 1) {
                SinglePlayerMode singlePlayerMode = new SinglePlayerMode(rows, columns);
                singlePlayerMode.play();
            } else if (chosenNumberGameMode == 2) {
                MultiPlayerMode multiPlayerMode = new MultiPlayerMode(rows, columns);
                multiPlayerMode.play();
            } else {
                throw new Exception("choose correct game mode");
            }
        } catch (Exception e) {
            chooseGameMode();
        }
    }

    public void showRules() {
        System.out.println("RULES:"+"\n");
        System.out.println("select the appropriate number to place a mark there" + "\n");
        char count = '0';

        //initialize 2D Array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                count++;
                array[i][j] = count;
            }
        }
        //show 2D Array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == columns - 1) {
                    System.out.print(" | " + array[i][j] + " | ");
                } else
                    System.out.print(" | " + array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}