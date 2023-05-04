package com.example.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class GameConfigurator {

    private int chosenNumberGamePattern;
    private int chosenNumberGameMode;
    private int rows;
    private int columns;
    private int arrayToPresentRules[][];


    public void initialGreeting() {
        System.out.println("Welcome to Tic Tac Toe game" + "\n");
    }

    public void chooseGamePattern() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose game pattern:");

        System.out.println("Press 1 for 3x3 pattern");
        System.out.println("Press 2 for 10x10 pattern");
        try {
            chosenNumberGamePattern = scanner.nextInt();

            if (chosenNumberGamePattern == 1) {
                this.rows = 3;
                this.columns = 3;
                arrayToPresentRules = new int[rows][columns];
            } else if (chosenNumberGamePattern == 2) {
                this.rows = 10;
                this.columns = 10;
                arrayToPresentRules = new int[rows][columns];
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
        int count = 0;

        //initialize 2D Array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                count++;
                arrayToPresentRules[i][j] = count;
            }
        }

       // show 2D Array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == columns - 1) {
                    System.out.print(" | " + arrayToPresentRules[i][j] + " | ");
                } else
                    System.out.print(" | " + arrayToPresentRules[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}