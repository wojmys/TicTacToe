package com.example.tictactoe;

public class MultiPlayerMode extends PlayerMode {

    public MultiPlayerMode(int rows, int columns) {
        super();
        this.rows=rows;
        this.columns=columns;
        checkPattern();
        XOArray = new char[rows][columns];
        setArray();
    }

    @Override
    public void chooseCoordinates() {

        while (true) {
            int row;
            int col;
            System.out.println("\n"+getPlayer()+" : please choose a row");

            try {
                row = scanner.nextInt();

                if ((row < 0) || (row > rows-1)) {
                    System.out.println("choose value from " + 0 + " to " + (rows-1) + "\n");
                    continue;
                }
            } catch (Exception e) {
                System.err.println("choose value from " + 0 + " to " + (rows-1) + "\n");
                scanner.next();
                continue;
            }
            try {
                System.out.println("\n"+getPlayer()+" : please choose a column");
                col = scanner.nextInt();

                if ((col < 0) || (col > columns-1)) {
                    System.out.println("choose value from " + 0 + " to " + (columns-1) + "\n");
                    continue;
                }
            } catch (Exception e) {
                System.err.println("choose value from " + 0 + " to " + (columns-1) + "\n");
                scanner.next();
                continue;
            }
            try {
                setCoordinates(row,col);
                break;
            } catch (PositionAlreadyTakenException e) {
                System.err.println("Position already taken! Try another one" + "\n");
            }
        }
    }
}
