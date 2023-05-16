package com.example.tictactoe;

import java.util.Random;

public class SinglePlayerMode extends PlayerMode {

    Random random = new Random();

    public SinglePlayerMode(int rows, int columns) {
        super();
        this.rows=rows;
        this.columns=columns;
        checkPattern();
        computerAsPlayer2=true;
        XOArray = new char[rows][columns];
        setArray();
    }

    @Override
    public void chooseCoordinates() {
        while (true) {
            int row;
            int col;

            if (!player) {
                System.out.println("\n"+getPlayer()+" : please choose a row");
                try {
                    row = scanner.nextInt();

                    if ((row < 0) || (row > rows)) {
                        System.out.println("choose value from " + 0 + " to " + rows + "\n");
                        continue;
                    }
                } catch (Exception e) {
                    System.err.println("choose correct Integer value" + "\n");
                    scanner.next();
                    continue;
                }
                System.out.println("\n"+getPlayer()+" : please choose a column");
                try {
                    col = scanner.nextInt();

                    if ((col < 0) || (col > columns)) {
                        System.out.println("choose value from " + 0 + " to " + columns + "\n");
                        continue;
                    }
                } catch (Exception e) {
                    System.err.println("choose correct Integer value" + "\n");
                    scanner.next();
                    continue;
                }
                try {
                    setCoordinates(row,col);
                    break;
                } catch (PositionAlreadyTakenException e) {
                    System.err.println("Position already taken! Try another one" + "\n");
                }
            }else{
                row=random.nextInt(rows);
                col=random.nextInt(columns);
                try {
                    setCoordinates(row,col);
                    break;
                } catch (PositionAlreadyTakenException e) {
                    dontPrint=true;
                    break;
                }
            }
        }
        }
    }

