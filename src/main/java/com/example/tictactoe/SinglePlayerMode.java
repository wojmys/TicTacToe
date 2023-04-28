package com.example.tictactoe;

public class SinglePlayerMode implements PlayerMode {

    private int playerNumber;

    private int rows;
    private int columns;
    private char[][] XOArray;

    public SinglePlayerMode() {

    }

    public SinglePlayerMode(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        XOArray = new char[rows][columns];
    }

    @Override
    public void checkPattern() {

    }

    @Override
    public void play() {

    }

    @Override
    public void chooseCoordinates() {

    }



    @Override
    public int getColumns() {
        return 0;
    }

    @Override
    public char[][] getXOArray() {
        return new char[0][];
    }

    @Override
    public void setCoordinates(int number) {

    }


}
